class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top_r = 0
        bottom_r = len(matrix)-1

        while top_r <= bottom_r:
            row = (top_r + bottom_r) // 2
            if target < matrix[row][0]:
                bottom_r = row-1
            elif target > matrix[row][-1]:
                top_r = row+1
            else:
                break
        if top_r > bottom_r:
            return False

        left = 0
        right = len(matrix[row])-1

        row = (top_r + bottom_r) // 2

        while left <= right:
            mid = (left+right) // 2
            if matrix[row][mid] == target:
                return True
            elif matrix[row][mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return False
            

        
        