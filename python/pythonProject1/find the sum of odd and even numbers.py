num= []
a=int(input("Enter size of array :"))

for i in range(a):
    b=int(input())
    num.append(b)

sumE=0
sumO=0
for i in range(a):
    if(num[i]%2==0):
        sumE+=num[i]
    else: sumO+=num[i]
print("The Sum of Even Numbers = ", sumE)
print("The Sum of Odd  Numbers = ", sumO)