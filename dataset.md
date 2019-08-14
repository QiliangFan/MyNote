# dataset(用于单独的数据集声明)

# *  id:

# * source: 二位数组,第一行/列可以给出维度名,也可以直接是数据.  还可以为key-value的形式:

~~~javascript
[
    ['product', '2015', '2016', '2017'],
    ['Matcha Latte', 43.3, 85.8, 93.7],
    ['Milk Tea', 83.1, 73.4, 55.1],
    ['Cheese Cocoa', 86.4, 65.2, 82.5],
    ['Walnut Brownie', 72.4, 53.9, 39.1]
]

[
    {product: 'Matcha Latte', count: 823, score: 95.8},
    {product: 'Milk Tea', count: 235, score: 81.4},
    {product: 'Cheese Cocoa', count: 1042, score: 91.2},
    {product: 'Walnut Brownie', count: 988, score: 76.9}
]

{
    'product': ['Matcha Latte', 'Milk Tea', 'Cheese Cocoa', 'Walnut Brownie'],
    'count': [823, 235, 1042, 988],
    'score': [95.8, 81.4, 91.2, 76.9]
}
~~~

# * dimensions: 定义series.data 或者 dataset.sosurce的每个维度的信息

~~~javascript
series: {
    type: 'xxx',
    dimensions: [
        null,                // 如果此维度不想给出定义，则使用 null 即可
        {type: 'ordinal'},   // 只定义此维度的类型。
                             // 'ordinal' 表示离散型，一般文本使用这种类型。
                             // 如果类型没有被定义，会自动猜测类型。
        {name: 'good', type: 'number'},
        'bad'                // 等同于 {name: 'bad'}
    ]
}
~~~

## * sourceHeader: data.source第一行/列是否是维度名信息

~~~http
null/ underfine  : 默认,自动探测
true: 第一行/列是维度名信息
false: 第一行/列直接开始是数据
~~~

