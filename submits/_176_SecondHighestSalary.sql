-- Write a SQL query to get the second highest salary from the Employee table.

-- +----+--------+
-- | Id | Salary |
-- +----+--------+
-- | 1  | 100    |
-- | 2  | 200    |
-- | 3  | 300    |
-- +----+--------+
-- For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.

-- +---------------------+
-- | SecondHighestSalary |
-- +---------------------+
-- | 200                 |
-- +---------------------+

select ifnull((select distinct salary from Employee order by salary desc limit 1, 1), null) as SecondHighestSalary;

-- SELECT MAX(Salary) AS SecondHighestSalary FROM Employee, (SELECT MAX(Salary) AS MaxSalary FROM Employee) AS T WHERE Salary != MaxSalary;

-- SELECT COALESCE(
--     (SELECT DISTINCT Salary FROM Employee
--     ORDER BY Salary DESC LIMIT 1 OFFSET 1)) AS SecondHighestSalary;