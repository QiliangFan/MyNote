import sys

cur_word = None
sum = 0

for line in sys.stdin:
    ss = line.strip().split('\t')

    if len(ss) < 2: 
        continue

    word = ss[0].strip()
    count = ss[1].strip() 

    if cur_word == None: 
        cur_word = word

    if cur_word != word: 
        print "%s\t%s" % (cur_word, str(sum))
        cur_word = word
        sum = 0

    sum += int(count)

print "%s\t%s" % (cur_word, str(sum))
sum = 0

