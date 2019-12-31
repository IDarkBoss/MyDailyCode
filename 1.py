import matplotlib.pyplot as plt

# 根据y=2*x+b随意写几个数
X = [1, 2, 3, 4, 5, 6, 7]
Y = [3.09, 5.06, 7.03, 9.12, 10.96, 12, 17.01]

Xsum = 0.0
X2sum = 0.0
Ysum = 0.0
XY = 0.0
n = len(X)
for i in range(n):
    Xsum += X[i]
    Ysum += Y[i]
    XY += X[i] * Y[i]
    X2sum += X[i]**2
k = (Xsum * Ysum / n - XY) / (Xsum**2 / n - X2sum)
b = (Ysum - k * Xsum) / n
print('the line is y=%f*x+%f' % (k, b))

fig = plt.figure()
ax1 = fig.add_subplot(121)
ax1.scatter(X, Y, c='r', marker='o')
bb = [i * k + b for i in X]
ax1.plot(X, bb)
plt.show()
