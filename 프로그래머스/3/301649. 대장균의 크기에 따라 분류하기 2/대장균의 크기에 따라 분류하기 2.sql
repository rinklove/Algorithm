-- 코드를 작성해주세요.
-- PERCENT_RANK() 미사용
# SELECT
#     A.ID
#     , CASE 
#         WHEN A.ROWNUM / A.LENGTH <= 0.25 THEN 'CRITICAL'
#         WHEN A.ROWNUM / A.LENGTH <= 0.50 THEN 'HIGH'
#         WHEN A.ROWNUM / A.LENGTH <= 0.75 THEN 'MEDIUM'
#         ELSE 'LOW'
#     END AS COLONY_NAME
# FROM (
#         SELECT 
#             ID
#             , ROW_NUMBER() OVER(ORDER BY SIZE_OF_COLONY DESC) ROWNUM
#             , (SELECT COUNT(*) FROM ECOLI_DATA) LENGTH
#         FROM ECOLI_DATA
#     ) A
# ORDER BY 1;

-- PERCENT_RANK() 사용
SELECT
    A.ID
    , CASE 
        WHEN A.PER <= 0.25 THEN 'CRITICAL'
        WHEN A.PER <= 0.50 THEN 'HIGH'
        WHEN A.PER <= 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (
        SELECT 
            ID
            , PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) PER
        FROM ECOLI_DATA
    ) A
ORDER BY 1;