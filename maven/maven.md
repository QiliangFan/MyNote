# 项目生命周期管理、构建工具

**Ant \ Maven(依赖管理-jar包、Gradle**

## 1. Maven的安装构建、及其于eclipse、idea的关联

### 	1. 下载：maven.apache.org

### 	2. 安装=》解压

## 2. maven文件下，cmd后缀的可在windows下执行，无后缀的可在linux下执行

## 3. 配置环境变量：

​		**M2_HOME**   //为maven2 用的

​		**MAVEN_HOME**

​		**PATH中添加：%MAVEN_HOME%/bin**

#### 		验证安装：cmd中输入  mvn -version

#### 		配置maven本地仓库：默认在C:\Users\\<usr>\\.m2

​				**配置本地仓库，放置在新位置。**

​				修改方法：在maven二进制文件的conf目录下的settings.xml文件下

修改<localRepository>中的值，注意路径最好是反斜杠，不然会有转义

​		E:/MavenHub/.mw/repository

## 4. eclipse 关联maven环境

​	Preference 下Maven  -installations- add-》选择根目录

​												-UserSetting  GlobalSettings路径要为自己的！			

​																		UserSettings 为.m2下的settings

​											如果配置正常，local repository就会显示自己想要的路径

## 5. Intelli idea 关联maven环境

​	Build，Execution，Deployment-》build tools -》Maven

​	配置一下maven根目录，和maven配置文件目录



## 6. 用Maven创建项目（一种和起初做法衔接的过渡操作

#### 	1. 新建动态的web项目（注意最好用web.xml 3.0)

#### 	2. 将其转化为Maven项目（对项目右键，configuration-》convert to maven project）

#### 	3. groupid 就是maven项目的仓库id

#### 		artifact id  文档名称



## 4. pom.xml是maven 最重要的配置文件

#### 	（project  object model）



#### 搜索jar包，后面加  mvn，表示从maven中心仓库中搜索jar包

#### 在package标签下，build标签上，加jar包的依赖描述

####  5. 创建MyBatis项目：

​			引入MyBatis依赖。MyBatis-***.jar













#### 