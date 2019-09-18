from numpy import *
import math
def Jacobi(mx, mr, n, c):
    if len(mx) == len(mr):  # 若mx和mr长度相等则开始迭代 否则方程无解
        x = []  # 迭代初值 初始化为单行全0矩阵
        for i in range(len(mr)):
            x.append([0])
        count = 0  # 迭代次数计数
        while count < n:
            q = 0
            nx = []  # 保存单次迭代后的值的集合
            for i in range(len(x)):
                nxi = mr[i][0]
                for j in range(len(mx[i])):
                    if j != i:
                        nxi = nxi + (-mx[i][j]) * x[j][0]
                nxi = nxi / mx[i][i]
                nx.append([nxi])  # 迭代计算得到的下一个xi值
            lc = []  # 存储两次迭代结果之间的误差的集合
            for i in range(len(x)):
                lc.append(abs(x[i][0] - nx[i][0]))
            for j in range(len(lc)):
                p = math.pow(lc[j], 2)
                q = q + p
            q = math.pow(q , 0.5)
            if q < c:
                print("迭代次数:", count )
                return nx  # 当误差满足要求时 返回计算结果
            x = nx
            count = count + 1
        return False  # 若达到设定的迭代结果仍不满足精度要求 则方程无解
    else:
        return False


n = int(input("请输入矩阵维度n: "))
print("请输入系数矩阵：")
mx = zeros((n,n))
for i in range(n):
    for j in range(n):
          mx[i][j] = int(input())
print("请输入值向量：")
mr = zeros((n,1))
for k in range(n):
    mr[k][0] = int(input())

# mx = [[8,-3,2],[4,11,-1],[6,3,12]]
# mr = [[20],[33],[36]]

# 测试数据
# mx = [[4, -1, 0, -1, 0, 0], [-1, 4, -1, 0, -1, 0], [0, -1, 4, -1, 0, -1], [-1, 0, -1, 4, -1, 0], [0, -1, 0, -1, 4, -1], [0, 0, -1, 0, -1, 4]]
# mr = [[0], [5], [-2], [5], [-2], [6]]
print(Jacobi(mx, mr, 100, 0.00001))