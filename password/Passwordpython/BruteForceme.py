import itertools
password = input("Enter the password you want to guess")
characs = input("Enter the Chracters / numbers used in the password ")
length = int(input("Enter the password Length in integer form "))
chracsList = list(itertools.chain.from_iterable(characs))
print(characs)
print(length)
print(chracsList)

changedList = list(itertools.product(chracsList,repeat=length))
print(changedList)


for x in changedList:
    print(x)
    if x == password:
        

