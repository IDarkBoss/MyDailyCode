class Node:
    def __init__(self, dataval=None):
        self.dataval = dataval
        self.nextval = None


class SLinkedList:
    def __init__(self):
        self.headval = None


li = SLinkedList()
e1 = Node("Mon")
e2 = Node("Tue")
e3 = Node("Wed")

# 连接第一第二个节点
e1.nextval = e2

# 连接第二第三个节点
e2.nextval = e3

print(e2.nextval)
# 结果为e3内存地址<__main__.Node object at 0x0000001A0F9644BE0>
print(e2.nextval.dataval)
# 结果为e3所代表的值Wed
