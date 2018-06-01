file = open("mtainfo.csv", "r")
csv = file.readlines()
file.close()

print (csv[:10])            
            
def splitCommas(list):
    ctr = 0
    while ctr < len(list):
        list[ctr] = list[ctr].split(", ")
        ctr += 1
    ctr = 0
    while ctr < len(list):
        list[ctr] = list[ctr][0].split(",")
        ctr += 1        
    return list

splitCommas(csv)
print ("split commas")
print(csv[:10])

def rmWhiteSp(list):
    ctr = 0
    while ctr < len(list):
        subctr = 0
        while subctr < len(list[ctr]):
            list[ctr][subctr] = list[ctr][subctr].strip()
            subctr += 1
        ctr += 1
    return list

rmWhiteSp(csv)
print("rm white space: ")
print(csv[:10])

def rmCol(num):
    ctr = 0
    while ctr < len(csv):
        csv[ctr] = csv[ctr][0:num]+ csv[ctr][num + 1:]
        ctr += 1


def makeFloat(col):
    ctr = 1
    while ctr < len(csv):
        csv[ctr][col] = float(csv[ctr][col])
        ctr += 1


rmCol(0)
rmCol(0)
rmCol(0)
rmCol(0)
rmCol(0)
rmCol(3)
print(csv[:5])
makeFloat(4)
makeFloat(3)

for i in csv:
    try: 
        if i[2].index("6") >= 0:
            print i
    except:
        pass



