aa = [1, 2, 3, 4, 5, 6]
bb = []

for i in range(len(aa)):
    name = "num" + str(i)
    locals()["num" + str(i)] = i
    bb.append(locals()["num" + str(i)])

print(bb)