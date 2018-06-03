'''
RoMoSo
Processing the file mtainfo.csv
'''


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
#print ("split commas")
#print(csv[:10])

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
#print("rm white space: ")
#print(csv[:10])

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
#print(csv[:5])
makeFloat(4)
makeFloat(3)


def printLine(line):
    print(line) 
    print ("train:")
    for i in csv:
        try: 
            if i[2].index(line) >= 0:
                print i
        except:
            pass
    print("=====================================================")

printLine("6")
printLine("L") #whack
printLine("1") 
printLine("7")
printLine("C")
printLine("A")
printLine("F") #whack
printLine("G") #whack
printLine("J") #last two should be at top
printLine("N")
printLine("W")
printLine("Q")
printLine("S") #unconnected, different lines (maybe choose which shuttle?)

file = open("Driver.java", "w")
s = "public class Driver{\n\tpublic static void main (String[] args){\n"
file.write(s)

def write(line):
    ctr =1
    for i in csv:
        try:
            if i[2].index(line) >= 0:
                file.write("\t\t")
                file.write("Station ")
                file.write(chr(ctr))
                ctr += 1
                file.write("= new Station(")
                s = ""
                for x in i:
                    item = x
                    if (x == i[2]):
                        item = line
                    s += "\""
                    s += item
                    s += "\"" 
                    s += ", "
                s = s[:-2] #remove last comma
                s += ");"
                file.write(s)                
                file.write("\n")                
        except: 
            pass
    file.write("\t}\n")
    file.write("}")

    
write("1")
file.close()
