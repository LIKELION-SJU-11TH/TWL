# Database
정보를 저장, 관리, 검색하기 위한 구조화된 데이터의 집합

### DB
* 엑셀과 DB의 유사점
    * 엑셀과 데이터 베이스는 모두 데이터를 저장하고 관리하는데 사용되는 소프트웨어다.
        1. 데이터 저장 및 관리
        2. 데이터 필터링 및 검색
        3. 데이터 정렬 및 요약
        4. 데이터 분석
        5. 데이터 시각화
        6. 보고서 작성
        7. 데이터 공유
* 엑셀이 있는데도 DB를 사용하는 이유
    * 엑셀은 주로 작은 규모의 데이터를 다루는 데 사용되고, 데이터베이스는 대량의 데이터를 다루는데 사용된다.
    * 데이터베이스는 더욱 복잡하고 안정적인 데이터 관리 시스템이며, 데이터 검색 및 분석에 대한 성능이 엑셀보다 뛰어나다.
    * 데이터베이스는 여러 사용자가 동시에 접근할 수 있으므로, 데이터 공유 및 협업에 효과적이다.

<br>

### DBMS(Database Management System)
DBMS는 데이터를 효육적으로 저장, 검색, 조작 및 관리하는데 사용되는 소프트웨어이다.
* DBMS의 장점

    1. **데이터 중복 최소화** : DBMS는 중복 데이터를 효과적으로 제거하여 데이터 일관성을 유지합니다.

    2. **데이터 무결성 보장** : DBMS는 데이터의 무결성을 보장하며, 데이터베이스에서 특정 규칙과 제약 조건을 지정하여 데이터의 일관성을 유지할 수 있습니다.

    3. **데이터 보안 강화** : DBMS는 데이터에 대한 접근 권한을 관리하고, 데이터를 안전하게 보호할 수 있도록 여러 가지 보안 기능을 제공합니다.

    4. **데이터 공유 용이성** : DBMS는 여러 사용자가 동시에 데이터베이스를 공유하고 수정할 수 있도록 합니다.

    5. **빠른 데이터 검색 및 처리** : DBMS는 데이터베이스 내에서 빠른 검색과 처리를 위해 인덱싱, 쿼리 최적화 등의 기능을 제공합니다.

* DBMS의 단점

    1. **비용** : DBMS는 구축 및 운영에 대한 비용이 많이 들며, 큰 규모의 시스템을 구축하는 데는 더 많은 비용이 필요합니다.

    2. **복잡성** : DBMS는 복잡한 구조를 가지고 있어, 설계 및 구축이 어렵습니다.

    3. **성능 이슈** : DBMS는 데이터 처리를 위해 많은 자원을 사용하므로, 대규모 데이터베이스의 경우 성능 이슈가 발생할 수 있습니다.

    4. **데이터 무결성 제한** : DBMS는 데이터 무결성을 보장하기 위해 제약 조건을 사용하지만, 이러한 제약 조건이 너무 제한적이거나 복잡한 경우 데이터 입력이 제한될 수 있습니다.

    5. **응용프로그램 종속성** : DBMS는 응용프로그램과 밀접한 연관성이 있어, 응용프로그램이 DBMS에 종속되는 경우가 많습니다. 이 경우, DBMS를 변경하면 응용프로그램도 변경해야 할 수 있습니다.

<br>

### RDB(Relational Database)
```
테이블(Table)을 이용하여 데이터를 구성하는 데이터베이스이다.
관계형 데이터베이스에서는 데이터를 테이블(Table)의 형태로 관리하며, 이 테이블은 행(Row)과 열(Column)로 이루어져 있다.

테이블 간에는 키를 이용하여 관계가 설정된다. 키는 각 테이블 내에서 유일한 값으로, 다른 테이블에서 참조할 수 있도록 해주는 역할을 한다.

관계형 데이터베이스에서는 SQL을 사용하여 데이터를 검색, 추가, 수정 및 삭제할 수 있다.
```

<br>

