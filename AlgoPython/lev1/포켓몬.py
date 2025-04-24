def solution(nums):

    stan = len(nums)//2
    nums = set(nums)

    if stan >= len(nums): return len(nums)
    else : return stan
