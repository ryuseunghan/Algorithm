from collections import deque

n, l, r = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]

def bfs(x, y):
    q = deque()
    q.append((x, y))
    temp = []  # 현재 연합을 저장할 리스트
    temp.append((x, y))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if l <= abs(graph[x][y] - graph[nx][ny]) <= r:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    temp.append((nx, ny))
    return temp

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

count = 0
while True:
    visited = [[False] * n for _ in range(n)]
    is_moved = False
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                visited[i][j] = True
                union = bfs(i, j)
                if len(union) > 1:
                    is_moved = True
                    num = sum(graph[x][y] for x, y in union) // len(union)
                    for x, y in union:
                        graph[x][y] = num
    if not is_moved:
        break
    count += 1

print(count)
