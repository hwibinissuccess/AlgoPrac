from collections import deque

def solution(places):

    ans = []

    for place in places:

        isOk = True

        for r in range(5):
            for c in range(5):
                if place[r][c] == 'P':
                    if not bfs(r,c,place):
                        isOk = False
                        break
            if not isOk:
                break

        ans.append(1 if isOk else 0)

    return ans

def bfs(r,c,place):
    dr = [-1,1,0,0]
    dc = [0,0,-1,1]

    q = deque([r,c])

    while q:

        x,y = q.popleft()

        for i in range(4):
            nr = x+dr[i]
            nc = y+dc[i]

            if nr<0 or nc<0 or nr>=5 or nc>=5 or (nr==r and nc==c):
                continue

            d = abs(nr-r) + abs(nc-c)

            if place[nr][nc] == 'P' and d<=2:
                return False
            elif place[nr][nc] == 'O' and d<2:
                q.append(nr, nc)

    return True