### RDBMS(Relational Database Management System)
관계형 데이터베이스를 관리하는 시스템으로, 데이터를 저장하고 유지보수하기 위한 기능을 제공한다.
이는 SQL을 이용하여 데이터를 조작하고 관리한다.
* RDBMS의 기능
    1. 데이터의 저장 및 관리: RDBMS는 데이터를 저장하고, 관리합니다. 이를 위해 다양한 기능들을 제공합니다. 예를 들어, 데이터의 삽입, 삭제, 수정, 검색, 정렬 등이 있습니다.

    2. 데이터의 무결성 유지: RDBMS는 데이터의 무결성을 유지하기 위해 여러 제약 조건을 설정할 수 있습니다. 예를 들어, 데이터의 중복을 방지하기 위해 유일한 값을 가지는 Primary Key를 설정할 수 있고, 참조 무결성을 유지하기 위해 Foreign Key를 사용할 수 있습니다.
        > Primary Key 란?<br>데이블의 레코드를 유일하게 식별할 수 있는 column.<br>중복 데이터 방지 및 데이터 일관성 유지<br>다른 데이블에서 참조 시 Foreign Key로 사용<br><br>Foreign Key 란?<br>다른 데이블에서 Primary Key를 참조하는 column.<br>이를 사용시 두 개 이상의 테이블을 연결하여 데이터 관리 가능.<br>데이터 일관성 및 데이터의 더욱 효율적인 관리 가능
    3. 동시성 제어: RDBMS는 여러 사용자가 동시에 데이터베이스에 접근할 수 있도록 합니다. 이를 위해 다양한 동시성 제어 기능을 제공합니다. 예를 들어, 트랜잭션(Transaction)과 락(Lock) 등이 있습니다.
        > Transaction 이란?<br>데이터베이스에서 여러 작업을 하나의 논리적인 작업 단위로 묶는 것을 말한다.<br>이는 ACID(Atomicity, Consistency, Isolation, Durability) 속성을 보장한다<br><br>ACID란?<br>Atomicity : 모든 작업이 성공하거나 실패하면 전체 작업이 롤백되는 것<br>Consitency : 모든 작업이 수행되면 데이터의 일관성이 유지되는 것<br>Isolation : 동시에 여러 작업이 수행될 때 각 작업이 서로 영향을 주지 않는 것<br>Durability : 작업이 성공하면 영구적으로 반영되는 것<br><br>Lock 이란?<br>데이터베이스에서 동시에 여러 사용자가 데이터에 접근할 때 충돌을 방지하기 위 메커니즘이다.<br>Lock은 Exclusive Lock과 Shared Lock으로 나뉜다.<br>Exclusive Lock : 특정 데이터에 대해 다른 사용자의 접근을 차단하는 것<br>Shared Lock : 여러 사용자가 같은 데이터에 접근할 수는 있지만, 동시에 수정할 수는 없도록 하는 것
    4. 보안: RDBMS는 데이터베이스의 보안을 유지하기 위해 다양한 보안 기능을 제공합니다. 예를 들어, 사용자 권한 설정, 암호화 등이 있습니다.

    5. 성능 최적화: RDBMS는 성능 최적화를 위한 다양한 기능들을 제공합니다. 예를 들어, 인덱스(Index)를 사용하여 데이터를 빠르게 검색할 수 있고, 쿼리 튜닝(Query Tuning)을 통해 쿼리의 실행 계획을 최적화할 수 있습니다.
        > 쿼리 튜닝이란?<br>데이터베이스의 성능을 최적화하는 작업이다. 이때 쿼리의 실행 계획을 분석하여 최적화할 수 있는 부분을 찾아야 한다.<br>인덱스를 활용하는 등 쿼리 튜닝을 하게 되면 데이터베이스의 성능을 향상시키고, 사용자의 응답 시간을 줄일 수 있다.

<br>

### Database 용어
* Database란?<br>
    데이터베이스는 데이터를 구성하는 정보를 체계적으로 관리하기 위한 체계적인 데이터 집합입니다.
