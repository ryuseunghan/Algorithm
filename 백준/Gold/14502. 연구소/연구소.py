from itertools import combinations
import copy

n, m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input().split())))
def isAvailable(x,y):
    if x <= -1 or x >=n or y <= -1 or y >= m:
        return False
    return True
def safe_area(graph):
    area = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                area += 1
    return area

def dfs(x, y, graph):
    isAvailable(x,y)
    if graph[x][y] == 2:
        if graph[x][y] == 2:
            if isAvailable(x-1, y):
                if(graph[x-1][y]) == 0:
                    graph[x-1][y] = 2
                    dfs(x-1, y,graph)
            if isAvailable(x, y-1):
                if(graph[x][y-1]) == 0:
                    graph[x][y-1] = 2
                    dfs(x, y-1,graph)
            if isAvailable(x+1, y):
                if(graph[x+1][y]) == 0:
                    graph[x+1][y] = 2
                    dfs(x+1, y,graph)
            if isAvailable(x, y+1):
                if(graph[x][y+1]) == 0:
                    graph[x][y+1] = 2
                    dfs(x, y+1,graph)
        return True
    return False
max = 0 
zeros = [(i, j) for i in range(n) for j in range(m) if graph[i][j] == 0]

really_selected =[]
for walls in combinations(zeros, 3):
    temp_graph = copy.deepcopy(graph)
    selected = []
    for x, y in walls:
        temp_graph[x][y] = 1
        selected.append((x,y))
    for i in range(n):
        for j in range(m):
            dfs(i,j,temp_graph)
    if max < safe_area(temp_graph):
        max = safe_area(temp_graph)
        really_selected = selected
print(max)
