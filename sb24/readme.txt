1. aspectj
    a) Aop1 简单使用@Before,@After,@Around，打印执行顺序
    b) Aop2,Aop2Inter @annotaion的使用
    c) Aop3 测试@AfterReturning, @AfterThrowing
    d) Aop4 在@Around方法中catch异常后，处理返回结果
    e) Aop5 打印目标方法的参数信息
    f) Aop6 within用法
2. MyLog,MyLogAspect aop记录日志
3. 使用注解解决表单重复提交
    a) CheckRepeatSubmit 注解类
    b) CheckRepeatSubmitAspect 注解切面处理类
    c) RepeatSubmitController
4. 解决高并发下幂等性问题
    a) UserController
    b) 参考note\concurrency\idempotence.txt
5. 同一个方法两个注解
    a) ChargingApi 注解类
    b) Aop1Controller 测试controller
    c) Aop1,Aop11两个切面
    d) 当开启了Aop1,Aop11时，打印如下：
    Aop1 around before...@com.vic.sb24.annotation.ChargingApi(ignore=false, extraInfo=haha2)
    Aop11 around before...@com.vic.sb24.annotation.ChargingApi(ignore=false, extraInfo=haha2)
    Aop1Controller 执行结果...test2
    Aop11 around after...
    Aop1 around after...

Reference
https://blog.csdn.net/u010502101/article/details/78823056