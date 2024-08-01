from heapq import *

def solution(n, k, enemy):

    ans, sumEnemy = 0,0
    heap = []

    for e in enemy:
        heappush(heap, -e)
        sumEnemy += e
        if sumEnemy > n:
            if k == 0: break
            sumEnemy += heappop(heap)
            k -= 1
        ans += 1
    return ans