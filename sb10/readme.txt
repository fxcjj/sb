
Digest
1. CommandLineRunner/ApplicationRunner
    项目启动时初始化，可使用@Autowired引入依赖
2. jwt包含三部分
    2.1 header = '{"alg":"HS256","typ":"JWT"}'
    2.2 payload = '{"loggedInAs":"admin","iat":1422779638}'//iat表示令牌生成的时间
    2.3 signature = HMAC-SHA256(encodeBase64(header) + '.' + encodeBase64(payload), secret)
3. Audience是jwt配置
4. JwtFilter添加需要拦截的url，如果除login之外都要拦截，有点麻烦
5. 使用公钥（验签）、私钥（签名）参考sb11项目


References
//jwt过期问题
https://mp.weixin.qq.com/s/NUiFBo0URyacB4BnuS5ntw
https://segmentfault.com/a/1190000012874052
https://www.jianshu.com/p/fcc1a6482143?from=timeline
https://www.jianshu.com/p/af8360b83a9f