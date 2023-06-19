num=[]
a = int(input("Size of array="))
for i in range(a):
    b=input()
    num.append(b)

num.sort()

print("Smallest Number ="+num[0])

