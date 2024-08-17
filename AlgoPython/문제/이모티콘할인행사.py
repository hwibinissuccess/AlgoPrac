discounts = [10,20,30,40]
ans = [-1,-1]

def solution(users, emoticons):

    n, m = len(users), len(emoticons)
    discount_list = [0]*m

    def search(idx):

        global ans

        if idx == m :
            sale_num, cost_num = 0,0
            for i in range(n):
                tmp = 0
                for j in range(m) :
                    if users[i][0] <= discount_list[j]:
                        tmp += emoticons[j]*(100-discount_list[j])//100
                if tmp >= users[i][1]:
                    sale_num += 1
                else :
                    cost_num += tmp
            if sale_num > ans[0] or sale_num == ans[0] and cost_num > ans[1]:
                ans = [sale_num, cost_num]
            return

        for i in range(4):
            discount_list[idx] = discounts[i]
            search(idx+1)

    search(0)

    return ans