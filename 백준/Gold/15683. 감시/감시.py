from itertools import product

n, m = map(int, input().split())
graph =[]
for i in range(n):
    graph.append(list(map(int, input().split())))


def countNotVisited(graph):
    count = 0
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0:
                count+=1
    return count

def firstCamera(x, y, graph, p):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    nx, ny = x, y
    count = 0
    visited = []
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[p]
        ny += dy[p]
    for visitedArea in visited:
        graph[visitedArea[0]][visitedArea[1]] = "#"

def secondCamera(x, y, graph, p):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    nx, ny = x, y
    count = 0
    visited = []
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[int(p/2)*2]
        ny += dy[int(p/2)*2]
    nx, ny = x, y
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[int(p/2)*2+1]
        ny += dy[int(p/2)*2+1]
    for visitedArea in visited:
        graph[visitedArea[0]][visitedArea[1]] = "#"



def thirdCamera(x, y, graph, p):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    nx, ny = x, y
    count = 0
    visited = []
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[p]
        ny += dy[p]
    nx, ny = x, y
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[(p+1)%4]
        ny += dy[(p+1)%4]

    for visitedArea in visited:
        graph[visitedArea[0]][visitedArea[1]] = "#"

def fourthCamera(x, y, graph, p):
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    nx, ny = x, y
    count = 0
    visited = []
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[p]
        ny += dy[p]
    nx, ny = x, y
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[(p+1)%4]
        ny += dy[(p+1)%4]
    nx, ny = x, y
    while(0 <= nx < n and 0 <= ny < m):
        if (graph[nx][ny] == 6): break
        if (graph[nx][ny] == 0) :
            count += 1
            visited.append((nx, ny))
        nx += dx[(p+2)%4]
        ny += dy[(p+2)%4]
    for visitedArea in visited:
        graph[visitedArea[0]][visitedArea[1]] = "#"

def fifthCamera(x, y, graph):
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    count = 0
    visited = []
    for i in range(4):
        nx, ny = x, y
        while(0 <= nx < n and 0 <= ny < m):
            if (graph[nx][ny] == 6): break
            if (graph[nx][ny] == 0) :
                count += 1
                visited.append((nx, ny))
            nx += dx[i]
            ny += dy[i]
    for visitedArea in visited:
        graph[visitedArea[0]][visitedArea[1]] = "#"


points = [(x, y, graph[x][y]) for x in range(n) for y in range(m) if 0 < graph[x][y] < 6]
pointsLength = len(points)
products = product(range(4), repeat = pointsLength)
minimum = m * n

for p in products:
    cameraCount = 0
    copiedGraph = [row[:] for row in graph]
    for point in points:
        if point[2] == 5:
            fifthCamera(point[0], point[1], copiedGraph)
        elif point[2] == 4:
            fourthCamera(point[0], point[1], copiedGraph, p[cameraCount])
        elif point[2] == 3:
            thirdCamera(point[0], point[1], copiedGraph, p[cameraCount])
        elif point[2] == 2:
            secondCamera(point[0], point[1], copiedGraph, p[cameraCount])
        elif point[2] == 1:
            firstCamera(point[0], point[1], copiedGraph, p[cameraCount])
        cameraCount += 1
    minimum = min(minimum, countNotVisited(copiedGraph))
print(minimum)
