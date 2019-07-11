# hw3ForAndroidCamp

3170105468-武靖超-安卓开发作业3

本次按要求完成了ex1，ex2和ex3，下面简述工作记录及笔记。

### ex1

利用setProgress函数完成拖动动画。注意，int/float并不会自动转为float，需强制转换。

### ex2

仿照颜色变换的样例，实现了多种其他动画控制。

这里学习到ObjectAnimator类，可以对属性进行动态赋值，有ofArgb，ofInt，ofFloat等，分别对应不同属性值类型。

### ex3

按照要求添加了ViewPager和Fragment（设置了三个tab，每个tab是一样的。若需修改需要把position作为参数传入Fragment的构造函数中），每个Fragment中由一个lottie动画（加载）和数据列表（RecyclerView）组成；其中数据列表实现与Chapter2中类似，不再赘述。

- 注意，xml文件中控件使用不兼容并不会报错，只是在运行时查看log才会看到