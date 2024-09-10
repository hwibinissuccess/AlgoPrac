def solution(s):
    ans = 0

    if len(s) == 1 : return 1

    for i in range(len(s)):
        for j in range(len(s)+1):
            new_s = s[i:j]

            if new_s == new_s[::-1]:
                ans = max(ans, len(new_s))

    return ans