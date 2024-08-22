def solution(targets):

    ans = 0
    targets.sort(key = lambda x : [x[1], x[0]])

    s = e = 0

    for target in targets:
        if target[0] >= e:
            ans +=1
            e = target[1]

    return ans