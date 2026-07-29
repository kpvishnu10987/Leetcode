# Write your MySQL query statement below
select c.name as customers
from customers c
where not exists (select 1 from orders o where o.customerid = c.id);