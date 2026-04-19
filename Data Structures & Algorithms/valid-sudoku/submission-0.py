class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = defaultdict(set)
        cols = defaultdict(set)
        squares = defaultdict(set)
        #valid = {1, 2, 3, 4, 5, 6, 7, 8, 9, "."}

        for r in range(len(board)):
            for c in range(len(board[r])):
                # if board[r][c] not in valid:
                #     return False
                if board[r][c] != ".":
                    if board[r][c] in rows[r]:
                        return False
                    if board[r][c] in cols[c]:
                        return False
                    if board[r][c] in squares[(r//3, c//3)]:
                        return False
                    rows[r].add(board[r][c])
                    cols[c].add(board[r][c])
                    squares[(r//3, c//3)].add(board[r][c])
        return True



        
        