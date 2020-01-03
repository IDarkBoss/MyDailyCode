import multiprocessing as mp
mp.set_start_method("spawn", True)  # 必须！！！


def compute(q):
    a = 0
    for i in range(1000):
        a = i + i**2
    q.put(a)


if __name__ == "__main__":
    q = mp.Queue()
    p1 = mp.Process(target=compute, args=(q, ))
    p2 = mp.Process(target=compute, args=(q, ))

    p1.start()
    p2.start()

    p1.join()
    p2.join()

    result1 = q.get()
    result2 = q.get()
    print(result1 + result2)
