--
-- @lc app=leetcode.cn id=175 lang=mysql
--
-- [175] 组合两个表
--
-- https://leetcode-cn.com/problems/combine-two-tables/description/
--
-- database
-- Easy (70.57%)
-- Likes:    505
-- Dislikes: 0
-- Total Accepted:    86.4K
-- Total Submissions: 122K
-- Testcase Example:  '{"headers": {"Person": ["PersonId", "LastName", "FirstName"], "Address": ["AddressId", "PersonId", "City", "State"]}, "rows": {"Person": [[1, "Wang", "Allen"]], "Address": [[1, 2, "New York City", "New York"]]}}'
--
-- 表1: Person
-- 
-- +-------------+---------+
-- | 列名         | 类型     |
-- +-------------+---------+
-- | PersonId    | int     |
-- | FirstName   | varchar |
-- | LastName    | varchar |
-- +-------------+---------+
-- PersonId 是上表主键
-- 
-- 
-- 表2: Address
-- 
-- +-------------+---------+
-- | 列名         | 类型    |
-- +-------------+---------+
-- | AddressId   | int     |
-- | PersonId    | int     |
-- | City        | varchar |
-- | State       | varchar |
-- +-------------+---------+
-- AddressId 是上表主键
-- 
-- 
-- 
-- 
-- 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
-- 
-- 
-- 
-- FirstName, LastName, City, State
-- 
-- 
--

-- @lc code=start
# Write your MySQL query statement below
select FirstName, LastName, City, State 
from Person as p left join Address as a
on p.PersonId = a.PersonId
-- @lc code=end

