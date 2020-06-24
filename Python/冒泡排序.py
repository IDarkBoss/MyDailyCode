import random

nums = [random.randint(1, 10) for i in range(10)]

for j in range(len(nums)):
    for i in range(len(nums) - 1):
        if nums[i] > nums[i + 1]:
            nums[i], nums[i + 1] = nums[i + 1], nums[i]

print(nums)