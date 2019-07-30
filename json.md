1. 格式问题:

~~~python
json.load  / json.loads  前者用于从文件读取,后者用于从str读取
作用是将json str转为python中的格式,如字典和list.
~~~

~~~python
json.dump  / json.dumps  前者用于从文件读取进行操作,后者用于从str读取进行操作.
json.dump(dic, indent=4, ensure_ascii=False) 
json.dump(dic, fp, indent=4,ensure_ascii=False)
#这样输出结果就是中文,而且还有缩进
~~~

~~~python
遇到中文时,python会将其变为ascii码
ensure_ascii =False,可以显示为中文.
注意打开文件时,如果想要保存的是字符数据,应当指定编码,多为"utf8"
~~~

