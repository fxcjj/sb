package com.vic.sb31.component;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.Protocol;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.auth.sts.AssumeRoleRequest;
import com.aliyuncs.auth.sts.AssumeRoleResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * OSS组件
 * @author 罗利华
 * date: 2019/10/22 14:59
 */
@Slf4j
@ConditionalOnProperty(prefix = "oss", name = "enable", havingValue = "true")
public class OSSComponent {


    /**
     * id
     */
    @Value("${oss.access-key-id}")
    private String accessKeyId;

    /**
     * secret
     */
    @Value("${oss.access-key-secret}")
    private String accessKeySecret;

    /**
     * 区域
     */
    @Value("${oss.region}")
    private String region;

    /**
     * 域名
     */
    @Value("${oss.endpoint}")
    private String endpoint;

    /**
     * 存储空间
     */
    @Value("${oss.bucket}")
    private String bucket;

    @Value("${oss.sts-role-arn}")
    private String roleArn;

    @Value("${oss.sts-role-session-name}")
    private String roleSessionName;

    @Value("${oss.sts-policy}")
    private String policy;

    @Value("${oss.url-public}")
    private String urlPublic;

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return
     */
    @Bean
    public OSS ossClient() {
        // 创建ClientConfiguration实例，按照您的需要修改默认参数。
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();

        // 关闭CNAME选项。
        conf.setSupportCname(false);

        conf.setProtocol(Protocol.HTTPS);

        // 10分钟
        conf.setSocketTimeout(10 * 60 * 1000);

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret, conf);

        return ossClient;
    }

    public Map<String, String> getStsToken() throws ClientException {
        Map<String, String> respMap = new HashMap<>();
        // 添加endpoint（直接使用STS endpoint，无需regionId）
        DefaultProfile.addEndpoint("", "", "Sts", "sts.aliyuncs.com");
        // 构造profile（无需regionId）
        IClientProfile profile = DefaultProfile.getProfile("", accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);
        final AssumeRoleRequest request = new AssumeRoleRequest();
        request.setMethod(MethodType.POST);
        request.setRoleArn(roleArn);
        request.setRoleSessionName(roleSessionName);
        request.setPolicy(policy);
        final AssumeRoleResponse response = client.getAcsResponse(request);
        respMap.put("accessKeyId", response.getCredentials().getAccessKeyId());
        respMap.put("accessKeySecret", response.getCredentials().getAccessKeySecret());
        respMap.put("securityToken", response.getCredentials().getSecurityToken());
        respMap.put("Expiration", response.getCredentials().getExpiration());
        respMap.put("bucket", bucket);
        respMap.put("endpoint", endpoint);
        respMap.put("region", region);
        return respMap;
    }

    /**
     * 上传Base64文件
     *
     * @param base64Data
     * @param key
     * @return
     */
    public boolean uploadBase64(String base64Data, String key) {
        // 创建OSSClient实例
        OSS client = ossClient();
        try {
            // 图片数据解码
            byte[] asBytes = Base64.getDecoder().decode(base64Data.getBytes());

            //创建上传Object的Metadata
            PutObjectResult putResult = client.putObject(bucket, key, new ByteArrayInputStream(asBytes));

            //解析结果
            String etag = putResult.getETag();
        } catch (Exception e) {
            log.error("上传Base64文件异常：", e);
            return false;
        } finally {
            // 关闭client
            if (client != null) {
                client.shutdown();
            }
        }
        return true;
    }

    /**
     * 上传文本
     *
     * @param key
     * @param content
     * @return
     */
    public String uploadFile(String key, String content) {
        // 创建OSSClient实例
        OSS client = ossClient();
        try {
            if (StringUtils.isEmpty(key) || StringUtils.isEmpty(content)) {
                return null;
            }

            // 指定上传的内容类型。
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("text/plain");

            PutObjectResult putObjectResult = client.putObject(bucket, key, new ByteArrayInputStream(content.getBytes()), meta);

            String eTag = putObjectResult.getETag();

            log.info("执行ossClient.putObject方法结束, eTag:{}", eTag);

            return bucket + "/" + key;
        } catch (Exception e) {
            log.error("执行 uploadFile 方法异常:", e);
            return null;
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
    }


    /**
     * 获取文件信息
     *
     * @param filePath
     * @return
     */
    public String getObjectContent(String filePath) {
        // 创建OSSClient实例
        OSS client = ossClient();
        String content = null;
        InputStream inputStream = null;
        try {
            String key = "";
            if (filePath.startsWith(bucket)) {
                key = filePath.substring(bucket.length() + 1);
            } else {
                key = filePath;
            }

            OSSObject object = client.getObject(bucket, key);
            inputStream = object.getObjectContent();
            content = IOUtils.toString(inputStream, "utf-8");
        } catch (IOException e) {
            log.error("获取文件信息IO异常，异常信息：{}", e.getMessage());
        } finally {
            try {
                if (null != inputStream) {
                    inputStream.close();
                }
                if (client != null) {
                    client.shutdown();
                }
            } catch (IOException e) {
                log.error("获取文件信息IO异常，异常信息：{}", e.getMessage());
            }
        }
        return content;
    }

    /**
     * 向阿里云的OSS存储中上传文件
     *
     * @param ins
     * @param saveName
     * @return
     */
    public boolean upload(InputStream ins, String saveName) {
        try {
            // 创建OSSClient实例
            OSS client = ossClient();

            //创建上传Object的Metadata
            PutObjectResult putResult = client.putObject(bucket, saveName, ins);

            ins.close();

            //解析结果
            String etag = putResult.getETag();

            // 关闭client
            client.shutdown();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    /**
     * 从阿里云的OSS存储中删除文件
     *
     * @param saveName
     * @return
     */
    public boolean delete(String saveName) {
        try {
            // 创建OSSClient实例
            OSS client = ossClient();

            client.deleteObject(bucket, saveName);

            // 关闭client
            client.shutdown();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    /**
     * 阿里云的OSS存储中文件访问路径，图片访问使用
     *
     * @param savePath
     * @return
     */
    public String fmtAccessUrl(String savePath) {

        if (StringUtils.isEmpty(savePath)) {
            return "";
        }
        String imageUrl = urlPublic + "/" + savePath;

        return imageUrl;
    }



}
