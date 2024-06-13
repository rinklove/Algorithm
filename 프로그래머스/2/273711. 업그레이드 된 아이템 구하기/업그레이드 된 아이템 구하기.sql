-- 코드를 작성해주세요
select
    f.item_id
    , f.item_name
    , f.rarity
from item_info f
inner join item_tree t
on f.item_id = t.item_id
where t.parent_item_id in (
                        select 
                           item_id
                        from item_info 
                        where rarity = 'RARE'
                    )
order by 1 desc;

-- 전체 데이터 조회용 쿼리
# select 
#     f.*
#     , t.*
# from item_info f
# join item_tree t
# on f.item_id = t.item_id;