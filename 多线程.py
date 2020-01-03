import threading
from queue import Queue


def job1():
    global A, lock

    lock.acquire()

    for i in range(10):
        A = A + 10
        print("job1", A)

    lock.release()


def job2():
    global A, lock

    lock.acquire()

    for i in range(10):
        A = A + 100
        print("job1", A)

    lock.release()


if __name__ == "__main__":
    A = 0
    lock = threading.Lock()

    td1 = threading.Thread(target=job1)
    td2 = threading.Thread(target=job2)

    td1.start()
    td2.start()

    td1.join()
    td2.join()
