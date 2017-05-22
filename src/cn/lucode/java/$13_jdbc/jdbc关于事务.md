# 事务的四大特性是：
* 原子性（Atomicity）：
> 事务中所有操作是不可再分割的原子单位。事务中所有操作要么全部执行成功，要么全部执行失败。
* 一致性（Consistency）：
> 事务执行后，数据库状态与其它业务规则保持一致。如转账业务，无论事务执行成功与否，参与转账的两个账号余额之和应该是不变的。
* 隔离性（Isolation）：
> 隔离性是指在并发操作中，不同事务之间应该隔离开来，使每个并发中的事务不会相互干扰。
* 持久性（Durability）：
> 一旦事务提交成功，事务中所有的数据操作都必须被持久化到数据库中，即使提交事务后，数据库马上崩溃，在数据库重启时，也必须能保证通过某种机制恢复数据。

# mysql 中的事务  

在默认情况下，MySQL每执行一条SQL语句，
都是一个单独的事务。如果需要在一个事务中包含多条SQL语句，
那么需要开启事务和结束事务。
* 开启事务：start transaction；
* 结束事务：commit或rollback。  


在执行SQL语句之前，先执行strat transaction，
这就开启了一个事务（事务的起点），然后可以去执行多条SQL语句，
最后要结束事务，commit表示提交，
即事务中的多条SQL语句所做出的影响会持久化到数据库中。
或者rollback，表示回滚，即回滚到事务的起点，之前做的所有操作都被撤消了！

# jdbc 中关于事务的处理
Connection的三个方法与事务相关：
* setAutoCommit(boolean)：
> 设置是否为自动提交事务，如果true（默认值就是true）表示自动提交，也就是每条执行的SQL语句都是一个单独的事务，如果设置false，那么就相当于开启了事务了；con.setAutoCommit(false)表示开启事务！！！
* commit()：
> 提交结束事务；con.commit();表示提交事务
* rollback()：
> 回滚结束事务。con.rollback();表示回滚事务

格式:
```java
jdbc处理事务的代码格式：
try {
  con.setAutoCommit(false);//开启事务…
  ….
  …
  con.commit();//try的最后提交事务
} catch() {
  con.rollback();//有问题就回滚事务
}
```



