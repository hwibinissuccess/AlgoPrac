def solution(arr, divisor):

    ans = []

    for num in arr:
        if num%divisor == 0:
            ans.append(num)

    ans.sort()

    if not ans:
        ans.append(-1)

    return ans
