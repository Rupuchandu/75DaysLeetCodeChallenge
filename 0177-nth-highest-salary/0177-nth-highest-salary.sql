CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
 Set N=N-1;
  RETURN (
      # Write your MySQL query statement below.
    Select Distinct salary
    From Employee
    Order by salary Desc
    limit 1 offset N
  );
END