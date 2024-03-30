def isProper(ls):
    stack = []
    for i in ls:
        if i == "(":
            stack.append(i)
        else:
            if not stack or stack.pop() != "(":
               return False
    return not stack

#"균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 한다
def separate(ls):
    count = 0
    lss = list(ls)
    for i, char in enumerate(ls):
        if char == "(":
            count += 1
        else:
            count -= 1      
        if count == 0:
            return ls[:i + 1], ls[i + 1:]
    return ls, []
def solution(p):
    #입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
    if not p:
        return p
    # 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. 
    u, v = separate(p)
    #문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다. 
    if isProper(u):
        return "".join(u) + solution("".join(v))
    '''
    빈 문자열에 첫 번째 문자로 '('를 붙입니다. 
    문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다. 
    ')'를 다시 붙입니다. 
    '''
    newString = "(" + solution("".join(v)) +")"
    #u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다. 
    u = u[1:-1]
    u = [')' if c == '(' else '(' for c in u]
    return newString + "".join(u)