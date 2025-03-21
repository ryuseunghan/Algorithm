-- 코드를 입력하세요
# SELECT distinct F.FLAVOR
# FROM FIRST_HALF AS F
# WHERE F.TOTAL_ORDER > 3000 AND F.FLAVOR IN(SELECT FLAVOR FROM ICECREAM_INFO WHERE INGREDIENT_TYPE = "fruit_based")
# ORDER BY F.TOTAL_ORDER

SELECT F.FLAVOR
FROM FIRST_HALF AS F
WHERE F.TOTAL_ORDER > 3000
  AND F.FLAVOR IN (
    SELECT FLAVOR
    FROM ICECREAM_INFO
    WHERE INGREDIENT_TYPE = 'fruit_based'
)
ORDER BY F.TOTAL_ORDER DESC;
