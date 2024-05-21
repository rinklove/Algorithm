-- 코드를 입력하세요
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, TO_CHAR(R.REVIEW_DATE, 'YYYY-MM-DD')
FROM REST_REVIEW R INNER JOIN MEMBER_PROFILE M
ON R.MEMBER_ID = M.MEMBER_ID
WHERE R.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM REST_REVIEW 
    GROUP BY MEMBER_ID
    HAVING COUNT(*) = (
        SELECT MAX(COUNT(*))
        FROM REST_REVIEW 
        GROUP BY MEMBER_ID
    )
)
ORDER BY 3, 2;