def solution(s):

    ans = []
    di = {}

    for i in range(len(s)):
        if s[i] not in di:
            ans.append(-1)
        else:
            ans.append(i-di[s[i]])

        di[s[i]]=i
    return ans