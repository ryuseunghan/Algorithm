from itertools import combinations

n = int(input())
graph = []
for i in range(n):
    graph.append(list(input().split()))
flag = True
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
def isSafe(x, y, graph):
    for i in range(4):
        nx, ny = x, y
        while 0 <= nx < n and 0 <= ny < n:
            if graph[nx][ny] == "O" : break
            if graph[nx][ny] == "S" : return False
            nx += dx[i]
            ny += dy[i]
    return True
emptySpace = [(x,y) for x in range(n) for y in range(n) if graph[x][y] == "X"]

obstacles = combinations(emptySpace, 3)

for obstacle in obstacles:
    copiedGraph = [row[:] for row in graph]
    for o in obstacle:
        copiedGraph[o[0]][o[1]] = "O"
    if all(isSafe(x,y, copiedGraph) for x in range(n) for y in range(n) if graph[x][y] == "T"):
        print("YES")
        flag = False
        break
if flag:
    print("NO")
