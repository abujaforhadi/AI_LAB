num= []
a=int(input("Enter size of array :"))

for i in range(a):
    b=int(input())
    num.append(b)

sumE=0
sumO=0
for i in range(a):
    if(num[i]%2==0):
        sumE+=1
    else:
        sumO+=1
print("Count of Even Numbers = ", sumE)
print("count of Odd  Numbers = ", sumO)