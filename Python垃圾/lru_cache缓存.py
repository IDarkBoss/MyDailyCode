import functools
import time


@functools.lru_cache(maxsize=12)
def slow_func(x):
    time.sleep(2)
    return x


print(slow_func(1))
print(slow_func(1))
print(slow_func(2))