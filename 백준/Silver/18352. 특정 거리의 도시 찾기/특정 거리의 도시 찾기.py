from collections import deque

n, m, k, x = map(int, input().split())
graph = [[] for _ in range(n+1)]
path = [-1]*(n+1)
path[x] = 0

for _ in range(m):
    start, end = map(int, input().split())
    graph[start].append(end)

queue = deque([x])
while(queue):
    v= queue.popleft()
    for i in graph[v]:
        if path[i] == -1:
            queue.append(i)
            path[i] = path[v] + 1
result = []
for i in range(len(path)):
    if path[i] == k:
        result.append(i)
if not result:
    print(-1)
else:
    for i in result:
        print(i)
