def solution(n, money):

    mod = 1000000007
    dp = [1]+[0]*n

    for i in range(len(money)):
        for j in range(money[i], n+1):
            dp[j] += dp[j-money[i]]%mod

    return dp[n]