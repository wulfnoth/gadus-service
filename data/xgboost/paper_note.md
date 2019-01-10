# XGBoost: A Scalable Tree Boosting System

## ABSTRACT

Tree Boosting是一个非常有效并被广泛使用的机器学习算法。在这篇论文中，我们描述一种可伸缩的、端对端的tree boosting系统，我称之为XGBoost。我提出了一个新奇的sparsity-aware算法来处理稀疏数据（缺失值很多），以及加权分位数草图（weighted quantile sketch）的方法来完成近似树学习（approximate tree learning）。更重要的是，我们在缓存访问模式、数据压缩和共享方面有什么的理解，来构建一个可扩展的tree boosting系统。通过这些关键点，XGBoost相比其他系统使用更少的资源就能处理超过十亿量级的样本。

**keywords**：Large-scale Machine Learning

## Introduction

机器学习和数据驱动方法在某些领域变得原来越重要。智能垃圾信息分类器通过从大量的垃圾信息数据和用户的反馈进行学习，来保护我们的电子邮箱；广告系统学习将正确的广告和正确的上下文进行匹配。诈骗检测系统保护银行系统不会受到恶意攻击，异常事件检测系统帮助实验物理学家找到能够让其有新的发现的事件。这些应用的成功离不开两个重要的因素：1、有效的（统计）模型的使用可以获取到复杂数据的相关性。2、可扩展的学习模型使得可以从大规模数据集中学习到模型感兴趣的东西。

在实践中使用的机器学习模型之中，gradient tree boosting方法是一种在很多领域都有很好表现的技术。Tree boosting在很多标准分类器检测中都给出了最好的结果。LambdaMART是一个tree boosting的变种用于排序，它在排序问题中有非常好的表现。Tree Boosting除了单独作为预测期之外，它还能用于现实产品pipeline中通过点击率预测来进行ad click的工作。

在这篇文章中个，我们描述XGBoost，一种基于tree boosting的可扩展机器学习系统。这个系统已经提供了开源的package。这个系统已经深刻的影响了很多的寄去学习和数据挖掘challenges。例如说Kaggle在2015年有29个竞赛的获胜方案中，有17个方案使用了XGBoost，其中有8个方案单独使用了XGBoost，而另外9个方案是将XGBoost和神经网络进行了结合。作为比较当年采用第二多的方法是深度神经网络，它被用于了11个解决方案。

XGBoost的成功最重要的因素是它在任意情况下的可扩展性。这个系统在单机中相比于已经存在的其他主流方案要快10倍，并且他可以使用分布式扩展至处理十亿级的样本。XGBoost的可扩展性应归功于一些重要的系统和算法性的优化。其中包括：一个用于解决的稀疏数据的树学习算法；一个能从理论上表明正确的加权分位数草图处理使得在近似树学习中能够处理实例权重。并行和分布式计算使得学习的更快，保证了更快的产品迭代速度。更为重要的是，XGBoost采用了一种外存（out of core）计算，使得数据科学家可以在桌面级计算机中处理上亿的样本。最终令人兴奋的是通过结合这些技术而制造出的一个端对端的系统。这篇论文中的主要贡献是：

- 我们设计并且构建了一个高扩展的端对端tree boosting模型。
- 我们提出了一种在理论中正确的加权分为草图，可以通过它来高效的计算方案。
- 我们介绍了一种sparsity-aware算法用于并行的tree learning。
- 我们提出了一种cache-ware块结构来用于外存（out of core）的树学习。

在[22, 23, 19]中已经在并行tree boosting方面有了一些研究，但是没有涉及out-of-core computation，cache-aware和sparsity-aware学习方面。

我们额外提升了正则化的学习目标。