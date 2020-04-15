# coding=utf-8
import datetime


# 任意输入一个年月日，计算距离今天几年几月几日。
# 要求：
# 使用函数，可复用
# 输入格式：1920.3.28
# 年份范围：1700-2018，超出提示
# 一年按照365天，一月按照30天计算。
def calculateTimeDiff(inputTimeStr):

    arr = inputTimeStr.strip().split('.')
    year = int(arr[0])

    if year <= 1700 or year >= 2021:
        return '输入的日期必须位于1700-2020之间'

    inputTime = None
    try:
        # 将字符串转换为datetime
        inputTime = datetime.datetime.strptime(inputTimeStr, '%Y.%m.%d')
    except:
        return '输入日期格式不符合规则,格式必须为1980.10.20'

    # 获取当前的datetime
    now = datetime.datetime.now()
    # 计算时间差
    n_days = now - inputTime
    # 获取相差的总天数
    days = n_days.days
    # 获取间隔年数:
    year = days // 365
    # 间隔月数
    month = days % 365 // 30
    # 间隔天数:
    day = days % 365 % 30
    print('间隔:' + str(year) + '年' + str(month) + '月' + str(day) + '日')


# 类中调用测试
# inputTimeStr = input('请输入计算日期(格式为:1980.10.20):')
# print(calculateTimeDiff(inputTimeStr))
if __name__ == "__main__":
    calculateTimeDiff("2020.04.15")
