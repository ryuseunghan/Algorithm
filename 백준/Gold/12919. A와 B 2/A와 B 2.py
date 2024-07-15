from collections import deque

s = input()
t = input()

queue = deque([t])

def match(str):
    if s in str:
        return True
    elif s in ''.join(reversed(str)):
        return True
    else:
        return False

def op():
    while queue:
        popped =  queue.popleft()
        if s == popped:
            return 1
        else:
            if popped[0] == "A":
                if popped[-1] == "A":
                    str1 = popped[:-1]
                    if match(str1):
                        queue.append(str1)
                if popped[-1] == "B":
                    continue
            else:
                if popped[-1] == "A":
                    str2, str3=popped[0:-1],''.join(reversed(popped[1:]))
                    if match(str2):
                        queue.append(str2)
                    if match(str3):
                        queue.append(str3)
                if popped[-1] == "B":
                    str4 = ''.join(reversed(popped[1:]))
                    if match(str4):
                        queue.append(str4)
    return 0

print(op())