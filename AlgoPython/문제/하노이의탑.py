def solution(n):

    ans = []

    def hanoi(n, one, two, three):

        if n == 1:
            ans.append([one, three])
        else:
            hanoi(n-1, one, three, two)
            ans.append([one, three])
            hanoi(n-1, two, one, three)

    hanoi(n, 1,2,3)

    return ans
