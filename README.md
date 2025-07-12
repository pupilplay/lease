## 项目概述
该项目以公寓管理，公寓租赁作为业务背景，包含用户端和后台管理系统。

## 项目技术概述与版本
### 前端
由资料取得，基本没有做修改，使用的是Vue3框架。

### 后端
==注：代码使用的依赖版本与仅供参考，部分插件新旧版本之间groupId或artifactId出现了更换。==
- 框架：SpringBoot(Springboot3)
- 数据库访问：mybatis-plus,spring data redis
> mybatis-plus是mybatis的增强版，有mybatis的核心功能以及一些简化开发，提升效率的功能。
- 接口文档：knife4j(集成Springboot)
> knife4j是swagger的一个美化增强版。
- 对象存储服务OSS：minio
> 对于对象存储，可以选择直接购买各大云厂商提供的服务，也可以选择使用开源的服务，自行安装和维护。本项目采用开源的对象存储Minio来存储图片信息。
- 其他小工具：easy-captcha（验证码生成），lombok(简化代码)，jwt（用于用户token）等等

### 数据库
==注：版本仅供参考，注意保证JDBC支持对应版本==
- MySQL: 8.0.42
- Redis: 7.0.15

## 项目调试与部署
##### **项目采用前后端分离架构。**
### 配置相关：
##### 前端
分别修改前端项目根目录下的.env.development和.env.production
```
VITE_APP_BASE_URL='http://xxx.xxx.xxx.xxx'
```

##### 后端
分别修改模块web-admin和web-app中resources目录下的application.yaml中的相关配置，具体地有mysql数据库地址，端口，用户名与密码；redis数据库地址，端口等。
### 运行调试
##### 前端
在前端对应项目根目录下执行
```
npm run dev
```

##### 后端
使用idea等集成开发工具打开项目运行即可
### 打包
##### 前端
在前端对应项目根目录下执行
```
npm run build
```
打包得到dist文件即可
##### 后端
在后端对项目根模块lease执行maven的clean和install，得到jar包，在安装了jdk17的服务器上运行即可。
### 部署
源码中不包含Nginx相关代码，自行配置Nginx代理即可。