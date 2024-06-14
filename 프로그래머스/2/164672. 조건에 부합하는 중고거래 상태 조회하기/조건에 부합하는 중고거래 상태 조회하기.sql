-- 코드를 입력하세요
SELECT
    BOARD_ID
    , WRITER_ID
    , TITLE
    , PRICE
    , CASE 
        WHEN STATUS = 'SALE' THEN '판매중'
        WHEN STATUS = 'RESERVED' THEN '예약중'
        ELSE '거래완료'
    END AS '거래상태'
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER BY 1 DESC
;