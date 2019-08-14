# 1. title

## * show(true) :  true |false

## * text(""): <内容>

## * link(""):点击标题时跳转的超链接

## * target("blank"):"self"-当前窗口打开  |  "blank"-新窗口打开

## * textStyle: 

### 	* color("#333"): 标题颜色

### 	* fontStyle('normal'):   'normal'  |   'italic'  |   'oblique'    //一个比一个斜

### 	* fontWeight("normal"):  'normal'  |  'bold'  |   'bolder'  |'lighter'  

​										{ 100 | 200| 300  ...  }

### 	* fontSize(18) : 主题标题文字大小

### 	* lineHeight : 如果rich中没有设置lineHeight, 则值为此处的值!

### 	* width(默认为文字的宽度): 文本块的宽度, 在做表格和使用图片时会有用.

### 	* height(默认为文字高度): 同上. width和height不包含padding!{ 如果未指定rich属性, 则不能指定width 和height}

### 	* textBorderColor("transparent") : 文字描边颜色

### 	* textBorderWidth(0):文字描边宽度  

### 	* textShadowColor("transparent"): 文字阴影颜色

### 	* textShadowOffsetX(0): 文字阴影长度

### 	* textShadowOffsetX(0): x方向上阴影的偏移

### 	* textShadowOffsetY(0):y方向上

### 	* rich:   定义自己的富文本样式

~~~json
//语法
rich:{
    <user-defined-style-name>: {
    ....
    a:{...},
	b:{...}
}
}

//使用
formatter:[
    '{a|第一段采用样式a}',
    '{b|第二段采用样式b}',
].join('\n'),
~~~

## * subtext(""):副标题样式, 支持\n 换行

## * sublink(""): 副标题文本超链接

## * subtarget("blank"): 'self'  |  'blank'

## * subtextStyle : {类比textStyle}

## * textAlign('auto'):整体(包含text和subtext)的水平对齐  

​		   'auto'  |   "left"  |  'right'   |   'center'

## * textVerticalAlign('auto'): 整体的垂直对齐

​			'auto'  |  'top'  |   'bottom'  |  'middle'

## * triggerEvent(false): 是否触发事件    false | true

## * padding(5): 标题内边距, 单位px, 设置方式类似css

```js
// 设置内边距为 5
padding: 5
// 设置上下的内边距为 5，左右的内边距为 10
padding: [5, 10]
// 分别设置四个方向的内边距
padding: [
    5,  // 上
    10, // 右
    5,  // 下
    10, // 左
]
```

## * itemGap(10) : 主副标题之间的间距

## * zlevel(0): 所有图形的zlevel值(不同zlevel的图形会放在不同canvas中,通过canvas分层, canvas过多容易崩溃!)

## * z(2): 组件

## * left("auto"): 组件离容器左侧的距离

​		'auto'| 'center'  | ' right' |10 |20 |15% ...

## * top("auto"):

## * right('auto'): 

## * bottom('auto'):

## * backgroundColor('transparent'): 标题背景色: 可以用rgb| rgba| #

## * borderColor('#ccc'): 标题边框颜色

## * borderWidth(0): 标题的边框线宽

## * borderRadius(0): 圆角半径(单位px), 支持传入数组分别指定四个圆角半径

​		borderRadius: [5,5,0,0]

## * shadowBlur:单位px, 有效前提:show:true 且 backgroundColor 不为tranparent

## * shadowColor: 有效前提: show:true

## * shadowOffsetX: 

## * shadowOffsetY: 

# 2. legend

## * type('plain'): 'plain' 普通图例  | 'scroll' 可滚动翻页的图例

## * id:指定后可在option或api中引用组件

## * show(true): true |false

## *  zlevel(0):同title中的

## * z(2): 

## * left:

## * top

## * right

## * bottom

## * width

## * height

## * orient('horizontal'):  图例的朝向:  'horizontal'  |  'vertical'

## * align('auto'): 图例和文本的对齐, 根据组件位置和orient决定.

​		'auto'  |  'left'  |  'right'

## * padding(5)

## * itemGap(10): 图例之间的间隔

## * itemWidth(25): 图例的图形宽度

## * symbolKeepAspect(true): 缩放时保持长宽比(当图标由某些元素设置时)

## * formatter(null): 格式化图例文本

