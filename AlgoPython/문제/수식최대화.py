import itertools

def solution(expression):
    op = ['+','-','*']
    op = itertools.permutations(op, 3)
    ans = []
    for i in op:
        ans.append(cal(expression, i))
    return max(ans)

def cal(exp, op):

    array = []
    tmp = ""

    for i in exp:
        if i.isdigit()==True:
            tmp += i
        else:
            array.append(tmp)
            array.append(i)
            tmp = ""
    array.append(tmp)

    for o in op:
        stack = []
        while len(array) != 0 :
            tmp = array.pop(0)
            if tmp == o:
                stack.append(operation(stack.pop(), array.pop(0), o))
            else:
                stack.append(tmp)
        array = stack

    return abs(int(array[0]))

def operation(n1, n2, op):
    if op == "+":
        return str(int(n1) + int(n2))
    if op == "-":
        return str(int(n1) - int(n2))
    if op == "*":
        return str(int(n1) * int(n2))

