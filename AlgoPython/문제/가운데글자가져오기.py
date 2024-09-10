def solution(s):
    n = int(len(s)/2)

    if len(s)%2 == 0:
        return s[n-1:n+1]
    else:
        return s[n]