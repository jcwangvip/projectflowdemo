# projectFlowDemo

##关于springboot
```
文件application.properties 和 application.yml 文件中谁会覆盖谁?
答案:properties会覆盖yml文件->可以看restService中端口号的最后结果

```
##关于测试
```
测试的时候不要多个地方保存数据
原因:单个测试方法是没问题,但是package的时候打印出来就是大于0的
```

##加入表单验证
```
尽量用javax.validation.constraints包下的注解
```
##关于springDataJpa查询问题
```
1.不要私有化实体对象的无参构造方法 
原因:会造成getOne(id)方法异常
现象:java.lang.InstantiationException: com.example.springbootdemo.restfuldemo.pojo.bean.UserEntity$HibernateProxy$RdR8KJ4Z
```
##关于@Scheduled(cron = "${dateValue}")
```
1.在springBoot 1中,直接在方法上加上就能用,
    在springBoot2中,还要多加一个@EnableScheduling注解,加载当前类上和启动类上都行,
    建议加载启动类上
    
```