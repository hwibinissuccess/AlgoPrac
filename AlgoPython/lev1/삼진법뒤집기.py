def solution(n):

    ans = ''

    while(n>=1):
        rest = n%3
        n = n//3
        ans += str(rest)

    return int(ans,3)