h, w = map(int,input().split())

blocks = list(map(int, input().split()))
rain = 0
for height in reversed(range(h)):
    cnt = 0
    past_check = False
    check = False
    for block in blocks:
        if block > height and check == False and past_check == False:
            past_check = False
            check = True
        elif block <= height and check == True:
            past_check = True
            cnt += 1
        elif block > height and check == True:
            rain += cnt
            cnt = 0
            past_check = True
print(rain)