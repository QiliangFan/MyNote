import re
fp = open("access.log.10", "r", encoding='utf-8')
line  = fp.readline()
array = []
final_result =[]
while line:
	ip = re.findall(r'\d+\.\d+\.\d+\.\d+', line)[0]
	if not ip:
		ip=""
	time = re.findall(r'\d{2}/\w+/\d+:\d\d:\d\d:\d\d \+\d\d\d\d',line)[0]
	if not time:
		time=""
	result = re.findall(r'"(.+?)"',line)
	try:
		request = result[0][0]
	except :
		request=""
	try:
		url = result[1]
		if  url.find("?")!=-1:
			url = url[0:url.index("?")]
	except Exception as e:
		print(url[0:url.index("?")])
		url=""
	try:
		header = result[2]
	except :
		header=""
	num_result = re.findall(r' (\d+)(?= )',line)
	try:
		status=num_result[0]
	except:
		status=""
	try:
		size=num_result[1]
	except:
		size=""
	array=[
		ip,
		time,
		request,
		url,
		status,
		size,
		header
	]
	final_result.append(array)
	line = fp.readline()
#
for data in final_result:
	print(
	data[0]
	# ,data[1]
	# ,data[2]
	,data[3]
	# ,data[4]
	# ,data[5]
	# ,data[6]
	)
