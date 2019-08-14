import sys
for data in sys.stdin:
    data = data.strip()
    record = data.split(',')
    user_id = record[0]
    if user_id == "user_id":
        continue
    birthyear = record[1][0:4]
    gender = record[2]
    sys.stdout.write("%s\t%s\n"%(birthyear,gender))