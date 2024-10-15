def solution(s):
    ans = " "
    s = s.split(" ")

    for i in range(len(s)):
        s[i] = s[i].capitalize()

    ans = " ".join(s)
    return ans