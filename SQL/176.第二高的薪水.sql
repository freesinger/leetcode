--
-- @lc app=leetcode.cn id=176 lang=mysql
--
-- [176] 第二高的薪水
--
-- https://leetcode-cn.com/problems/second-highest-salary/description/
--
-- database
-- Easy (33.19%)
-- Likes:    461
-- Dislikes: 0
-- Total Accepted:    64.2K
-- Total Submissions: 192.5K
-- Testcase Example:  '{"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100], [2, 200], [3, 300]]}}'
--
-- 编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。
-- 
-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- 
-- 
-- 例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。
-- 
-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+
-- 
-- 
--


-- ifnull(x，y)，若x不为空则返回x，否则返回y，这道题y=null
-- limit x，y，找到对应的记录就停止
-- distinct，过滤关键字

-- @lc code=start
# Write your MySQL query statement below
select ifnull (
    (select distinct Salary from Employee order by Salary desc limit 1, 1),
    null
) as SecondHighestSalary
-- @lc code=end

