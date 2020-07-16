epoll?

Redis 为什么用跳表而不用平衡树？

redis中sorted set的实现是这样的：
  [优质解答](https://juejin.im/post/57fa935b0e3dd90057c50fbc#heading-1)
- 当数据较少时，sorted set是由一个ziplist来实现的。
- 当数据多的时候，sorted set是由一个dict + 一个skiplist来实现的。简单来讲，dict用来查询数据到分数的对应关系，而skiplist用来根据分数查询数据（可能是范围查找）。

