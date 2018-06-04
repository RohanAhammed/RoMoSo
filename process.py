'''
RoMoSo
Processing the file mtainfo.csv
'''

#open csv:
file = open("mtainfo.csv", "r")
csv = file.readlines()
file.close()
            
#split the CSV by commas to make an array:
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

#remove all whitespace characters such as \n and \t
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

#remove unnecessary columns: (ID, etc)
def rmCol(num):
    ctr = 0
    while ctr < len(csv):
        csv[ctr] = csv[ctr][0:num]+ csv[ctr][num + 1:]
        ctr += 1

'''
def makeFloat(col):
    ctr = 1
    while ctr < len(csv):
        csv[ctr][col] = float(csv[ctr][col])
        ctr += 1
'''

rmCol(0)
rmCol(1)
rmCol(1)
rmCol(1)
#rmCol(0)
rmCol(4)
print(csv[:5])
#makeFloat(4)
#makeFloat(3)

#test function to be able to print out all of the stations in a subway line:
def printLine(line):
    print(line) 
    print ("train:")
    for i in csv:
        try: 
            if i[3].index(line) >= 0:
                print i
        except:
            pass
    print("=====================================================")


printLine("6")
print (csv[:5])
'''
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
'''

#function transfersCol adds a column to the array that contains all the transfers that can be made at this station. This column contains arrays
def transfersCols():
    csv[0].append("Transfer Options")
    ctr = 1
    while (ctr < len(csv)):
        arr = csv[ctr][3].split()
        for i in csv:
            if (i != csv[ctr] and i[0] == csv[ctr][0]):
                arr.extend(i[3].split())
        csv[ctr].append(arr)
        print csv[ctr][1]
        print (arr)
        ctr += 1
        
transfersCols()
print csv[:5]

#create new file, named Driver.java:
file = open("Driver.java", "w")
#heading:
s = "/*\nRoMoSo\nClara Mohri, Rohan Ahammed, Soojin Choi\n*/\n"
s += "//This file has been written by the Python file process.py\n//A few manual alterations have been made to ensure that stations are in order\n"
s += "import java.util.LinkedList;\n"
s += "public class Driver{\n\tpublic static void main (String[] args){\n"
file.write(s)

#method write takes arguments string line and string name
#it creates a LinkedList called name in Driver.java that contains Stations from line 
def write(line, name):
    #construct new LinkedList:
    listdec = "\n\t\tLinkedList<Station> "
    listdec += name
    listdec += " = new LinkedList<Station>();\n"
    file.write(listdec)
    #add all of the Stations:
    for i in csv:
        try:
            if i[3].index(line) >= 0:
                file.write("\t\t")
                file.write(name)
                file.write(".add(")
                file.write("new Station(")
                s = ""
                for x in i:
                    item = x
                    if (x == i[3]):
                        item = line #only want one line for this attribute
                    if (x == i[6]):
                        item = ""
                        j = 0
                        while (j < len(i[6])):
                            item += i[6][j]
                            j += 1
                    s += "\""
                    s += item
                    s += "\"" 
                    s += ", "
                s = s[:-2] #remove last comma
                s += "));"
                file.write(s)                
                file.write("\n")                
        except: 
            pass

#MTA lines
#sorry Staten Island, sorry S train users. (It's not you, it's us)

#red line    
write("1", "one")
write("2", "two")
write("3", "three")
#green line
write("4", "four")
write("5", "five")
write("6", "six")
#seven line
write("7", "seven")
#blue line
write("A", "a")
write("C", "c")
write("E", "e")
#orange line
write("B", "b")
write("D", "d")
write("F", "f")
write("M", "m")
#brown line
write("J", "j")
write("Z", "z")
#yellow line
write("N", "n")
write("Q", "q")
write("R", "r")
write("W", "w")
#L train
write("L", "l")
#G train
write("G", "g")
file.write("\t}\n")
file.write("}")
file.close()
