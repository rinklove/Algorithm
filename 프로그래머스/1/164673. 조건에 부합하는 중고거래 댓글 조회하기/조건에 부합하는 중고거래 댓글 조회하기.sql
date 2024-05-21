-- 코드를 입력하세요
SELECT A.TITLE, A.BOARD_ID, B.REPLY_ID, B.WRITER_ID, 
B.CONTENTS, date_format(B.CREATED_DATE, '%Y-%m-%d') CREATED_DATE
FROM USED_GOODS_BOARD A INNER JOIN USED_GOODS_REPLY B
ON A.BOARD_ID = B.BOARD_ID
WHERE date_format(A.CREATED_DATE, '%Y-%m') = '2022-10'
ORDER BY 6, 1;