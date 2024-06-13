-- 코드를 작성해주세요
SELECT
    A.ID ID
    , A.LENGTH LENGTH
FROM (
        SELECT 
            ID
            , LENGTH
            , ROW_NUMBER() OVER(ORDER BY LENGTH DESC, ID) ROWNUM
        FROM FISH_INFO
        WHERE LENGTH IS NOT NULL
    ) A
WHERE A.ROWNUM <= 10
;

