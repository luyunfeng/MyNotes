# 1. Ubuntu 环境下安装配置 Docker
## 1.1 系统版本要求
最低支持12.04 LTS，推荐 14.04 LTS
我这里安装的时候使用了 16.04 LTS

如果使用12.04 LTS版本，首先要更新系统内核和安装可能需要的软件包，包括：
```
linux-image-generic-lts-trusty（必备）
linux-headers-generic-lts-trusty（必备）
xserver-xorg-lts-trusty（带图形界面时必备）
libgl1-mesa-glx-lts-trusty（带图形界面时必备）
```
另外，为了让Docker使用aufs存储，推荐安装linux-image-extra软件包。
```sudo apt-get install -y linux-image-extra-$(uname -r)```

> Ubuntu发行版中，LTS（Long-Term-Support）意味着更稳定的功能和更长期（目前为5年）的升级支持，生产环境中尽量使用LTS版本。

## 1.2 添加镜像源更新系统
### 1.2.1 安装apt-transport-https
首先需要安装apt-transport-https包支持HTTPS协议的源：
```
sudo apt-get install -y apt-transport-https
```
### 1.2.2 添加源的gpg密钥：
```
sudo apt-key adv --keyserver hkp://p80.pool.sks-keyservers.net:80
--recv-keys 58118E89F3A912897C070ADBF76221572C52609D
```
### 1.2.3 获取当前操作系统的代号
```
lsb_release -c
```
显示出：```Codename:trusty```

一般情况下，12.04（LTS）代号为precise，14.04（LTS）代号为trusty，
15.04代号为vivid，15.10代号为wily。

我的显示：```Codename:xenial```
### 1.2.4 添加 apt 软件源
添加Docker的官方apt软件源
通过下面的命令创建
/etc/apt/sources.list.d/docker.list文件，并写入源的地址内容。

```
sudo vim /etc/apt/sources.list.d/docker.list
```

添加（非trusty版本的系统注意修改为自己对应的代号1.3.3）

```
deb https://apt.dockerproject.org/repo ubuntu-trusty main
```

### 1.2.5 更新apt软件包缓存

```
sudo apt-get update
```

在成功添加源之后，就可以安装最新版本的Docker了。

## 1.3 开始安装Docker
软件包名称为docker-engine：
```
sudo apt-get install -y docker-engine
```

如果系统中存在较旧版本的Docker（lxc-docker），会提示是否先删除，选择“是”即可。
除了基于手动添加软件源的方式，也可以使用官方提供的脚本来自动化安装Docker：
```
sudo curl -sSL https://get.docker.com/ | sh
```

安装成功后，启动docker服务，见文章最后


# 2. CentOS环境下安装Docker
这里面就简单说一下，和上面的方法类似。
系统的要求与Ubuntu情况下类似：64位操作系统，内核版本至少为3.10。
Docker目前支持CentOS 6.5及以后的版本，推荐使用CentOS 7系统。
首先，也是要添加yum软件源：
```
$ sudo tee /etc/yum.repos.d/docker.repo <<-'EOF'
[dockerrepo]
name=Docker Repository
baseurl=https://yum.dockerproject.org/repo/main/centos/$releasever/
enabled=1
gpgcheck=1
gpgkey=https://yum.dockerproject.org/gpg
EOF
```

之后更新yum软件源缓存，并安装docker-engine：
```
sudo yum update
sudo yum install -y docker-engine
```
对于CentOS 7系统，CentOS-Extras源中已内置Docker，如果已经配置了CentOS-Extras源，可以直接通过上面的yum命令进行安装。


# 3. 通过脚本安装
其实就是无脑一键安装吧....

使用官方提供的shell脚本来在Linux系统
（目前支持Ubuntu、Debian、Oracleserver、Fedora、Centos、OpenSuse、Gentoo等常见发行版）
上安装Docker的最新正式版本，该脚本会自动检测系统信息并进行相应配置：
```
$ curl -fsSL https://get.docker.com/ | sh
```
或者：
```
$ wget -qO- https://get.docker.com/ | sh
```
如果想尝鲜使用最新功能，可以使用下面的脚本来安装预发布版本。
但要注意，预发布版本往往意味着功能还不够稳定，不要在生产环境中使用：
```
$ curl -fsSL https://test.docker.com/ | sh
```
另外，也可以从github.com/docker/docker/releases找到所有的发行版本信息和二进制包，自行下载使用。

# 4. 启动和的配置
## 4.1 启动
```
sudo service docker start
```
## 4.2 验证是否启动成功
输入
```
sudo docker version
```
会看到版本信息，就表示成功
Client 和 Service 都出现
## 4.3 关闭
```
sudo service docker stop
```
## 4.4 最后

安装上述步骤安装的话会出现，每次使用docker 的时候都要特权身份运行。
很麻烦。
如何解决呢？
可以将当前用户加入安装中自动创建的docker用户组：
```
$ sudo usermod -aG docker USER_NAME
```
USER_NAME是你的用户名
用户更新组信息后，退出并重新登录后即可生效。



