// AJAX
$.ajax({
	url :"test.html",
	cache:false,  //dataType 是script 和json时默认为false, 有利于数据始终最新
	type:'POST',  //默认为get
	dataType:"json",  //xml ,html,script,json,jsonp,text
	data:JSON.stringfy({"k":"w"}), //将json形式的字符串传出
	beforeSend:function(xhr){
		//this 默认为调用本次AJAX请求时传递的options参数
		//return false => 取消发送
	},
	context:document.body, //用于指定ajax相关毁掉函数的上下文,也即是
											//让回调函数内的this指向这个对象
	//事实上, success和error的参数只需要一个就行!
	success:function(data,textStatus){
			//data 是传输回的数据
			//textStatus表示错误信息(可以不需要,出错了信息会放在data中)
			//即使成功获取,解析时也可能出粗,ajax会自动parse传回的json字符串
	},
	error:function(XMLHttpRequest, textStatus,errorThrown){
		//XMLHttpRequest.readyState:0 (未初始化)  1(载入)  2(载入完成)  3(交互)  4(完成)
		//textStatus 错误信息
		//errorThrown 错误信息
	},
	complete:function(XMLHttpRequest,textStatus){
		//....
	},
	statusCode:{
		404:function(){
			alert('404,页面不存在'')
		}
	},
	dataFilter:function(data,type){
		//对ajax返回的数据进行预处理
		//data为ajax返回的数据
		//type为传输时指定的dataType
	}
});
//ajax 所有请求
$.ajax([options]);
$.post(url,data,success,dataType);
$.get(url,data,suceess,dataType);
$.getScript(url,data,success);  //请求一个script文件并执行! 可以调用本地的js变量
$.getJSON(url,data,success);


//ajax 动态方法
$(document).ajaxComplete(function(){});    //注册Ajax请求完成时要调用的处理程序
$(document).ajaxError(function(){});    //注册要在Ajax请求完成时遇到错误而调用的处理程序
$(document).ajaxSend(function(){});    //附加要在发送Ajax请求之前执行的函数
$(document).ajaxStart(function(){});    //注册在第一个Ajax请求开始时要调用的处理程序
$(document).ajaxStop(function(){});    //注册要在所有Ajax请求完成后调用的处理程序,当所有异步请求都终止时触发
$(document).ajaxSuccess(function(){});    //附加要在Ajax请求成功完成时执行的函数
$([element]).load(url, data, callback);    //返回某 url 的数据，data为传递参数(可选), callback(reponseText, statusText, xhr) 回调函数(可选)
//为绑定的元素加载一个url的内容,通常是html, 将html页面中的内容加载进入组件中

//相关方法
$.param(obj)  //将一个对象转化为一个url参数列表
$(form).seralize(); //将表单数据序列化为url参数列表
$(form).serializeArray();  //将表单数据转化为json数组, 形式为[{"name":..., "value":...},...]


//将表单数据封装为json
function getformdata($form){
	var unidexed_array=$form.serializeArray();
	var ss=$form.serialize();
	alert(ss);
	var indexed_array={};
	$.map(unidexed_array,function (n,i) {
		indexed_array[n["name"]]=n["value"];
	});
	return indexed_array;
};
