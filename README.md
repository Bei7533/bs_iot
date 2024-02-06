# README

ZJU 2023 B/S project

这个版本没事实现dockers部署

### 安装和部署

##### 1 后端服务

1. 打开 `backend/src/main/resources/application.yml` 文件，配置数据库连接信息，包括数据库URL、用户名和密码。
2. 运行`database_build`目录下的sql文件新建数据库和表格。
3. 在项目根目录下，打开命令行终端。如果没有安装mvn需要进行安装：

~~~shell
 mvn install
~~~

4. 运行以下命令构建并启动后端服务：

```shell
cd backend/target
java -jar backend-0.0.1-SNAPSHOT.jar
```

5. 后端服务将在默认端口 `8088` 上启动。

##### 2 前端服务

1. 在项目根目录下，打开命令行终端。

2. 运行以下命令启动前端应用：

   ```shell
   cd frontend
   npm install  # 第一次运行需执行此命令安装依赖
   npm run serve
   ```

3. 前端应用将在默认端口 `8080` 上启动。

​	其他详细步骤请查看report文件夹下的运行指南文件进行项目的配置和运行。

##### 3 网站访问

1. 打开的浏览器，并访问 [http://localhost:8080](http://localhost:8080/)，现在可以使用物联网设备管理网站了

##### 4 服务器部署

1.  打开 `server/src/main/resources/application.yml` 文件
   1. 配置数据库连接信息，包括数据库URL、用户名和密码。
   2. 配置mqtt服务器连接信息，包括设置自己的用户名和密码。
