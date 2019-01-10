# Ensembles的概念

## 什么是Ensemble？

这个单词的中文翻译是“全体；总效果”。在ml中，这个词一般是和learning连在一起，即“Ensembles learning”，翻译为“集成学习”。

集成学习并不是一个ml算法，应该说它是一种策略，ensemble learning通过构建并结合多个机器学习器来完成一个task。

## Ensemble Learning的分类

根据ensemble learning对多个机器学习器的结合方式的不同，一般我们可以将集成学习在分为三种类型：

- Bagging
- Boosting
- Stacking

下面我们分别做出介绍。

### Bagging

我们先说一个Bagging的具体应用，就是大名鼎鼎的Random Forest。Bagging也被称为**套袋法**，其算法过程如下：

- 从原始样本集中抽取训练集。每轮从原始样本集中使用**有放回的抽样方法**来抽取$n$个训练样本。共进行$k$轮抽取，得到$k$个训练集（$D_{traing}$）。
- 每次使用一个训练集得到一个模型，通过$k$个$D_{traing}$可以训练出$k$个模型，而每一个模型具体是什么模型，这需要根据具体的任务来选择。
- 对分类问题，将上步得到的$k$个模型采用投票的方式得到分类结果；对回归问题，计算上述模型的均值（或其他方法）作为最后的结果。

通过上面的算法描述我们就能看出来，如果使用Bagging+Decision Tree，那么我们最终的模型就是Random Forest。

### Boosting




## 参考资料

[1]  [liuwu265的博客](https://www.cnblogs.com/liuwu265/p/4690486.html)

[2]  [yqtaowhu的博客](https://blog.csdn.net/taoyanqi8932/article/details/54098100)