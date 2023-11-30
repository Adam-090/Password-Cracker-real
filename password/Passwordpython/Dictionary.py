import os



path = "/home/adam/Documents/Github/Password-Cracker-real/password/paslist.txt"
print(os.getcwd())
test = open(path,'r')
print(test.readline(1))
test.close()
#with open(path, "r") as pList:
 #   print 
  #  for line in pList:
   #     print(line)
