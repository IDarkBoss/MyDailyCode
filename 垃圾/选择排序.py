import random

nums = [random.randint(1, 10) for i in range(10)]
result = []

for i in range(len(nums)):
    a = nums.index(min(nums))
    b = nums.pop(a)
    result.append(b)

print(result)