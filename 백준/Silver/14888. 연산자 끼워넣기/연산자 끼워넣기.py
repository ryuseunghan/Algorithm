from itertools import permutations
from collections import deque

n = int(input())
nums = deque(map(int, input().split()))
plus, minus, multi, div = map(int, input().split())
minimum = 1000000000
maximum = -1000000000
op = []
for _ in range(plus):
    op.append("+")
for _ in range(minus):
    op.append("-")
for _ in range(multi):
    op.append("*")
for _ in range(div):
    op.append("/")
length = len(op)
op_list = set(permutations(op, length))
for operations in op_list:
    nums_copy = deque(nums)
    num = nums_copy.popleft()
    for operation in operations:
        if operation == "+":
            num += nums_copy.popleft()
        elif operation == "-":
            num -= nums_copy.popleft()
        elif operation == "*":
            num *= nums_copy.popleft()
        else : 
            num = int(num/nums_copy.popleft())
    if maximum < num:
        maximum = num
    if minimum > num:
        minimum = num
print(maximum)
print(minimum)