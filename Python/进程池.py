import multiprocessing as mp
mp.set_start_method("spawn", True)


def job(x):
    return x * x


def multicore():
    pool = mp.Pool(processes=2)
    res = pool.map(job, range(10))
    print(res)

    res = pool.apply_async(job, (2, ))
    print(res.get())

    multi_res = [pool.apply_async(job, (i, )) for i in range(10)]
    print([res.get() for res in multi_res])

    pool.close()
    pool.join()


if __name__ == '__main__':
    multicore()