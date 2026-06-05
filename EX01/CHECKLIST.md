# EX01 체크리스트

## 제출 전 자가 점검

### 코드 (동작 확인)
- [ ] `db/schema.sql` 을 MySQL testdb 에 실행했다 (테이블 + 시드 3건)
- [ ] `MemberDAO.insert()` 를 raw JDBC 로 채웠다
- [ ] `MemberDAO.selectAll()` 를 raw JDBC 로 채웠다
- [ ] `MemberController.memberAddPost()` 본문(검증 → insert → redirect)을 채웠다
- [ ] `gradlew bootRun` 으로 기동된다 (포트 8090)
- [ ] `/member/add` 에서 빈 값 제출 시 필드별 에러 메시지가 보인다
- [ ] 정상 등록 후 `/member/list` 로 리다이렉트되고 목록에 보인다

### 산출물 (포트폴리오)
- [ ] `docs/산출물_양식/공통모듈_관리대장.md` — 공통 모듈 4개 이상, `BMEM-COM-NNN` 부여
- [ ] 관리대장에 명세 5원칙 자가 점검 포함
- [ ] `docs/산출물_양식/응집도결합도_분석표.md` — 각 구성요소의 응집도·결합도 + 계층 분리 효과

### 서술형 (파트 B)
- [ ] 공통 모듈 후보를 실제 구현된 컴포넌트 기준으로 식별했다
- [ ] Controller → DAO 직접 호출 구조의 응집도·결합도를 설명했다
- [ ] 명세 5원칙(정확성·명확성·완전성·일관성·추적성)을 적용했다

---

## NCS 능력단위요소 매핑

| NCS 요소 | 내용 | 이 과제에서 |
|:--|:--|:--|
| 1.1 | 공통 모듈을 식별할 수 있다 | DataSourceConfig / GlobalExceptionHandler / DTO·DAO 패턴 / Validation 을 공통 후보로 도출 |
| 1.2 | 공통 모듈을 명세할 수 있다 | 공통모듈 관리대장 (인덱스·입출력·명세 5원칙) |
| 1.3 | 공통 모듈을 설계할 수 있다 | MVC 계층(Controller / DAO / DTO) 책임 분리, 응집도·결합도 진단 |
| 1.4 | 설계 결과를 검토할 수 있다 | 채점기준 체크리스트·자가 점검으로 검토 |
