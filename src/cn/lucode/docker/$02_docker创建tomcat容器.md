# 1. 目标
* 在 Ubuntu 宿主服务器上创建一个 tomcat7的 docker 容器


*  在 tomcat 上部署一个简单的 javaweb 项目（war 形式部署）

#  2.拉取并运行

```
docker run -d --name tomcat -p 8888:8080 registry.cn-hangzhou.aliyuncs.com/youdao/tomcat
```
## 2.1 说明
> docker 在 run 的时候如果没这个镜像是直接去仓库里面拉取的,所以我们直接 run 让他拉取之后直接运行（省到一步docker pull）

> 仓库是阿里云提供的，所以如果服务器实在阿里云上的速度会很快

> 将 docker 容器中的 tomcat端口8080 映射到宿主计算机端口的8888

> --name 表示命名这个容器

## 2.2 测试是否运行成功
### 2.2.1
docker ps 如果容器正在运行（容器名就是刚刚取的那个）表示成功
### 2.2.2
上面一步成了基本就没有问题了，
在浏览器中输入 ip 加端口 8888 能看到可爱tomcat启动界面
### 2.2.3
如果实在虚拟机上测试的话，输入 ifconfig 就能看到 ip,
按照2.2.2的步骤走一遍就行了

# 3. 创建一个javaweb项目打包成war
[$16_IDEA注解方式Servlet并打包war](https://github.com/luyunfeng/MyNotes/blob/master/src/cn/lucode/java/%2411_servlet/%2416_IDEA%E6%B3%A8%E8%A7%A3%E6%96%B9%E5%BC%8FServlet%E5%B9%B6%E6%89%93%E5%8C%85war.md)

目录
MyNotes/src/cn/lucode/java/$11_servlet/$16_IDEA注解方式Servlet并打包war.md

# 4. war发布到tomcat中

## 4.1进入容器
以交互方式
```
docker exec -it  tomcat  /bin/bash
```
tomcat 是容器的名字
## 4.2 将项目copy到webapps目录下
进去容器里的tomcat目录
找到 webapps 目录
```
/usr/local/tomcat/webapps
```
然后退出容器,copy项目到 webapps 目录下
```
docker cp /home/lucode/Desktop/Test.war  tomcat:/usr/local/tomcat/webapps
```

# 5. 运行查看结果

在浏览器中输入
ip:8888/Test
