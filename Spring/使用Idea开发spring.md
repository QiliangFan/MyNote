# 1. 环境配置:

- java jdk的配置
- maven 的配置
- tomcat 的配置

# 2. Idea配置:

1. 配置jdk和libraries :

   ​	File -> Project Structrue

2. 配置Maven:

   ​	File -> Settings -> Build, Execution,Deployyment -> Maven

   ​	选择本地仓库位置,  选择maven配置文件settings.xml位置

3. 创建Maven项目:

   记住勾选{ Create from archetype }  =>  选择  webapp的骨架

4. 配置工程目录

   src/main下,新建java  . resource  , 分别mark as  Sources root 和 Resources root

   新建test , test下新建 java, java文件夹 mark as => Test Sources root

5. Add Configuration

   添加Tomcat配置