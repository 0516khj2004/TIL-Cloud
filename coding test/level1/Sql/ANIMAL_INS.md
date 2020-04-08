# ANIMAL_INS 

### 최대값 구하기 

- 가장 최근에 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
  - SELECT max(DATETIME) as "시간" from ANIMAL_INS 
- 동물 보호소에 동물이 몇 마리 들어왔는지 조회하는 SQL 문을 작성해주세요.
  - SELECT count(*) as "count" from ANIMAL_INS
- 동물 보호소에 들어온 동물의 이름은 몇 개인지 조회하는 SQL 문을 작성해주세요. 이때 이름이 NULL인 경우는 집계하지 않으며 중복되는 이름은 하나로 칩니다.
  - SELECT count(distinct NAME) AS "count" from ANIMAL_INS where name is not null 
- 동물 보호소에 들어온 동물 중 고양이와 개가 각각 몇 마리인지 조회하는 SQL문을 작성해주세요. 이때 고양이가 개보다 먼저 조회해주세요.
  - SELECT ANIMAL_TYPE , count(*) as "count " from ANIMAL_INS GROUP BY ANIMAL_TYPE order by ANIMAL_TYPE asc