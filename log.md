spring项目：
1. spring-boot-starter-web排除spring-boot-starter-logging
2. 单独引入日志依赖，可以基于log4j-api，也可以基于slf4j-api
3. 最简单的做法，可以只引入log4j-slf4j2-impl，它会自带log4j-api、log4j-core、slf4j-api，scope要声明为implementation
4. log4j-slf4j2-impl可以把slf4j-api日志路由到log4j。如果第三方类库基于slf4j-api打日志，经过log4j-slf4j2-impl路由后，日志由log4j实现打印
5. 引入jul-to-slf4j，把jul桥接到slf4j，最终会被log4j-slf4j2-impl路由到log4j

slf4j定义了日志接口，可以有不同的实现。logback是最常见的实现，它直接实现了slf4j的接口，没有经过中间层转换。

log4j2实现也可以基于slf4j-api打日志，log4j-slf4j2-impl可以使log4j实现基于slf4j-api打日志。如果第三方类库用slf4j-api打日志，自己的应用基于log4j打日志，需要引入log4j-slf4j2-impl，把slf4j-api的日志路由到log4j2。

log4j-to-slf4j可以把基于log4j2-api的日志路由到slf4j的实现。

spring-boot-starter-log4j2使用log4j2-core作为日志实现，spring-boot-starter-logging使用logback-classic作为日志实现。