* Table란?<br>
    데이터베이스에서 정보를 담고 있는 단위입니다. 테이블은 행(row)과 열(column)로 구성되며, 행은 레코드(record)라고도 불립니다.
* Column란?<br>
    테이블에서 정보를 저장하는 단위 중 하나로, 필드(field) 또는 속성(attribute)이라고도 불립니다.
* Row란?<br>
    테이블에서 레코드(record) 또는 튜플(tuple)이라고도 불리는 데이터의 단위입니다.
* Primary key란?<br>
    테이블에서 유일하게 식별할 수 있는 열(칼럼)입니다. Primary key는 다른 테이블에서 참조할 때 Foreign key로 사용됩니다.
* Foreign key란?<br>
    다른 테이블의 Primary key를 참조하는 열입니다. Foreign key를 사용하면 두 개 이상의 테이블을 연결하여 데이터를 관리할 수 있습니다.
* Index란?<br>
    테이블에서 데이터의 검색 속도를 향상시키기 위해 생성되는 데이터 구조입니다. Index는 특정 열(칼럼)의 값을 정렬하고, 키(Key)와 함께 저장됩니다.
* View란?<br>
    테이블과 유사하게 데이터를 저장하는 것이 아니라, 하나 이상의 테이블에서 추출된 데이터를 보여주는 가상의 테이블입니다.
* Trigger란?<br>
    데이터베이스에서 발생하는 이벤트에 대한 반응으로 자동으로 실행되는 일련의 작업입니다. Trigger는 데이터의 일관성을 유지하고, 보안을 강화하며, 데이터의 흐름을 제어할 수 있습니다.
* Stored procedure란?<br>
    데이터베이스에서 실행할 수 있는 일련의 쿼리들을 묶어서 하나의 프로그램처럼 실행할 수 있는 저장 프로시저입니다. 저장 프로시저는 쿼리를 중복해서 작성하는 것을 피하고, 보안을 강화하며, 성능을 향상시킬 수 있습니다.

### 유일성과 최소성
* 유일성(Uniqueness)
    ```
    유일성은 테이블에서 특정 열(column)에 중복되는 값이 없는 것을 의미합니다. 
    이를 위해 Primary key(기본키)라는 개념이 사용됩니다. 
    Primary key는 해당 테이블에서 유일하게 식별할 수 있는 열(column)로, 테이블 내에서 중복된 값을 가질 수 없습니다. 
    이를 통해 데이터의 일관성과 정확성을 유지할 수 있으며, 다른 테이블에서 Foreign key(외래키)로 사용될 수 있습니다.
    ```
* 최소성(Minimality)
    ```
    최소성은 테이블에서 필요한 최소한의 열(column)만을 가지도록 하는 것을 의미합니다. 
    이를 위해 Normalization(정규화)라는 개념이 사용됩니다. 
    정규화는 데이터베이스 설계 시 데이터 중복성과 종속성을 제거하여 데이터의 일관성과 무결성을 보장하고, 데이터베이스의 성능을 향상시키기 위한 과정입니다. 
    일반적으로 1NF(1차 정규화), 2NF(2차 정규화), 3NF(3차 정규화) 등의 단계로 진행됩니다.
    ```

<br>

### DB간의 관계
데이터베이스에서는 여러 테이블이 서로 연결되어 있을 수 있다. 이러한 테이블 간의 관계를 정의해 두면, 데이터의 일관성과 무결성을 보장할 수 있고, 데이터를 더욱 효율적으로 처리할 수 있다.

