import sys
numByGender = {'0':0,'1':0,'2':0}
lastKey = False
for data in sys.stdin:
    data = data.strip()    
    record = data.split('\t')
    curKey = record[0]
    gender = record[1]
    if lastKey and curKey !=lastKey:
        sys.stdout.write("%s year:%s female,%s male \n"%(lastKey,numByGender['0'],numByGender['1']))
        lastKey = curKey
        numByGender = {'0':0,'1':0,'2':0}
        numByGender[gender] +=1
    else:
        lastKey = curKey
        numByGender[gender] += 1
if lastKey:
    sys.stdout.write("%s year:%s female,%s male \n"%(lastKey,numByGender['0'],numByGender['1']))