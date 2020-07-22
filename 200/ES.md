1. 为什么ES快？简要介绍下与RDB的区别？


2. 如何保证`unique index`在es中的存储？

- http request里加参数`op_type = create`，如果存在改字段就报错
- 新建一个字段和`_id`关联