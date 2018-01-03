# mvp
对android的mvp架构的封装，为了在使用过程中更简单。

该框架特点：
1 符合标准的MVP架构
2 解决了代码冗余、内存泄露
3 泛型设计
4 双重代理模式使代码更简单
5 生命周期的管理实现
6 状态保存

使用方法：
view层继承MvpView
presenter层继承MvpPresenter
activity/fragment继承MvpActivity/MvpFragment

具体用法参见源码

