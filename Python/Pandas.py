import pandas as pd
import os

os.system("cls")
# data_url = "https://raw.githubusercontent.com/mwaskom/seaborn-data/master/tips.csv"
# df = pd.read_csv(data_url)
# df.to_csv(r"Resources\tips.csv")

df = pd.read_csv(r"Resources\tips.csv")

# 输出表格维度
print(df.shape)

# 输出表格
print(df)

# 表格转置
print(df.T)

# 输出第2、4、6行，第3、5列
print(df.iloc[[1, 3, 5], [2, 4]])

# 输出行名为10、11、12，列名为"total_bill"和"tip"
print(df.loc[[10, 11, 12], ["total_bill", "tip"]])

# 输出第3行、第2列的单元格
print(df.iat[3, 2])

# 筛选出小费大于$7 或 总账单大于$50的数据
print(df[(df.tip > 7) | (df.total_bill > 50)])

# 筛选出小费大于$7 且 总账单大于$50的数据
print(df[(df.tip > 7) & (df.total_bill > 50)])
