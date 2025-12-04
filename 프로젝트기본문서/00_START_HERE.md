# 🎯 여기서 시작하세요!

## 환영합니다! 👋

이산수학 프로젝트의 **완전한 스켈레톤 코드**가 준비되었습니다!  
2명이 협업하기 쉽고, 복잡도가 낮은 구조로 설계되었습니다.

---

## 📦 생성된 내용

### ✅ Java 소스 코드 (5개)
```
src/graph/
├── Main.java              ✅ 완성 (실행 진입점)
├── Graph.java             ⚠️ TODO 4개 (Person 1)
├── GraphTraversal.java    ⚠️ TODO 2개 (Person 1)
├── GraphFileReader.java   ⚠️ TODO 2개 (Person 2)
└── Dijkstra.java          ⚠️ TODO 2개 (Person 2)
```

### ✅ 테스트 입력 파일 (2개)
- `input1.txt` - 무가중치 그래프 (DFS/BFS용)
- `input2.txt` - 가중치 그래프 (Dijkstra용)

### ✅ 문서 (7개)
모든 문서가 한글로 작성되어 있습니다!

---

## 🚀 3단계로 시작하기

### 1️⃣ 역할 확인 (1분)

#### 👤 Person 1: 그래프 + 탐색
- [ ] `Graph.java` - 그래프 인접 행렬 구현
- [ ] `GraphTraversal.java` - DFS/BFS 구현
- ⏱️ 예상 시간: 2-3시간

#### 👤 Person 2: 파일 I/O + 최단 경로
- [ ] `GraphFileReader.java` - 파일 입출력
- [ ] `Dijkstra.java` - 최단 경로 알고리즘
- ⏱️ 예상 시간: 2-3시간

---

### 2️⃣ 문서 읽기 (15분)

**필수 문서 (꼭 읽으세요!)**

1. **QUICKSTART.md** ⭐⭐⭐ (5분)
   - 지금 바로 시작하는 방법
   - 컴파일 & 실행 명령어
   - 디버깅 가이드

2. **COLLABORATION_GUIDE.md** ⭐⭐⭐ (10분)
   - **구체적인 구현 코드 예시**
   - Person 1, Person 2 구현 팁
   - 체크리스트

3. **README.md** ⭐⭐ (5분)
   - 프로젝트 전체 개요
   - 입출력 형식
   - 요구사항 요약

**선택 문서 (필요시 참고)**

4. **ARCHITECTURE.md** (5분)
   - 클래스 다이어그램
   - 실행 흐름 시퀀스
   - 복잡도 분석

5. **PROJECT_SUMMARY.md** (3분)
   - 프로젝트 요약
   - 체크리스트
   - FAQ

6. **요구사항_명세서.md** (10분)
   - 상세 요구사항 전체

---

### 3️⃣ 구현 시작 (2-3시간)

```bash
# 1. 프로젝트 디렉터리로 이동
cd /Users/david/Workspace/DisceteMath_Prj

# 2. 담당 파일 열기
# Person 1
vi src/graph/Graph.java
vi src/graph/GraphTraversal.java

# Person 2
vi src/graph/GraphFileReader.java
vi src/graph/Dijkstra.java

# 3. TODO 주석 찾아서 구현
# (COLLABORATION_GUIDE.md에 구현 예시 있음!)

# 4. 컴파일
javac src/graph/*.java

# 5. 실행
java -cp src graph.Main
```

---

## 📚 문서 네비게이션

### 빠른 참조

| 목적 | 문서 | 소요 시간 |
|------|------|-----------|
| 지금 바로 시작 | **QUICKSTART.md** | 5분 |
| 구현 코드 예시 | **COLLABORATION_GUIDE.md** | 10분 |
| 프로젝트 이해 | README.md | 5분 |
| 구조 이해 | ARCHITECTURE.md | 5분 |
| 빠른 체크 | PROJECT_SUMMARY.md | 3분 |
| 상세 요구사항 | 요구사항_명세서.md | 10분 |
| 시작 가이드 | **이 파일** | 3분 |

---

## 🎯 추천 읽기 순서

### 처음 시작하는 경우
```
1. 00_START_HERE.md (이 파일) ← 지금 여기
2. QUICKSTART.md
3. COLLABORATION_GUIDE.md
4. 구현 시작!
```

