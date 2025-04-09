def solution(t, p):


    ans = 0
    p_len = len(p)
    t_len = len(t)
    p = int(p)

    for i in range(0, t_len+1-p_len):
        if int(t[i:i+p_len]) <=p:
            ans +=1

    return ans