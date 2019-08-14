import sys
# Windows Python 3 版本
# 从标准输入依次读入每行数据
for line in sys.stdin:
    # 如果读到文件末尾，则退出
    if not line:
        break
    # .strip() 函数是去除字符串前后的空白符（包括空格、换行符等）
    # 使用空格拆分每一行中每个单词
    words = line.strip().split()
    # 输出每个单词对应一个数字 1
    for word in words:
        print ("%s\t%s" % (word, 1))
        
        