### 구조를 먼저 이해하고 싶은 경우
```
1. 00_START_HERE.md (이 파일)
2. README.md
3. ARCHITECTURE.md
4. COLLABORATION_GUIDE.md
5. 구현 시작!
```

### 바로 구현하고 싶은 경우
```
1. COLLABORATION_GUIDE.md (구현 예시 보기)
2. 구현 시작!
3. 막히면 QUICKSTART.md 참고
```

---

## 💡 핵심 포인트

### ✨ 이 프로젝트의 특징

1. **낮은 복잡도**
   - 인접 행렬 사용 (구현 단순)
   - 명확한 모듈 분리
   - 상세한 주석과 힌트

2. **협업 최적화**
   - Person 1과 Person 2 작업 독립적
   - 충돌 없는 파일 분담
   - 명확한 인터페이스

3. **충실한 스켈레톤**
   - 모든 클래스 구조 완성
   - 메서드 시그니처 준비
   - TODO 주석에 구현 가이드

---

## ⚠️ 주의사항

### 반드시 지켜야 할 것

1. **인접 행렬 사용** (인접 리스트 X)
2. **정점 번호 1부터 시작** (1-indexed)
3. **방문 순서 오름차순** (1, 2, 3, ...)
4. **Dijkstra 갱신**: `<` 사용 (같을 때 X)
5. **출력 구분자**: ` – ` (공백 포함)

---

## 🎓 구현 난이도

### Person 1
- **Graph.java**: ⭐⭐ (쉬움)
- **GraphTraversal.java**: ⭐⭐⭐ (보통)

### Person 2
- **GraphFileReader.java**: ⭐⭐⭐ (보통)
- **Dijkstra.java**: ⭐⭐⭐ (보통)

**전체 난이도: 보통**  
이산수학 수업 내용을 복습하면 충분히 구현 가능합니다!

---

## ✅ 성공 확인

### 구현 완료 시
```bash
# 컴파일
javac src/graph/*.java

# 실행
java -cp src graph.Main

# 출력 확인
# ✅ "1. 그래프 탐방 수행 결과" 보임
# ✅ "2. 최단 경로 구하기 수행 결과" 보임
# ✅ DFS/BFS 순서가 올바름
# ✅ 최단 경로가 정확함
```

---

## 🆘 도움이 필요한 경우

### 막힐 때 확인할 순서

1. **TODO 주석 읽기**
   - 각 메서드에 힌트가 있습니다

2. **COLLABORATION_GUIDE.md**
   - 구체적인 구현 코드 예시

3. **QUICKSTART.md 디버깅 섹션**
   - 자주 발생하는 오류 해결

4. **파트너와 상의**
   - 2인 1팀으로 함께 해결!

---

## 📊 프로젝트 현황

```
진행률: [████░░░░░░] 40%

✅ 완료:
- 프로젝트 구조 생성
- 스켈레톤 코드 작성
- 문서 작성
- 테스트 입력 준비

⏳ 남은 작업:
- Person 1: Graph + GraphTraversal 구현
- Person 2: GraphFileReader + Dijkstra 구현
- 통합 테스트
```

---

## 🎉 시작 준비 완료!

모든 준비가 끝났습니다!  
이제 **QUICKSTART.md** 또는 **COLLABORATION_GUIDE.md**를 열고  
구현을 시작하세요!

```bash
# 지금 바로 시작
cd /Users/david/Workspace/DisceteMath_Prj
cat QUICKSTART.md  # 또는 에디터로 열기
```

---

## 📞 Quick Commands

```bash
# 프로젝트로 이동
cd /Users/david/Workspace/DisceteMath_Prj

# 파일 목록 보기
ls -R src/

# 컴파일
javac src/graph/*.java

# 실행
java -cp src graph.Main

# TODO 찾기
grep -r "TODO" src/

# 문서 열기
cat QUICKSTART.md
cat COLLABORATION_GUIDE.md
```

---

**성공적인 프로젝트 되시길 바랍니다! 화이팅! 💪🎓**

---

<div align="center">

## 다음 단계

### 👇 지금 바로 여기로 가세요 👇

**→ [QUICKSTART.md](./QUICKSTART.md) ←**

또는

**→ [COLLABORATION_GUIDE.md](./COLLABORATION_GUIDE.md) ←**

</div>

