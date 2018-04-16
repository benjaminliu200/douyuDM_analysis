### 抓取斗鱼弹幕入库
    此程序为武汉斗鱼网络科技有限公司提供给第三方获取其直播间弹幕的样例程序。

#####特别声明：
    1、最终所有权归武汉斗鱼网络科技有限公司（2016）所有。
    2、此程序只能用于学习，禁止任何商业用途

#####使用说明：
    1、建议JDK版本选择1.6及以上版本进行编译。
    2、本项目基于Maven项目构建，使用Maven项目导入后，使用Debug模式运行DyBulletScreenApplication启动类即可。

#####**注意：**
    如果不想使用maven对项目进行管理，导入源文件后，请注意需要在构建路径中增加以下2个依赖包才能运行：
    1）commons-lang3-3.3.2  apache提供的字符串处理包
		
    2）log4j-1.2.14	日志包

#### 2018-04-13 改进，添加kafka消息队列，使用多消费者
    自己改版加入kafka队列，生产者消费者模型实现弹幕入库
    启动流程
        1、导入sql文件，执行sql
        2、本机安装kafka，kafka默认由zookeeper管理
        3、启动zookeeper管理服务:./bin/zookeeper-server-start.sh config/zookeeper.properties ，
        启动启动kafka:./bin/kafka-server-start.sh config/server.properties
        启动该项目:运行DyBulletScreenApplication