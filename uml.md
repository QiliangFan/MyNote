# 1. UML建模模块

## 		1.事物

$$
\begin{cases}
结构事物 \\
行为事物 \\
分组事物 \\
注释事物 \\
\end{cases}
$$

​	

## 		2. 结构事物

### 1. 类:

~~~c#
类是具有相同属性\ 方法 \关系 和语义对象的集合
~~~

![1](/usr/local/Git/图例绘制/1.png)

### 2. 接口

~~~c#
接口是指类或组件提供的服务(操作), 描述了类或组件对外可见的动作:
~~~

![2](/usr/local/Git/图例绘制/2.png)

### 3. 协作

~~~c#
协作定义元素之间的相互作用:
~~~

![3](/usr/local/Git/图例绘制/3.png)

### 4. 用例

~~~c#
用例定义了执行者(在系统外部 和系统交互的人) 和被考虑系统之间交互来实现的一个业务目标
~~~

![4](/usr/local/Git/图例绘制/4.png)

### 5. 组件

~~~c#
组件描述物理系统的一部分
~~~

![5](/usr/local/Git/图例绘制/5.png)

### 6. 节点

~~~c#
一个节点可以被定义为在运行时存在的物理元素
~~~

## 3. 思路：4L原则

### L1：思考项目的系统类别，比如电子商城

### L2：分析角色，如消费者、管理员、商家

### L3：功能模块，如用户管理模块，购物活动，用户管理，商品管理

### L4：任务：每个模块更细致的子功能

### 说明：对每个任务的更详细的描述



### 4. UML图

![Map1](/usr/local/Git/图例绘制/Map1.jpg)

# 2. UML的使用:

## 1. 类图:

### 1. 类

![class1](/usr/local/Git/图例绘制/class1.png)

### 3. 对象

![class2](/usr/local/Git/图例绘制/class2.png)

(对象和类的唯一区别就是有下划线的名称, 实际上都可以等价使用)

### 3.接口

![class3](/usr/local/Git/图例绘制/class3.png)

### 4.用例

![clas4](/usr/local/Git/图例绘制/clas4.png)

### 5.角色

![class5](/usr/local/Git/图例绘制/class5.png)

### 6.状态:

![class61](/usr/local/Git/图例绘制/class61.png)

![class62](/usr/local/Git/图例绘制/class62.png)

### 7. 活动类:(一般描述系统的并发行为)

![class7](/usr/local/Git/图例绘制/class7.png)

### 8. 元素:

![class8](/usr/local/Git/图例绘制/class8.png)

