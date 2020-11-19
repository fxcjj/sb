1. PersonEndpoint为注解方式自定义端点
方法上的@ReadOperation, @WriteOperation, @DeleteOperation注解用于暴露方法，
分别对应生成Get/Post/Delete的Mapping。注解中的produces参数，可以指定media type, 如：application/json等。
这个端点的定义不再需要额外的代码，它可以通过/${base-path}/person和/${base-path}/person/{name}进行访问。
如：
http://localhost:2011/haha/person
http://localhost:2011/haha/person/mike
另外，这个端点同时还会自动部署为JMXMBean，可以通过像JConsole这样的JMX客户端来访问。

2. Endpoints 是 Actuator 的核心部分，它用来监视应用程序及交互，spring-boot-actuator中已经内置了非常多的Endpoints（health、info、beans、httptrace、shutdown等等），同时也允许我们扩展自己的端点。
Endpoints 分成两类：原生端点和用户自定义端点；自定义端点主要是指扩展性，用户可以根据自己的实际应用，定义一些比较关心的指标，在运行期进行监控。
原生端点是在应用程序里提供的众多 restful api 接口，通过它们可以监控应用程序运行时的内部状况。原生端点又可以分成三类：
应用配置类：可以查看应用在运行期间的静态信息：例如自动配置信息、加载的spring bean信息、yml文件配置信息、环境信息、请求映射信息；
度量指标类：主要是运行期间的动态信息，例如堆栈、请求连、一些健康指标、metrics信息等；
操作控制类：主要是指shutdown，用户可以发送一个请求将应用的监控功能关闭。

3. 使用Spring Security来保证Actuator Endpoints安全
在application.ym中配置如下
spring:
  security: # http安全机制
    user:
      name: vic
      password: vic
      roles: ADMIN
配置以上后，当访问 http://localhost:2011/haha 跳转到登录页面

参考
https://blog.csdn.net/weixin_43353498/article/details/89226101