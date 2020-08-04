1. 为什么ES快？简要介绍下与RDB的区别？

- 本地缓存（第一次慢，后面就很快）
- 底层采用了倒排索引（存储引擎类似）
- 分布式处理（数据量大、并发量大的时候很有优势）

2. 如何保证`unique index`在es中的存储？

- http request里加参数`op_type = create`，如果存在改字段就报错
- 新建一个字段和`_id`关联

3. 如何实现子查询等复杂功能？

[全家桶](https://blog.csdn.net/wangxiaotongfan/category_5593095.html)