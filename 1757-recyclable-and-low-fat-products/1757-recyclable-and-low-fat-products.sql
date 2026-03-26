# Write your MySQL query statement below
select product_id 
from Products as p
where p.low_fats = 'Y' and p.recyclable = 'Y';