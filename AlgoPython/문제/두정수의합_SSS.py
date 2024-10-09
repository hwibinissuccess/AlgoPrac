def solution(a, b):

    ans = 0
    aa = min(a,b)
    bb = max(a,b)

    for i in range(aa,bb+1):
        ans += i

    return ans