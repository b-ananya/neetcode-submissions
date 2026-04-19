class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for char in s:
            if char == "(" or char == "[" or char == "{":
                stack.append(char)
            elif stack and char == ")":
                if stack.pop() != "(":
                    return False
            elif stack and char == "}":
                if stack.pop() != "{":
                    return False
            elif stack and char == "]":
                if stack.pop() != "[":
                    return False
            else:
                return False
        return True if not stack else False

        