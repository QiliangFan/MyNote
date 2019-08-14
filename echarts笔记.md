{echarts只能操作原生js的dom元素, 要注意jquery和原生js元素的转化}

~~~javascript
var e=$("#main")[0]   //原生js对象
var $e= $(e)   //jquery 对象
~~~

{注意下载echarts后, 在dist(distribution)文件夹下复制自己要的js文件,并引用}

# 1. Echarts 笔记:

## 1. tooltip:

	1. trigger: 当鼠标或键盘按下时,会在某一组件上触发事件 'axis', 'item', 'none'
 	2. axisPointer:

~~~javascript
axisPointer:{
    type: 'cross',  //type为 shadow 和 cross时不错 ,  'line' 感觉效果不是很好
     label:{
         backgroundColor: '#6a7985'
     }
}
~~~



## 2. toolbox:

 1. 通过show:false|true 确定是否显示

 2. 在feature中配置信息 :

     	1. dataZoom: yAxisIndex  和 xAxisIndex的配置(不配置默认都允许)
     	2. dataView:显示图表的源数据
     	3. magicType:切换图表类型

    ~~~json
    magicType:{
        type:['line', 'bar']
    }
    ~~~

    4. restore: 复原图表
    5. saveAsImage: 另存图片

    ## 3. xAxis  yAxis

    	1. type: 坐标轴类别
     	2. boundaryGap: 坐标轴数据的分割状态
     	3. axisLabel:

~~~json
axisLabel:{
    formatter: '{value} 度'
}
~~~

## 4 . series:

	1. areaSyle: 可实现坐标轴到折线的填充
 	2. stack: 相同名字的可以堆叠在一起

## 5. dataZoom

1. type("inside"):  'inside' | 'slider'  

   {内置的拖动坐标系即可拖动,  slider的会有一个滚动条}



