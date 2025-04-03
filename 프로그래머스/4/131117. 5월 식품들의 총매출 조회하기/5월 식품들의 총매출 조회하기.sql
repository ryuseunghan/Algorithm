-- 코드를 입력하세요
SELECT A.PRODUCT_ID, PRODUCT_NAME, SUM(AMOUNT) * PRICE AS TOTAL_SALES
FROM FOOD_PRODUCT AS A JOIN FOOD_ORDER AS B ON A.PRODUCT_ID = B.PRODUCT_ID
WHERE PRODUCE_DATE LIKE "2022-05%"
GROUP BY PRODUCT_NAME
ORDER BY TOTAL_SALES DESC, PRODUCT_ID	



/*
    요구사항 : 생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성
               총매출을 기준으로 내림차순 정렬해주시고 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬
    FOOD_PRODUCT
    
    
    
    FOOD_ORDER 
    
*/