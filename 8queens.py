/*8 queen*/

import json
import sys

BOARD_SIZE = 8

def under_attack(col, queens):
    left = right = col

    for r, c in reversed(queens):
        left, right = left - 1, right + 1

        if c in (left, col, right):
            return True
    return False

def solve(n):
    if n == 0:
        return [[]]

    smaller_solutions = solve(n - 1)

    return [solution+[(n,i+1)]
        for i in xrange(BOARD_SIZE)
            for solution in smaller_solutions
                if not under_attack(i+1, solution)]



former, sys.stdout = sys.stdout, open('queen.txt', 'w')

for answer in solve(BOARD_SIZE):
    print answer

results, sys.stdout = sys.stdout, former
print json.dumps(answer)
===============
/*step to execute
gescoe@node13:~/Desktop/cl3_programs/queen$ python 8queens.py
[[1, 5], [2, 7], [3, 2], [4, 6], [5, 3], [6, 1], [7, 4], [8, 8]]
gescoe@node13:~/Desktop/cl3_programs/queen$ 
*/

