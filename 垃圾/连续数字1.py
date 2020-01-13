'''
给定n个整数（0-100），其中0可以替换成任意其他数字，要求判断这n个整数是否连续？(存在重复数字也判定为连续)

例：
输入：0，5，6，7，8，10
解释：将0替换成9，这n个整数可判定为连续
输出：True
输入：5，6，7，9，8，10
解释：顺序无关
输出：True
输入：5，5，6，7，8
输出：True
'''


def check(nums):
    res = 0
    nums = list(set(nums))
    nums = sorted(nums)

    for i in range(len(nums)):
        if i == 0:
            nums2 = nums[1:]
        if i > 0:
            nums2 = nums[0:i] + nums[i + 1:]

        a = nums2[0]
        length = len(nums2)
        add = int(a * length + length * (length - 1) / 2)
        sum_nums2 = sum(nums2)

        if (sum_nums2 - add) > (length - 1):
            res = 0
        else:
            res = 1

    if res == 1:
        print(True)
    else:
        print(False)


if __name__ == "__main__":
    test = [[5, 5, 6, 6, 7, 8, 9], [0, 1, 2, 3, 5], [0, 1, 3, 4, 5],
            [1, 3, 4, 5, 6, 11], [1, 3, 5, 7, 8]]

    for nums in test:
        check(nums)