* 데이터베이스의 주요 관계
    * One to One(1:1)
        > 하나의 테이블의 레코드가 다른 하나의 테이블의 레코드와 1:1로 대응되는 경우.
        <br>
        이 관계는 두 테이블 중 어느 한 쪽에서도 Primary Key로 설정이 가능하다.
    * One to Many(1:N)
        > 하나의 테이블의 레코드가 다른 하나의 테이블의 레코드와 1:N으로 대응되는 경우.
        <br>
        이 관계에서는 "하나"의 쪽에서 Primary key, "다수"의 쪽에서 Foreign key로 설정
    * Many to Many(N:M)
        > 하나의 테이블의 레코드가 다른 하나의 테이블의 레코드와 N:M으로 대응되는 경우.
        <br>
        이 관계에서는 중간에 연결 테이블을 두고 두 개의 테이블과의 One to Many 관계로 표현
    * Self Referencing 관계
        > 하나의 테이블 내에서 자기 자신과 관계를 가지는 경우.
        <br>
        이 경우, 테이블 내에서 자신의 Primary key를 Foreign key로 참조하는 형태로 표현

<br>

### 데이터 구조 설계 방법론
* 정규화(Normalization)
    ```
    데이터 구조를 중복을 최소화하고 의존성을 관리하기 쉬운 형태로 변경하는 과정
    이를 통해 데이터를 보다 효율적으로 저장하고 검색 가능
    정규화를 수행하는 과정에서는 테이블을 여러 개의 작은 테이블로 분리하여 이상(Anomaly)를 제거
    ```
    > Anomaly 란?
    <br>
    데이터베이스에서 데이터 구조를 설계할 때 발생할 수 있는 문제.
    <br>
    이상은 테이블의 데이터 중복과 관련이 있으며, 데이터를 삭제, 삽입, 수정할 때 예상치 못한 결과가 발생할 수 있다.
    <br>
    이상이 발생하면 데이터 일관성을 유지하는 것이 어려워지며, 데이터베이스의 신뢰성과 안정성이 떨어진다.
    

* 반정규화(Denormalization)
    ```
    데이터의 중복을 중가시켜 데이터를 빠르게 검색할 수 있도록 하는 과정
    데이터를 조회하는 경우, 일반적으로 여러 개의 테이블을 조인하는 작업이 필요
    하지만 조인은 성능상의 문제 발생 가능성 존재
    이를 해결하기 위해 데이터의 중복을 허용하고, 데이터를 한 곳에 집중시켜 검색 성능을 향상
    ```
    > Join 이란?
    <br>
    조인은 데이터베이스에서 두 개 이상의 테이블에서 데이터를 가져와서 하나의 결과를 출력하는 기능.
    <br>
    이를 통해 여러 개의 테이블을 하나로 묶어서 데이터를 검색하고 분석할 수 있다.
    <br>
    일반적으로 조인은 Primary key와 Foreign key를 이용하여 두 개 이상의 테이블을 연결한다.
    <br>
    하지만, 조인은 여러 개의 테이블을 연결하는 작업이므로, 데이터 조회 성능에 영향을 미친다.
    <br>
    따라서 조인을 사용할 때는 테이블의 인덱스를 적절하게 설정하여 조회 성능을 향상시켜야 한다.
    <br>
    또한, 조인이 복잡해지면 쿼리의 가독성이 떨어지기 때문에, 조인을 사용할 때는 쿼리의 간결성을 유지하는 것이 중요하다.

### ERD(Entity-Relationship Diagram)
```
ERD는 개체-관계 모델을 시각적으로 표현한 다이어그램이다.
ERD는 데이터베이스에서 사용되는 개체와 개체들 간의 관계를 표현한다

개체는 데이터베이스에서 처리하는 대상을 의미한다.
예를 들어서 사용자, 상품, 주문과 같은 것들이 될 수 있다.
관계는 개체 간의 연결을 의미하며, 1:1, 1:N, N:M 등의 관계를 표현할 수 있다.

ERD는 데이터베이스의 구조와 관계를 시각적으로 표현하여 데이터 베이스를 보다 쉽게 이해할 수 있도록 도와준다.
ERD를 사용하면 데이터베이스 설계 단계에서 개체와 관계를 명확하게 파악하여 데이터 일관성과 안정성을 높일 수 있다.
또한, ERD는 데이터베이스를 수정하거나 관리할 때도 유용하게 사용된다.
```