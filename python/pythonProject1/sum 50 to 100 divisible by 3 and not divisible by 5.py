
sum=0
i=50
n=100
for i in range(n):
    if(i%3==0 and i%5 !=0):
        sum+=i

print("sum of divisible by 3 and not divisible by 5" ,sum)