1. spring boot, mybatis
2. baomidou 读写分离
3. 在application.yml配置文件中声明主库、从库数据源配置
4. 声明数据源常量
5. 使用@DS("slave_1")指定访问的从库，使用@DS("slave")访问所有从库，默认以轮询的方式
6. 测试类 com.vic.sb42.OrderMapperTests, com.vic.sb42.OrderServiceTests

References
https://blog.csdn.net/tuantuanyua/article/details/107559683