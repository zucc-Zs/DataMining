import numpy as np
def Gauss(mx, mr, n, c):
    times = 0
    x = []
    for i in range(len(mr)):
        x.append(0.0)
    x0 = []
    for i in range(len(mr)):
        x0.append(1.0)
    x = np.array(x)
    x0 = np.array(x0)

    while times < n:
        p = 0
        for i in range(len(mr)):
            temp = 0
            tempx = x0.copy()
            for j in range(len(mr)):
                if i != j:
                    temp += x0[j] * mx[i][j]
            x[i] = (mr[i] - temp) / mx[i][i]
            x0[i] = x[i].copy()
        calTemp = x - tempx
        for i in range(len(calTemp)):
            p += calTemp[i]**2
        times += 1

        if np.sqrt(p) < c:
            print("迭代次数:", times)
            return x
        else:
            x0 = x.copy()

# mx = np.array([[8,-3,2],[4,11,-1],[6,3,12]])
# mr = np.array([20,33,36])

n = int(input("请输入矩阵维度n: "))
print("请输入系数矩阵：")
mx = np.zeros((n,n))
for i in range(n):
    for j in range(n):
          mx[i][j] = int(input())
print("请输入值向量：")
mr = np.zeros((n,1))
for k in range(n):
    mr[k][0] = int(input())

# 测试数据
# mx = np.array([[4, -1, 0, -1, 0, 0], [-1, 4, -1, 0, -1, 0], [0, -1, 4, -1, 0, -1], [-1, 0, -1, 4, -1, 0], [0, -1, 0, -1, 4, -1], [0, 0, -1, 0, -1, 4]])
# mr = np.array([[0], [5], [-2], [5], [-2], [6]])
print(Gauss(mx, mr, 100, 0.00001))
