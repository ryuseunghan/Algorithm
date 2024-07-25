from collections import deque

#n : 트럭수, w: 다리 길이, l: 최대하중
n, w, l = map(int, input().split())
arr = deque(map(int, input().split()))

time = 0
trucks = deque()
current_weight = 0

while arr or trucks:
    time += 1

    if trucks and trucks[0][1] == time:
        truck_weight, exit_time = trucks.popleft()
        current_weight -= truck_weight
    
    if arr: 
        if current_weight + arr[0] <= l and len(trucks) < w:
            truck_weight = arr.popleft()
            trucks.append((truck_weight,time+w))
            current_weight += truck_weight

print(time)
    