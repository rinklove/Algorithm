-- 코드를 작성해주세요
/*
            100
           1000
       10000000
      100000000
    10000000000
   100000000000
 10000000000000
100000000000000 
&을 사용하여 연산
*/
select 
    id
    , email
    , first_name
    , last_name
from developers
where 
    skill_code & (select code from skillcodes where name = 'C#') 
    or skill_code & (select code from skillcodes where name = 'Python') 
order by 1
;