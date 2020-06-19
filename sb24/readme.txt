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

Reference
https://blog.csdn.net/u010502101/article/details/78823056