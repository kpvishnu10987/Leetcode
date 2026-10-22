class Solution:
    def removeStars(self, s: str) -> str:
        stack = []
        for c in s:
            if c == '*':
                stack.pop()
            else:
                stack.append(c)

        ans = ""
        while len(stack) != 0:
            ans += stack.pop()
        return ans[::-1]
        