def solution(m, musicinfos):

    ans = []

    for info in musicinfos:
        info = info.split(',')
        info[3] = change(info[3])
        T = time_c(info[1]) - time_c(info[0])

        if T >= len(info[3]):
            M = info[3]*(T//len(info[3]))+info[3][:T%len(info[3])]
        else:
            M = info[3][:T]

        if change(m) in M:
            ans.append([T, info[2]])

    if len(ans) == 0:
        return '(None)'
    else:
        return sorted(ans, key=lambda x : -x[0])[0][1]


def time_c(t):
    return int(t.split(":")[0])*60 + int(t.split(":")[1])

def change(x):
    exc = {'C#':'1', 'D#':'2','F#':'3','G#':'4','A#':'5'}
    for k,v in exc.items():
        x = x.replace(k,v)
    return x

