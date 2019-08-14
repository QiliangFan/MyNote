# 1. xAxis

## * show(true):是否显示x轴

## * grideIndex(0):x轴所在的grid的索引,默认位于第一个grid

## * position:  'top' | 'bottom' 默认grid中的第一个x轴在grid的下方,第二个x轴在另一侧

## * offset: x轴相对于默认位置的偏移, 在相同的 position 上有多个x轴时有用

## * type('category'):  'value' |  'category' | 'time'  | 'log' 

## * name:坐标轴名称

## * nameLocation("end"): 'start' | 'middle' | "center" | 'end'

## * nameTextStyle:  类似于textStyle

## * nameGap: 坐标轴与轴线之间的距离

## * nameRotate(null): 坐标轴名字旋转, 角度值

## * inverse(false): 是否反转坐标轴

## * boundaryGap:

~~~json
1. 类目轴中 boundaryGap 可以配置为 true 或 false, 默认为true: 此时刻度只是作为分割线, 所有标签和数据点都会在两个刻度之间的带(band)之间
2. 非类目轴, 包括时间, 数值, 对数轴, boundaryGap 是一个两个值的数组, 分别表示数据最小值和最大值的延伸范围, 可以直接设置或者相对的百分比, 但如果设置了 min  和max 则无效:
如  boundaryGap:[ '20%','20%']
~~~

## * min: 坐标轴刻度的最小值   'dataMin' 取数据最小值为min| <函数>

~~~json
min : function(value){
    return  value.min - 20;
}
~~~

## * max: 'dataMax'  |  <函数>

## * scale(false):  为true后坐标轴不会强制包含零刻度,  设置min和max后无效

## * splitNumber(5): 设置推荐的坐标轴分段数, 实际上会有所增减

## * minInterval(0): 自动计算坐标轴的最小间隔, 设置为1 可保证分割为整数

## * maxInterval: 在时间轴上 ,  设置为3600*24 *1000可以保证坐标轴最大分割刻度为1天  

## * interval: 强制设置坐标轴分割(不同类型坐标轴还要传入额外参数)

## * logBase(10): 对数轴的底数

## * silent(false): 坐标轴是否静态无法交互

## * triggerEvent(false):坐标轴的标签是否相应和触发鼠标事件, 默认不响应

## * axisLine : 有关坐标轴轴线的相关设置(查文档)

## * axisTick: 有关坐标轴刻度的相关设置

## * axisLabel: 坐标轴标签的相关设置

## * splitLine: 坐标轴在grid区域的分割线

## * splitArea : 坐标轴在grid区域的分隔区域

## * data[i]: 在设置了type:'category'时必须设定, 如果没有设置type, 但是设置了axis.data ,则会认为type是'category', 并且从data中取值

( 同时也可以有相关配置)

~~~json
// 所有类目名称列表
data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日']
// 每一项也可以是具体的配置项，此时取配置项中的 `value` 为类目名
data: [{
    value: '周一',
    // 突出周一
    textStyle: {
        fontSize: 20,
        color: 'red'
    }
}, '周二', '周三', '周四', '周五', '周六', '周日']
~~~

