num=[]
a = int(input("Size of array="))
for i in range(a):
    b=input()
    num.append(b)

num.sort()
num.reverse();
print("Largest Number ="+num[0])

