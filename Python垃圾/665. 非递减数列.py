def checkPossibility(nums):
    for i in range(len(nums) - 1):
        if nums[i] > nums[i + 1]:
            if i == 0:
                nums[0] = nums[1]
            elif nums[i - 1] > nums[i + 1]:
                nums[i + 1] = nums[i]
            elif nums[i - 1] < nums[i + 1]:
                nums[i] = nums[i - 1]
            break
    for i in range(len(nums) - 1):
        if nums[i] > nums[i + 1]:
            return False
    return True


nums = [3, 7, 5, 3]
print(checkPossibility(nums))