
Digest
1. Swagger2Config
2. 各种注解
@Api：修饰整个类，描述Controller的作用
@ApiOperation：描述一个类的一个方法，或者说一个接口
@ApiParam：单个参数描述
@ApiModel：用对象来接收参数
@ApiProperty：用对象接收参数时，描述对象的一个字段
@ApiResponse：HTTP响应其中1个描述
@ApiResponses：HTTP响应整体描述
@ApiIgnore：使用该注解忽略这个API
@ApiError ：发生错误返回的信息
@ApiImplicitParam：一个请求参数
@ApiImplicitParams：多个请求参数
3. paramType是什么，这里说明以下这个坑。
paramType的参数有以下几种方式：
header：请求参数放置于Request Header，使用@RequestHeader获取
query：请求参数放置于请求地址，使用@RequestParam获取
path：（用于restful接口）-->请求参数的获取：@PathVariable
body（一般不用）
form（一般不用）
注意：这个paramType必须对应才能在最后展示的接口文档界面发送请求。
4. 访问地址
http://ip:port/swagger-ui.html
5.在Spring Boot中使用swagger-bootstrap-ui
左右菜单样式
https://blog.csdn.net/u010192145/article/details/79216037

References
//SpringBoot | 第十章：Swagger2的集成和使用
https://blog.lqdev.cn/2018/07/21/springboot/chapter-ten/
