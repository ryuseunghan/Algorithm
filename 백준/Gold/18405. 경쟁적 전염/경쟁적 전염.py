from collections import deque

n, k = map(int, input().split())
graph =[]
for i in range(n):
    graph.append(list(map(int, input().split())))
s, x, y = map(int, input().split())
dx = [-1,1,0,0]
dy = [0,0,-1,1]
queue = deque()

def bfs():
    global time
    while(queue):
        x, y, t = queue.popleft()
        if t == s:
            break
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx<0 or ny<0 or nx>=n or ny>=n:
                continue
            if graph[nx][ny] != 0:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y]
                queue.append((nx, ny, t+1))
virusList = []
for num in range(1,k+1):
    for i in range(n):
        for j in range(n):
            if graph[i][j] == num:
                queue.append((i, j, 0))
bfs()
print(graph[x-1][y-1])
