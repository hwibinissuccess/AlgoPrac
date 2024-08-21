def solution(board):

    strboard = ''.join(board)
    valid = strboard.count('O') - strboard.count('X')

    if valid not in [0,1]:
        return 0

    colboard = list(zip(*board))
    ocnt = 0
    xcnt = 0

    for i in range(3):
        if colboard[i].count('O')==3 or board[i].count('O')==3:
            ocnt += 1
        if colboard[i].count('X')==3 or board[i].count('X')==3:
            xcnt += 1

    for i in range(0,3,2):
        if(board[0][i] == board[1][1] == board[2][2-i] == 'O'):
            ocnt += 1
        if(board[0][i] == board[1][1] == board[2][2-i] == 'X'):
            xcnt += 1

    if ocnt and xcnt:
        return 0
    if ocnt==1 and valid==0:
        return 0
    if xcnt==1 and valid >=1:
        return 0

    return 1

