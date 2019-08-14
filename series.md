# series:=>(只说明一个line类型的,其余类比着查阅文档)

## * type(line):'line'

## * id:

## * name:

## * coordinateSystem('caresian2d'):  'caresian2d' | 'polar'

## * xAsixIndex(0)

## * yAxisIndex(0)

## *polarIndex(0)

## * symbol('emptyCircle') :  'circle' | 'rect' |'roundRect' |'triangle' |'diamond' |'pin' |'arrow' | 'none'  |  'image://<url>'

## * symbolSize(4):  可以是单一数字, 也可以是数组[长,宽],也支持回调函数:

(value:Array|number,  params :Object ) => number| array

第一个参数value 为data中的数据值, 第二个参数params是其他的数据项参数

## * symbolRotate: 旋转角度

## * symbolKeepAspect: 是否在缩放时保持长宽比

## * symbolOffset([0,0]):

## * showSymbol(true): 是否显示symbol, 为false则只有在tooltip hover时显示

## * showAllsymbol('auto') :   'auto'|false| true

## * hoverAnimation(true): 开启hover 在拐点标志上的提示动画效果

## * legendHoverLink(true): 是否启用图例 hover时的联动高亮

## * stack(null): (其实并不在这里配置,开启后会当前数组会堆叠在上一个数据之上)

## * cursor('pointer') : 鼠标悬浮时的样式, 同css的cursor

## * connectionNulls(false): 是否链接空数据

## * clipOverflow(true): 是否对超出部分裁剪, 默认裁剪

## * step(false):  false | true  |  'start'  |  'middle' | 'end'  (表示数据点在阶梯的位置)

## *  label:关于图形数据信息的说明标签:

### 	show:

### 	position: [x,y]  ->[10,10]  \  [50%,50%]  | 'top' |'left' ...

### 	distance(5): 距离图形元素的距离, position为字符描述(字符串)时有效

### 	rotate: 从-90到90度,旋转标签

### 	offset: [30,40] x轴向右30, y轴向下平移40

###  	formatter:支持字符串魔板和回调函数两种形式, 返回的字符串支持用 \n换行 

~~~json
{a} :系列名
{b} : 数据名
{c} : 数据值
{@xxx}: 数据中名为'xxx'的维度的值
{@[n]} :从0开始计数, 数据中维度n的值
//回调函数可以查文档
~~~

### 	color("#fff"):  'auto' |...

### 	fontStyle: 'normal' | 'italic' | 'oblique'

### 	fontWeight: 

### 	fontFamily:

### 	...

## * itemStyle: 折线拐点标志的样式(有子配置)

## * lineStyle: 线条样式(有子配置)

## * areaStyle: 区域填充样式(有子配置)

## * emphasis :图形高亮样式(有子配置)

## * smooth(false): false | true(0.5) | 0-1 平滑程度

## * smoothMonotone: 是否在某一维度上保持单调, 'x'|'y'|'none'

## * sampling: 'average' | 'max' |'min' |'sum' 数据量过大时降采样策略,优化绘制效率

## * dimensions->Array: 配置每个维度的信息

## * encode: 定义data的哪个维度被使用的方式

## * seriesLayoutBy('column') : 当使用dataset时, seriesLayoutBy指定了dataset中是用行还是用列对应到系列上

## * dataIndex(0) :datasetIndex 指定本系列使用哪个dataset

## * data[i] : 系列中数据内容的数组

~~~json
series: [{
    data: [
        // 维度X   维度Y   其他维度 ...
        [  3.4,    4.5,   15,   43],
        [  4.2,    2.3,   20,   91],
        [  10.8,   9.5,   30,   18],
        [  7.2,    8.8,   18,   57]
    ]
}]
~~~

## * markPoint: 图表标注的配置

## * markLine: 图表标线的配置

## * markArea:标记图表中某个返回的数据

## * zlevel:

## * z

## * animationThreshold(2000): 当单个系列图形数量大于多少时关闭动画

## * animationDuration(1000):动画时长, 支持回调函数

~~~javascript
animationDuration:function(idx){
    return idex*100;
}  //越往后的数据延迟越大
~~~

## * anmationEasing('linear'): 初始动画的缓动效果

## * animationDelay(0): 初始动画的延迟, 支持回调函数

~~~javascript
animationDelay: function(idx){
    return idx* 100;
}
~~~

## * animationDurationUpdate(300):数据更新时动画的时长

## * animationEasingUpdate('cubicOut'): 数据更新时的动画的缓动效果

## * animationDelayUpdate(0):数据更新动画的延迟,支持回调函数

## *tooltip: 本系列特定的tooltip