-- 코드를 작성해주세요
SELECT ID, FISH_NAME, LENGTH
FROM FISH_INFO AS A LEFT JOIN FISH_NAME_INFO AS B ON A.FISH_TYPE = B.FISH_TYPE
WHERE LENGTH = (SELECT MAX(LENGTH)
            FROM FISH_INFO AS A2
            WHERE A.FISH_TYPE  = A2.FISH_TYPE 
            GROUP BY FISH_NAME
            )
ORDER BY ID;
/*
요구사항
물고기의 ID -> ID
이름 -> FISH_NAME
길이 -> LENGTH
- 물고기 ID 오름차순
- 믈고기 종류별 가장 큰 물고기는 1마리
- 10CM 이하 물고기가 가장 큰 경우 X

FISH_INFO 테이블
ID : 물고기의 ID
FISH_TYPE : 물고기의 종류(숫자)
LENGTH : 잡은 물고기의 길이(cm)
TIME : 물고기를 잡은 날짜

FISH_NAME_INFO 테이블
FISH_TYPE : 물고기의 종류(숫자)
FISH_NAME  : 물고기의 이름(문자) 
*/