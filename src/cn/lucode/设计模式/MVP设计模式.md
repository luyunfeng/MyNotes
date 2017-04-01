MVP模式将MVC中的 Controller改为
Presenter，同时改变了通信方向
![image]($01_Images/MVP.jpg)
* 各部分之间的通信，都是双向的。
* View 与 Model 不发生联系，都通过 Presenter 传递。
* View 非常薄，不部署任何业务逻辑，称为"被动视图"（Passive View），即没有任何主动性，而 Presenter非常厚，所有逻辑都部署在那里。