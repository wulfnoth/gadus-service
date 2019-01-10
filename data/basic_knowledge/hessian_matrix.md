# Hessian矩阵

Hessian矩阵常用于牛顿法解决优化问题，利用Hessian矩阵可判定多元函数的极值问题。在工程实际问题的优化设计中，所列的目标函数往往很复杂，为了使问题简化，常常将目标函数在某点邻域展开成泰勒多项式来逼近原函数，此时函数在某点泰勒展开式的矩阵形式中会涉及到Hessian矩阵。

## 定义

一个多元函数的二阶导数有很多，我们可以将这些导数合并成一个矩阵，这个矩阵即为Hessian矩阵，Hessian矩阵$H(f)(x)$定义为：

$$H(f)(x) _ {i,j}=\frac{\partial^2 f(x)}{\partial x_i\partial x_j}$$

Hessian等价于梯度的Jacobian矩阵。

需要注意的是，微分算子在任何二阶偏导连续的点处可交换，也就是它们的顺序可以互换：

$$\frac{\partial^2}{\partial x_i\partial x_j}f(x)=\frac{\partial^2}{\partial x_j\partial x_i}f(x)$$

因此Hessian几乎处处都是对称的。

## 二元函数的Hessian矩阵

二元函数$f(x_1, x_2)$在点$x^0(x^0_1, x^0_2)$