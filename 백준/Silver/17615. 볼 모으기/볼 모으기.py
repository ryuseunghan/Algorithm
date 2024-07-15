from collections import deque

n = int(input())
str = input()
lst2 = deque([])

shift_num = 0
past = str[0]

for i in range(len(str)):
    if past != str[i]:
        lst2.append(i - shift_num)
        shift_num = i
        past = str[i]
    if i == len(str)-1:
        lst2.append(i - shift_num + 1)
        
b, r = 0, 0
if len(lst2) %2 == 0:
    for i in range(0, len(lst2)):
        if i % 2 == 0:
            b += lst2[i]
        else:
            r += lst2[i]
    if(lst2[0] > lst2[-2]):
        b -= lst2[0]
    else:
        b -= lst2[-2]
    if(lst2[1] > lst2[-1]):
        r -= lst2[1]
    else:
        r -= lst2[-1]        
    result = b if b < r else r
    print(result)
else:
    for i in range(0, len(lst2)):
        if i % 2 == 0:
            b += lst2[i]
        else:
            r += lst2[i]
    if(lst2[0] < lst2[-1]):
        b -= lst2[-1]
    else:
        b -= lst2[0]
    result = b if b < r else r
    print(result)