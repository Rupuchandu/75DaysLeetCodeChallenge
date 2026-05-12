# Write your MySQL query statement below
Select (Select Distinct salary from Employee Order by salary Desc Limit 1 Offset 1) as SecondHighestSalary;