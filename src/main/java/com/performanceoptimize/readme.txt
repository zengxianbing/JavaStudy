java性能优化笔记

1性能的参考指标
    执行时间
 cpu时间
   内存分配
   磁盘吞吐量
   网络吞吐量
   响应时间
 
 2性能瓶颈
 磁盘I/O
 网络操作
 cpu
 异常
 数据库
 锁竞争
 内存
 
 3 性能优化的层次
 设计调优
 代码调优
jvm调优
数据库调优
操作系统调优

4  常用优化组件和方法
缓冲（IO/NIO）
缓存
对象复用--池
并行替代串行
 负载均衡（apache+tomcat）（脸型session模式和复制session模式，Terracotta）
时间换空间
空间换时间
 
 
 5 String
 subString()方法的内存泄漏
 字符串分割和查找
 使用StringTokenizer类分割字符串
高效率的charAt()方法

如果可以，则尽量直接访问内部元素，而不要调用对应的接口，函数调用是需要消耗系统资源的


6  引用
WeakHashMap 


替换switch
展开循环

使用arrayCopy() 

使用Buffer进行io操作
 
使用clone()代替new
 
 
第4章  并行程序开发与优化

Future模式

Master-Worker模式
 
Guarded Suspension模式
 
 
不变模式
 
生产者和消费者模式 
 
4.4  并发控制方法
 
 内部锁  重入锁  读写锁  信号量
 
 
 
 
 
 
 
 
 
 
 
 
 