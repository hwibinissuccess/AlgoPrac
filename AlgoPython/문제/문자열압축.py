def solution(s):

    res = []

    if len(s)==1:
        return 1

    for i in range(1, len(s)+1):
        b = ''
        cnt = 1
        temp = s[:i]

        for j in range(i, len(s)+i, i):

            if temp == s[j:i+j]:
                cnt +=1
            else:
                if cnt != 1:
                    b = b+str(cnt)+temp
                else:
                    b = b+temp

                temp = s[j:j+i]
                cnt = 1

        res.append(len(b))

    return min(res)