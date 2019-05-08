
Digest
1. filter,interceptor,listener
2. 过滤器配置的三种方式
    a) @WebFilter和@ServletComponentScan
    b) 定义Filter，使用FilterRegistrationBean注册filter
    c) 使用@Component 和@Order 注解注册
3. 已注册了filter和interceptor时的打印顺序
    before chain.doFilter(request, response) //在执行chain.doFilter方法之前
    preHandle //进入拦截器，执行controller之前调用
    postHandle //执行完controller逻辑，在controller的return ModelAndView之前执行，可以操控ModelAndView的值
    LogCostInterceptor Execute cost time: 2011ms //打印耗时
    afterCompletion //controller的return之后，但是在filter返回client之前执行
    LogCostFilter Execute cost time: 2017ms //打印耗时
    after chain.doFilter(request, response) //服务端逻辑全部执行完成，返回给客户端之前的逻辑
4. 使用@ConditionalOnProperty注解可以配置filter,interceptor是否有效
5. filter,interceptor,listener的注册方式
6. servlet的注册方式

References
https://www.concretepage.com/spring-boot/spring-boot-filter
https://cloud.tencent.com/developer/article/1362809
http://www.cnblogs.com/paddix/p/8365558.html
https://blog.csdn.net/king_is_everyone/article/details/53116744