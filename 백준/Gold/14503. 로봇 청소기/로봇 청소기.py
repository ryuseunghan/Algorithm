from collections import deque

rx = [-1,0,1,0]
ry = [0,1,0,-1]


r, c = map(int, input().split())
sx, sy, rn = map(int, input().split())

que = deque([])
que.append((sx,sy))
graph = []
for _ in range(r):
    graph.append(list(map(int , input().split())))
count = 0

while True:
    if que:
        (x, y) = que.popleft()

        # x, y가 벽이 아닐 때
        if x >= 0 and y >= 0 and x < r and y < c and graph[x][y] != 1:
            # x, y가 청소하지 않은 칸일 때
            if graph[x][y] == 0:
                # x, y 칸 청소
                graph[x][y] = 2
                count += 1

            flag = False
            # 현재 바라보는 위치에서 반시계 방향으로 청소 안된 칸 확인
            for i in range(1, 5):
                dn = (rn - i + 8)  % 4
                if x+rx[dn] >= 0 and y+ry[dn] >= 0 and x+rx[dn] < r and y+ry[dn] < c:
                    if graph[x+rx[dn]][y+ry[dn]] == 0:
                        que.append((x+rx[dn],y+ry[dn]))
                        rn = dn
                        flag = True
                        break
            # 청소 안된 칸이 없을 시 기존 바라보는 방향에서 후진
            if not flag:
                que.append((x-rx[rn],y-ry[rn]))            
        # x, y가 벽일 때
        else:
            break

print(count)