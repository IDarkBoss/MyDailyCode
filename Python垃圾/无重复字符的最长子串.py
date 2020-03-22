class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        substring = []
        result = 0
        temp = 0
        left = 0

        for i in range(n):
            temp = temp + 1
            while (s[i] in substring):
                substring.remove(s[left])
                left = left + 1
                temp = temp - 1
            substring.append(s[i])
            result = max(result, temp)
        return result


a = Solution.lengthOfLongestSubstring(None, "abcbcd")
print(a)
