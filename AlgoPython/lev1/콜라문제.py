def solution(a, b, n):

    ans=0

    while n>=a:
        ans += (n//a)*b
        n=(n//a)*b+(n%a)

    return ans