def solution(n):

    ans = list(str(n))
    ans.sort(reverse = True)

    return int("".join(ans))