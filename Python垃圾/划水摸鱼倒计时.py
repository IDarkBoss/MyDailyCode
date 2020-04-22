# coding=utf-8
import os, datetime, math


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

        # 获取相差的秒数
        seconds = difference.seconds

        # 间隔分钟数:
        minutes = math.ceil(seconds / 60)
    else:
        # 早下班了
        difference = now - offWork
        statu = "after"

        # 获取相差的秒数
        seconds = difference.seconds

        # 间隔分钟数:
        minutes = math.floor(seconds / 60)

    return statu, minutes


if __name__ == "__main__":
    os.system('cls')

    statu, minutes = calculateTimeDiff()
    if statu == "before":
        remainingTime = "还有" + f"\033[1;33m{str(minutes)}\033[0m" + "分钟就要下班啦，小老弟！"
        print(remainingTime)
    else:
        beyondTime = "你都下班" + f"\033[33m{str(minutes)}\033[0m" + "分钟啦，小老弟！"
        print(beyondTime)
