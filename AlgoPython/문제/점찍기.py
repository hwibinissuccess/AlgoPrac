import math

def solution(k, d):

    ans = 0

    for i in range(0,d+1,k):
        maxY = math.floor(math.sqrt(d*d-i*i))
        ans += maxY//k+1

    return ans