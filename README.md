# mvp

这是我对android的mvp架构的一个轻量级封装，为了我们在应用开发中使用mvp过程中更简单。

如果你对mvp架构还不了解，建议你先学习与了解一下mvp架构的知识。

当然你也可以直接下载源码在你的项目中直接使用。



该框架特点：
----

1 符合标准的MVP架构

2 解决了代码冗余、内存泄露

3 泛型设计

4 双重代理模式使代码更简单

5 生命周期的管理实现

6 状态保存


使用方法：
----

view层继承MvpView

presenter层继承MvpPresenter

activity/fragment继承MvpActivity/MvpFragment

view与presenter获得：
------
getMvpView();

getMvpPresenter();



具体用法参见源码

