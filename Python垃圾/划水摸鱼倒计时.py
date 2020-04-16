# coding=utf-8
import datetime, math
import os


def calculateTimeDiff():
    year = datetime.datetime.now().year
    month = datetime.datetime.now().month
    day = datetime.datetime.now().day

    offWork = str(year) + "-" + str(month) + "-" + str(
        day) + " " + "18" + ":" + "00" + ":" + "00"

    offWork = datetime.datetime.strptime(offWork, "%Y-%m-%d %H:%M:%S")

    # 获取当前的datetime
    now = datetime.datetime.now()

    # 计算时间差
    if offWork > now:
        # 还没下班
        difference = offWork - now
        statu = "before"
    else:
        # 早下班了
        difference = now - offWork
        statu = "after"

    # 获取相差的秒数
    seconds = difference.seconds

    # 间隔分钟数:
    minutes = math.ceil(seconds / 60)

    return statu, minutes


if __name__ == "__main__":
    os.system('cls')

    statu, minutes = calculateTimeDiff()
    if statu == "before":
        remainingTime = "还有" + str(minutes) + "分钟就要下班啦，老弟！"
    else:
        beyond = "你都下班" + str(minutes) + "分钟啦，老弟！"

    print(remainingTime)
