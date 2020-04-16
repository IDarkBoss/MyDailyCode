# coding=utf-8
import datetime, math


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
    difference = offWork - now

    # 获取相差的秒数
    seconds = difference.seconds

    # 间隔分钟数:
    minutes = math.ceil(seconds / 60)

    return minutes


if __name__ == "__main__":
    minutes = calculateTimeDiff()
    remainingTime = ("还有" + str(minutes) + "分钟下班啦")

    print(remainingTime)
