-- 코드를 작성해주세요
SELECT
    ID
    , CASE 
            WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
            WHEN SIZE_OF_COLONY > 1000 THEN 'HIGH'
            ELSE 'MEDIUM'
        END AS SIZE
FROM ECOLI_DATA
ORDER BY 1;