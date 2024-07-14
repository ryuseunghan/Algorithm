from collections import deque

n, m = map(int, input().split())
graph = []
visited = []
for i in range(n):
    graph.append(list(map(int,input().split())))
    visited.append([False]*m)

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            sx, sy = i, j

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def bfs(x, y):
    queue = deque()
    queue.append((x,y))
    graph[x][y] = 0

    while(queue):
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            # 지도를 벗어나거나 방문했던 타일일 시 continue
            if nx<0 or ny<0 or nx>=n or ny>=m or visited[nx][ny]:
                continue

            # 벽일 시 continue
            if graph[nx][ny] == 0:
                visited[nx][ny] = True
                continue

            # 벽이 아닐 시 업데이트
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                visited[nx][ny] = True
                queue.append((nx, ny))
                continue

            # 도착지일 시 0으로 업데이트
            if graph[nx][ny] == 2:
                graph[nx][ny] = 0
                visited[nx][ny] = True
                queue.append((nx, ny))
    return

bfs(sx, sy)
for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j] == 1:
            graph[i][j] = -1
        print(graph[i][j], end=" ")
    print()