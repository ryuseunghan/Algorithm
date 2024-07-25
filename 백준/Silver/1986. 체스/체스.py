from collections import deque

# 입력 받기
n, m = map(int, input().split())
visited = set()

queen_list = deque(map(int, input().split()))
knight_list = deque(map(int, input().split()))
pawn_list = deque(map(int, input().split()))
queens, knights, pawns = set(), set(), set()

# 퀸의 위치 입력 받기
cnt = queen_list.popleft()
for _ in range(cnt):
    point = (queen_list.popleft(), queen_list.popleft())
    visited.add(point)
    queens.add(point)

# 나이트의 위치 입력 받기
cnt = knight_list.popleft()
for _ in range(cnt):
    point = (knight_list.popleft(), knight_list.popleft())
    visited.add(point)
    knights.add(point)

# 폰의 위치 입력 받기
cnt = pawn_list.popleft()
for _ in range(cnt):
    point = (pawn_list.popleft(), pawn_list.popleft())
    visited.add(point)
    pawns.add(point)

# 퀸과 나이트의 이동 방향
q_x = [1, 1, 1, 0, 0, -1, -1, -1]
q_y = [1, 0, -1, 1, -1, 1, 0, -1]
k_x = [1, 1, -1, -1, 2, 2, -2, -2]
k_y = [2, -2, 2, -2, 1, -1, 1, -1]

def inBoard(point):
    x, y = point
    return 1 <= x <= n and 1 <= y <= m

def nothing(new_point):
    return new_point not in pawns and new_point not in queens and new_point not in knights

def visit(point):
    visited.add(point)

def queen_move(point):
    for num in range(8):
        x, y = point
        while True:
            x += q_x[num]
            y += q_y[num]
            new_point = (x, y)
            if not (inBoard(new_point) and nothing(new_point)):
                break
            visit(new_point)

def knight_move(point):
    for num in range(8):
        x, y = point
        x += k_x[num]
        y += k_y[num]
        new_point = (x, y)
        if inBoard(new_point) and nothing(new_point):
            visit(new_point)

# 퀸과 나이트의 이동을 수행
for point in queens:
    queen_move(point)
for point in knights:
    knight_move(point)

# 결과 계산
result = n * m - len(visited)
print(result)
