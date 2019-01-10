# 泰勒展开

## 泰勒展开

**泰勒展开**：若函数$f(x)$在闭区间$[a,b]$上存在直至n阶的连续导函数，在开区间$(a,b)$内存在$(n+1)$阶导函数，则对任意给定的$x,x_0 \in [a,b]$，至少存在一点$\xi \in (a,b)$，使得 

$$f(x)=f(x_0)+f'(x_0)(x−x_0)+\frac{f''(x0)}{2!}(x−x_0)^2+...\frac{f^{(n)}(x_0)}{n!}(x−x_0)^n+\frac{f^{(n+1)}(\xi)}{(n+1)!}(x−x_0)^{n+1}$$

## 多元函数泰勒展开

对于函数$f(x)$，$x$是$n$维向量，**多元泰勒展开**的公式如下图所示：

$$f(x)\approx f(x_0)+D(x-x_0) + \frac{1}{2}(x-x_0)^TH(x-x_0)$$

其中$D$为：

$$Df(a,b)=[\frac{\partial f(a,b)}{x_1}, \frac{\partial f(a,b)}{x_2}]$$

$$Hf=[\frac{\partial^2 f(a,b)}{x^2_1}, \frac{\partial^2 f(a,b)}{x_1x_2}]$$
$$Hf=[\frac{\partial^2 f(a,b)}{x_2x_1}, \frac{\partial^2 f(a,b)}{x^2_2}]$$