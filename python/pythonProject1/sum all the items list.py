num= []
a=int(input("Enter size of array :"))

for i in range(a):
    b=int(input())
    num.append(b)

sum=0

for i in range(a):
    sum+=num[i]

print("The Sum of all Numbers = ", sum)
