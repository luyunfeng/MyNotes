MVVM 模式将 Presenter 改名为 ViewModel
基本上与 MVP 模式完全一致。

![image]($01_Images/MVVM.jpg)

唯一的区别是，它采用双向绑定（data-binding）：  
View的变动，自动反映在 ViewModel，反之亦然。  
Angular 和 Ember 都采用这种模式。