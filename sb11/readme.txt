
Digest
1. CheckToken注解
2. InterceptorConfig拦截器配置
    要使用@Bean，不然CheckTokenInterceptor中取不到@Value标记的属性
3. JWTInfo封装用户登录信息
4. JWTHelper
    encodeToken方法生成token
    decodeToken方法解析token
    parseToken方法获取用户登录信息
5. RSAUtils工具类

References
https://www.cnblogs.com/jimisun/p/9482439.html