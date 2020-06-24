'''
增加难度的额外需求：
若98，99，100，1，2，3，也当作连续数组，即最大数字100后接上最小数字1也计为连续，如何修改代码实现？
例：
输入：98，99，100，1，2，3
输出：True
输入：0，98，99，1，2，3
输出：True
'''


def check(nums):
    res = 0
    nums = list(set(nums))
    nums = sorted(nums)

    for i in range(len(nums)):
        if i == 0:
            num_split = nums[1:]
        if i > 0:
            num_split = nums[0:i] + nums[i + 1:]

        number1 = num_split[0]
        length = len(num_split)
        add = int(number1 * length + length * (length - 1) / 2)
        sum_num_split = sum(num_split)

        if (sum_num_split - add) <= (length - 1):
            return True

    if res == 1:
        return True
    else:
        return False


if __name__ == "__main__":
    test = [[98, 99, 100, 100, 1, 2, 3], [0, 98, 99, 1, 2, 3], [98, 99, 2, 3]]
    for nums in test:
        max_index = nums[::-1].index(max(nums))
        if max_index != 0:
            a = nums[::-1][max_index - 1]
            if a == 1:
                nums1 = nums[::-1][max_index:][::-1]
                nums2 = nums[::-1][:max_index][::-1]

                result1 = check(nums1)
                result2 = check(nums2)
                if result1 is True and result2 is True:
                    print(True)
                else:
                    print(False)

            if a != 1:
                result = check(nums)
                print(result)
