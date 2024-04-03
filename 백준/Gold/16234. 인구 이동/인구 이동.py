from collections import deque

n, l, r = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

flag = True
count = 0
while True:
    visited = [[False for i in range(n)] for j in range(n)]
    flag = False
    for seq in [(x,y) for x in range(n) for y in range(n) if not visited[x][y]]:
        queue = deque([seq])
        union = []
        while (queue):
            point = queue.popleft()
            if not visited[point[0]][point[1]]:
                visited[point[0]][point[1]] = True
                union.append((point[0], point[1]))
                for i in range(4):
                    nx, ny = point[0], point[1]
                    if (0<= nx+dx[i] < n and  0 <= ny+dy[i] < n):
                        if l <= abs(graph[nx][ny] - graph[nx+dx[i]][ny+dy[i]]) <=r and not visited[nx+dx[i]][ny+dy[i]]:
                            nx += dx[i]
                            ny += dy[i]
                            queue.append((nx, ny))
        countriesSum = 0
        if len(union) > 1:
            flag = True
        # 연합 인구 이동
        for country in union:
            countriesSum += graph[country[0]][country[1]]
        for country in union:
            graph[country[0]][country[1]] = int(countriesSum/len(union))
    if flag:
        count += 1
    else:
        break
print(count)