~~~json
// 使用字符串模板，模板变量为图例名称 {name}
formatter: 'Legend {name}'
// 使用回调函数
formatter: function (name) {
    return 'Legend ' + name;
}
~~~

## * selectedMode(true): 是否可以通过点击图例改变系列的显示状态(也即是否显示)

​		true |  false | 'single' | 'multiple'   单选或多选模式

## * inactiveColor: 图例关闭图例的颜色(即显示状态通过点击切换为不显示时)

## * selected: 图例选中的状态表

~~~json
selectd:{
    "moon":false,
    "sun":true,
}
//名字是取data中的,即图例的name ,true 即active ,图例选中且相应图形显示
~~~

## * textStyle:(这里只列title 的textStyle中没有的)

### * fontFamily('sans-serif'):  'serif'  |  'monospace'   |  'Arial'   | 'Courier New'  |  'Microsoft YaHei', ...

### * lineHeight:(同样如果rich中没有设置lineHeight也会继承自这里)

### * rich:

#### * color('#fff')

#### * fontStyle('normal'):  'normal' |  'italic'  |'oblique'

#### * fontWeight:

#### * fontFamily

#### * fontSize

#### * align (如果未设置, 继承父层级的)

#### * verticalAlign (如果未设置, 取父层级的)

#### * lineHeight(可继承)

#### * backgroudColor('transparent')：可以是颜色 , 也可以是图片

~~~json
backgroundColor:{
    image: 'xxx/xxx.png'
    //可以是url 也可以是dataURI,
    //还可以是 HTMLImageElement对象
    //还可以是HTMLCanvasElement对象
    //如果是图片, 还可以指定width, height
}
~~~

... (还有很多常见的)

## * tooltip:默认不显示

~~~json
legend:{
    formatter: function (name){
        return  echarts.format.truncateText(name, 40 , '14px Microsoft Yahei','...')
    },
    tooltip:{
        show:true
    }
}
~~~

## * data[i]: 图例的数据数组 ,每一项都代表一个系列的name,特殊字符" ","\n"用于图例的换行

~~~json
 data:['邮件营销','联盟广告','\n','视频广告','直接访问','搜索引擎']   //特殊字符不占据名字, 可用于换行
data: [{
    name: '系列1',
    // 强制设置图形为圆。
    icon: 'circle',
    // 设置文本为红色
    textStyle: {
        color: 'red'
    }
}]    //这样单一配置某一项的样式
~~~

### name: 图例项的名字

### icon:  |'circle' |'rect' | 'roundRect' |  'triangle'  | 'diamod' | 'pin' | 'arrow' | 'none'  |  'image://<url>' 

### textStyle: 文本样式

## { 以下属性在type:'scroll'时有效}

## * scrollDataIndex(0): 设置图例最左上显示项的dataIndex

## * pageButtonItemGap(5): 控制按钮和页信息之间的间隔

## * pageButtonGap(null): 图例空置块和图例控制项之间的间隔

## * pageButtonPosition('end'): 图例控制块的位置  'start'  |  'end'

​				'start'  |  'end'

## * pageFormatter('{current}/{total}'):

~~~json
{current} 表示当前页
{total} 表示总页数
//也可以为函数:
pageFormatter: function(current, total){
    return  current +"+/+"+total
}
~~~

## * pageIcons 图例控制块的图标:(查文档)

## * pageIconSize(15):  可以是数字也可以是数组: [10, 3] -> [宽, 高]

## *pageTextStyle:文字样式

## *animation:图例翻页是否使用动画

## * animationDurationUpdate(800):图例翻页时的动画时长

# 3. grid:

## *  show(false):是否显示直角坐标系网络 

## *  zlevel(0)

## * z(2)

## * left('10%') : 'left' | 'center' | 'right' |25 | 20%...

## * top(60) : 'top' | 'middle' |'bottom'  | 20 |20%

## * right('10%'):

## * bottom(60):  

## * width('auto'):

## * height('auto'):

## * containLabel(false):true 或 false时图形的矩形范围不同, 前者包含坐标轴标签, 后者不包含,  或者说是考虑不考虑

## * backgroundColor('transparent'):

## * borderColor('#ccc'):

## * borderWidth(1)

## * shadowBlur: px为单位

## * shadowColor: 

## *shadowOffsetX(0) :

## * shadowOffsetY(0):

## * tooltip: (***查阅文档***)