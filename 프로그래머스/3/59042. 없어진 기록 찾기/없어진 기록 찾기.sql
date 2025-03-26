-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME
FROM ANIMAL_OUTS
WHERE ANIMAL_ID NOT IN (
    SELECT A.ANIMAL_ID
    FROM ANIMAL_INS A
    LEFT JOIN ANIMAL_OUTS B ON A.ANIMAL_ID = B.ANIMAL_ID
    )
ORDER BY ANIMAL_ID;
/*
요구사항
- 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물 ID와 이름
- ID 순으로 조회

ANIMAL_INS 테이블  보호소에 들어온 동물
ANIMAL_ID 동물의 아이디
ANIMAL_TYPE 생물 종
DATETIME 보호 시작일
INTAKE_CONDITION 보호 시작 시 상태
NAME 이름
SEX_UPON_INTAKE 성별 및 중성화

ANIMAL_OUTS 테이블 보호소에서 입양
ANIMAL_ID 동물의 아이디 FK
ANIMAL_TYPE 생물 종
DATETIME 입양일
NAME 이름
SEX_UPON_OUTCOME 성별 및 중성화 여부
*/