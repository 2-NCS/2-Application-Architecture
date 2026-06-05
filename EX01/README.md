# EX01 — 공통 모듈 설계 (회원 관리 시스템 B-Member)

> 분류: 모듈시험 (개인 과제) / 예상 2시간 / 합격선 60점
> NCS 학습 1: 공통 모듈 설계하기 (1.1 ~ 1.4)
> 기술 스택: Spring Boot MVC (Thymeleaf 서버 렌더링) · DAO raw JDBC · DataSource(commons-dbcp2 / HikariCP) · @Valid 검증 · Lombok · MySQL testdb · 포트 8090

---

## 시나리오

회사 B 는 회원 관리 시스템 `B-Member` 를 Spring Boot MVC 로 만든다.
설계자로서 (1) 화면 요청을 받는 `Controller`, (2) DB 에 접근하는 `DAO`, (3) 화면에 넘기는 `DTO` 로
책임을 나누고, 공통으로 재사용되는 부분(DataSource 설정, 전역 예외 처리, 검증 규칙)을
공통 모듈로 식별한다.

이 과제는 학습 1 (공통 모듈 설계하기) 전용이다. 타 시스템 연동·미들웨어는 다루지 않는다.

---

## 이 문제는 "배운 범위"만으로 풀 수 있게 설계되었다

이 EX 는 강사 SAMPLE 의 **Memo 예제**(`07_DATASOURCE`)에서 다룬 범위만 사용한다.
새로 배워야 하는 기술은 없다. 구체적으로:

| 배운 것 | 이 과제에서 쓰는 곳 |
|:--|:--|
| MVC + DI (`@Controller`, `@Repository`, `@Autowired`) | Controller 가 DAO 를 직접 주입받아 호출 |
| DataSource (raw JDBC) | `MemberDAO.insert` / `selectAll` (Memo 와 동일 패턴) |
| `@Valid` + `BindingResult` | 회원가입 폼 검증 |
| 예외 처리 (`@ExceptionHandler`, `@ControllerAdvice`) | 컨트롤러/전역 예외 처리 |
| Thymeleaf (`th:text`, `th:each`) | 폼 에러 표시, 목록 테이블 |

> Memo 예제의 `MemoDAO`(insert+selectAll) 와 `MemoController` 를 그대로 회원으로 바꾸면 된다.
> 상세조회·수정·삭제·검색·페이징·로그인·해시·마스킹은 배운 범위가 아니므로 **넣지 않는다.**

---

## 회원 관리 기능 일람

| 기능 | 경로 | 입력 | 처리 |
|:--|:--|:--|:--|
| 회원등록 폼 | `GET /member/add` | - | 등록 화면 |
| 회원등록 | `POST /member/add` | name, email, phone | 형식 검증(@Valid) 후 저장 |
| 회원 목록 | `GET /member/list` | - | 전체 조회 |

---

## 폴더 구조

```
EX01/
├── README.md / CHECKLIST.md
├── build.gradle / settings.gradle        (제공)
├── db/schema.sql                          ← MySQL testdb 에 직접 실행 (제공)
├── docs/
│   ├── 설계과제.md                         ← 정독 필수 (파트 A·B·C)
│   ├── 채점기준_체크리스트.md
│   ├── 가이드.md
│   └── 산출물_양식/
│       ├── 공통모듈_관리대장.md             ← TODO (빈 표)
│       └── 응집도결합도_분석표.md            ← TODO (빈 표)
└── src/main/java/com/example/demo/
    ├── DemoApplication.java                (제공)
    ├── Config/DataSourceConfig.java        (제공)
    ├── Controller/HomeController.java      (제공)
    ├── Controller/MemberController.java    ← TODO (POST 본문)
    ├── Controller/GlobalException/GlobalExceptionHandler.java (제공)
    └── Domain/Common/
        ├── Dtos/MemberDTO.java             (제공)
        └── Daos/MemberDAO.java             ← TODO (insert / selectAll)
```

`src/main/resources/templates/` 의 `index.html`, `member/add.html`,
`member/list.html`, `member/error.html`, `global/error1~3.html` 은 모두 제공된다.

---

## 코드 과제 (TODO)

컴파일은 되지만 핵심 본문이 `throw new UnsupportedOperationException("TODO")` 로 비어 있다.

| 파일 | 채울 부분 |
|:--|:--|
| `Domain/Common/Daos/MemberDAO.java` | `insert()`, `selectAll()` — raw JDBC |
| `Controller/MemberController.java` | `memberAddPost()` 본문 — 검증·insert·redirect |

> 막히면 강사 SAMPLE 의 `MemoDAO` / `MemoController` 를 본다(같은 패턴).

---

## 실행법

1. MySQL `testdb` 에 `db/schema.sql` 을 실행한다(테이블 생성 + 시드 3건).
   - 접속 정보: `localhost:3306` / `root` / `1234` (DataSourceConfig 에 설정됨)
2. 프로젝트 루트에서 실행:

```
gradlew bootRun
```

3. 브라우저에서 `http://localhost:8090/` 접속.

확인 순서: `/` 메뉴 → 회원등록(`/member/add`) → 목록(`/member/list`).

---

## 문제 구성 (배점)

| 파트 | 내용 | 배점 | 채점 |
|:--|:--|--:|:--|
| A. 지식 확인 | 객관식·단답 | 20 | 정답 채점 |
| B. 서술형 | 공통 모듈 후보 식별 / 응집도·결합도 / 명세 5원칙 | 30 | 모범답안 대비 |
| C. 포트폴리오 산출물 | 공통모듈 관리대장(30) + 응집도결합도 분석표(20) | 50 | 상/중/하 루브릭 |
| | **합계** | **100** | 합격선 60 |

상세는 `docs/설계과제.md`, 채점은 `docs/채점기준_체크리스트.md` 참고.
막히면 `EX01_답/` 참고.
