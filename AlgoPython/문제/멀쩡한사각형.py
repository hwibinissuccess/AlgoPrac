import math

def solution(w,h):
    ans = (w*h)-(w+h-math.gcd(w,h))

    return ans