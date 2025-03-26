-- 코드를 작성해주세요
SELECT SUM(PRICE) AS TOTAL_PRICE
FROM ITEM_INFO 
WHERE RARITY = "LEGEND";
/* 
요구사항  
- ITEM_INFO 테이블에서 희귀도가 'LEGEND'인 아이템들의 가격의 총합
- 컬럼명은 'TOTAL_PRICE'로 지정

ITEM_INFO 테이블

ITEM_ID 아이템 ID
ITEM_NAME 아이템 명
RARITY 아이템의 희귀도
PRICE 아이템의 가격
*/