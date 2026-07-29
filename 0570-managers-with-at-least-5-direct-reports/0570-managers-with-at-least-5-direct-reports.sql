# Write your MySQL query statement below
select s.name
from employee e
join employee s
on s.id = e.managerId
group by s.id 
having count(*) > 4;