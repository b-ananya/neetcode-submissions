class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        top_r = 0
        bottom_r = len(matrix)-1

        while top_r <= bottom_r:
            mid = (top_r + bottom_r) // 2
            if target == matrix[mid][0]:
                return True
            if target < matrix[mid][0]:
                bottom_r = mid-1
            elif target > matrix[mid][-1]:
                top_r = mid+1
            else:
                break
        
        if top_r > bottom_r:
            return False
        
        left = 0
        top_r = mid
        right = len(matrix[top_r])-1

        while left <= right:
            mid = (left+right) // 2
            if matrix[top_r][mid] == target:
                return True
            elif matrix[top_r][mid] > target:
                right = mid - 1
            else:
                left = mid + 1
        
        return False
            

        
        