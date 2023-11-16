import itertools

characs = input("Enter the Chracters / numbers used in the password ")
length = input("enter the password Length in integer form ")
chracsList = list(itertools.chain.from_iterable(characs))
print(characs)
print(length)
print(chracsList)

