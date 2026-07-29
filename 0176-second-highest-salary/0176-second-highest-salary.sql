# Write your MySQL query statement below
select MAX(salary) as SecondHighestSalary 
from (
    select salary,
        dense_rank() over(order by salary desc) as rnk
    from employee
) as t
where rnk = 2;