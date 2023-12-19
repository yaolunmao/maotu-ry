# maotu-ry

该项目为[maotu](http://mt.yaolm.top/)组态引擎库集成至若依的使用示例

## 声明
本演示站点只是借助若依展示`maotu`集成到自己项目中的效果，仅仅对若依框架进行了简单改动。本站点所用到的`svg`文件均来自网络，请勿将其用于商业用途  

本演示站点的源码请在此进行下载

[gitee](https://gitee.com/yaolunmao/maotu-ry)
[github](https://github.com/yaolunmao/maotu-ry)

# 使用教程

## 开发环境

### 使用docker（推荐）

```shell
# 从项目根目录进入到docker目录
cd docker
# 部署mysql服务和redis服务
docker-compose -f docker-compose-dev.yml up -d
# 然后启动后端项目和前端项目即可
# 访问http://localhost:8877/用户名admin密码admin123
```

### 不使用docker

1. 将`docker`文件夹的`webtopo-demo.sql`脚本导入到您的`mysql`数据库
2. 修改`ruoyi-admin\src\main\resources\application-druid.yml`文件第`9-11`行，将其修改为您的数据库连接
3. 修改`ruoyi-admin\src\main\resources\application.yml`文件`73-79`行，将其修改为您的`redis`连接
4. 然后启动后端项目和前端项目即可
4. 访问http://localhost:8877/用户名`admin`密码`admin123`

## 生产环境

### 使用docker（推荐）

1. 使用`pnpm run build:prod`部署好前端之后将`dist`文件夹里面的内容全部复制到`docker/frontend`目录下
2. 修改`ruoyi-admin\src\main\resources\application-druid.yml`文件第`7-17`行，将`docker数据源`的配置`${DATABASE_HOST}:3306`替换`开发数据源`的配置:`127.0.0.1:3366`
3. 修改`ruoyi-admin\src\main\resources\application.yml`文件`73-79`行，将`docker`的`host`:`${REDIS_HOST}`替换默认的`host`:`127.0.0.1`
4. 运行脚本`bin\package.bat`构建后端项目，将在目录`ruoyi-admin\target\`生成的`ruoyi-admin.jar`文件复制到docker目录下
5. 进入到`docker`文件夹执行`docker-compose up -d`
6. 等待容器全部启动之后访问http://localhost:8888/

### 不使用docker

1. 点开关系好的懂实施的朋友的头像
2. 发送：在吗？
3. 叫他帮忙部署一下
