class Solution:
    def titleToNumber(self, s: str) -> int:
        length = len(s)
        result = 0

        for i in range(length):
            result = result + (ord(s[length - i - 1]) - 64) * (26**i)
        return result

    s = "AB"
    result = titleToNumber(None, s)
    print(result)