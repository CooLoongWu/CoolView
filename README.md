# 自定义视图类

可能每位开发者都需要更便捷、更高效的视图类来增加开发效率，并将其中承载的知识及价值传播给他人，
**CoolView** 是我自己在开发中所遇到的需要自定义视图的类，并在逐步添加完善。 
您可以使用 CoolView：

> * 方便的集成、使用某些View
> * 参考代码并封装成您自己的视图

## 1. MoneyView
MoneyView是一个金钱类的视图，整数部分字体大，小数部分字体小，如下所示：

![image](./pictures/money_view.jpg)

###使用方法
布局中使用示例：
```
    <com.cooloongwu.coolview.MoneyView
        android:id="@+id/money_view"
        android:layout_width="match_parent"
        android:layout_height="180dp"
        android:background="@color/colorPrimary"
        app:moneyColor="@android:color/white"
        app:moneyDecimalDimension="24sp"
        app:moneyDotDimension="32sp"
        app:moneyIntegerDimension="48sp" />
```

java中使用示例：
```
    MoneyView moneyView = (MoneyView) findViewById(R.id.money_view);
    //double类型，可以是“.3”、“.223”、“11”、“11.”，注意小数点2位后会进行五舍六入
    moneyView.setMoney(1560.);
```

特殊值说明：
> * 当setMoney(.3)，  显示0.30
> * 当setMoney(.301)，显示0.30
> * 当setMoney(.306)，显示0.31
> * 当setMoney(11)，  显示11.00
> * 当setMoney(11.)， 显示11.00

## 2. OlympicRingsView
OlympicRingsView是一个奥运五环的视图，如下所示：

![image](./pictures/olympic_rings_view.jpg)

###使用方法
布局中直接使用：
```
    <com.cooloongwu.coolview.OlympicRingsView
        android:layout_width="match_parent"
        android:layout_height="200dp" />
```

##License

The MIT License (MIT)

Copyright (c) 2016 [@CooLoongWu][2]

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

2016 年 09月 08日 

[1]: https://cooloongwu.github.io/
[2]: http://blog.csdn.net/u010976213


