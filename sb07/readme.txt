

Digest
1. JSR303是校验api，即validation-api-1.1.0.final.jar
2. Spring Boot支持JSR303/JSR349验证框架，通过注解实现对参数的校验，并将校验结果封装成BindingResult对象
3. 相关注解
@Validated //spring的，支持分组
@Valid //
@Null //必须为空
@NotNull //必须不为空
...
4. 使用在vo上的属性上
5. 使用在controller的方法参数上，@Validated
6. 分组groups={Add.class, Update.class}
7. 可以使用在单个方法参数上
8. 自定义校验注解 @Gender, GenderValidator
9. 多个方法参数 methodName(param1,bindingresult, param2, bindingresult2...)
10. 嵌套校验
方法参数使用@Validated或@Valid，属性为对象且需要校验时使用@Valid
11. 配置提示信息
12. 手动校验
@Autowired
private Validator validator;
Set<ConstraintViolation<User>> validate = validator.validate(user, User.Add.class);
13. @Pattern

References
//SpringBoot | 第八章：统一异常、数据校验处理
https://blog.lqdev.cn/2018/07/20/springboot/chapter-eight/
https://blog.csdn.net/weixin_38229356/article/details/82933406