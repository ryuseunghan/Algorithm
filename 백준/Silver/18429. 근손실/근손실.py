from itertools import permutations

# n일, k개의 근육 감소량
n, k = map(int, input().split())
kit = list(map(int, input().split()))
for i in range(len(kit)):
    kit[i] = kit[i] -k
count = 0
# 모든 순열
per_list  = list(permutations(kit, n))
for i in per_list:
    sum = 0
    count += 1
    for j in range(n):
        sum += i[j]
        if sum < 0 :
            count -= 1
            break
print(count)