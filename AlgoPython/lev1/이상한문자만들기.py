def solution(s):
    ans = ''
    new_list = s.split(' ')

    for i in new_list:
        for j in range(len(i)):
            if j%2 == 0:
                ans += i[j].upper()
            else:
                ans += i[j].lower()

        ans += ' '

    return ans[0:-1]