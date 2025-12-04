# 이산수학 프로젝트 - 그래프 알고리즘 구현

## 프로젝트 개요
본 프로젝트는 그래프 탐색 알고리즘(DFS, BFS)과 최단 경로 알고리즘(Dijkstra)을 Java로 구현합니다.

## 프로젝트 구조
```
DisceteMath_Prj/
├── src/
│   └── graph/
│       ├── Main.java              # 메인 실행 파일
│       ├── Graph.java              # 그래프 클래스 (인접 행렬)
│       ├── GraphTraversal.java     # DFS/BFS 구현
│       ├── Dijkstra.java           # Dijkstra 알고리즘 구현
│       └── GraphFileReader.java    # 파일 입출력
├── graph-program.jar                # 실행 가능한 JAR 파일 (7.2KB)
├── input1.txt                       # 무가중치 그래프 입력 (DFS/BFS용)
├── input2.txt                       # 가중치 그래프 입력 (Dijkstra용)
└── README.md
```

## 역할 분담

### Person 1: 그래프 표현 및 탐색
- **Graph.java**
  - 인접 행렬을 이용한 그래프 표현
  - `addEdge()` 메서드 구현 (무가중치/가중치)
  - `hasEdge()`, `getWeight()` 메서드 구현

- **GraphTraversal.java**
  - DFS (깊이 우선 탐색) 구현
  - BFS (너비 우선 탐색) 구현
  - 시작 정점: 1번 고정
  - 인접 정점 방문 순서: 오름차순

### Person 2: 파일 입출력 및 최단 경로
- **GraphFileReader.java**
  - `readUnweightedGraphs()`: input1.txt 읽기
  - `readWeightedGraphs()`: input2.txt 읽기
  - EOF까지 여러 그래프 파싱

- **Dijkstra.java**
  - Dijkstra 알고리즘 구현
  - 최단 경로 복원 (parent 배열 이용)
  - 시작 정점: 1번 고정

### 공통: Main.java
- 전체 실행 흐름 조율
- 두 사람이 각자 구현한 부분을 통합
- 출력 포맷 맞추기

## 구현 가이드

### 1. 시작하기

#### 방법 1: JAR 파일 실행 (권장)
```bash
# JAR 파일과 input 파일들을 같은 디렉터리에 배치
프로젝트폴더/
├── graph-program.jar
├── input1.txt
└── input2.txt

# 실행
java -jar graph-program.jar
```

#### 방법 2: 소스 코드 컴파일 및 실행
```bash
# 프로젝트 디렉터리로 이동
cd /Users/david/Workspace/DisceteMath_Prj

# 컴파일
javac -d . src/graph/*.java

# 실행 (input1.txt, input2.txt가 현재 디렉터리에 있어야 함)
java graph.Main
```

#### 방법 3: JAR 파일 직접 생성
```bash
# 컴파일 먼저 수행 (방법 2 참고)
javac -d . src/graph/*.java

# JAR 생성 (graph-program.jar)
jar cvfe graph-program.jar graph.Main graph/*.class

# 실행
java -jar graph-program.jar
```

### 2. 구현 순서

#### Person 1
1. **Graph.java**의 TODO 구현
   - `addEdge()` 메서드 (무가중치)
   - `addEdge()` 메서드 (가중치)
   - `hasEdge()` 메서드
   
2. **GraphTraversal.java**의 TODO 구현
   - `dfsRecursive()` 메서드
   - `bfs()` 메서드

#### Person 2
1. **GraphFileReader.java**의 TODO 구현
   - `readUnweightedGraphs()` 메서드
   - `readWeightedGraphs()` 메서드
   
2. **Dijkstra.java**의 TODO 구현
   - `dijkstra()` 메서드
   - `Result.getPath()` 메서드

### 3. 테스트
각자 구현한 부분을 완성한 후:
1. 컴파일하여 에러 확인
2. Main.java 실행하여 출력 확인
3. 출력 형식이 요구사항과 일치하는지 검증

### 4. 주의사항
- **인접 행렬 사용 필수** (인접 리스트 사용 금지)
- **정점 번호는 1부터 시작** (배열은 1-indexed로 사용)
- **인접 정점 방문 순서는 오름차순** (1, 2, 3, ...)
- **Dijkstra 갱신 조건**: `새로운_거리 < 기존_거리` (같을 때는 갱신 X)
- **출력 형식**: 정점 구분자는 ` – ` (공백-하이픈-공백)

## 입력 파일 형식

### input1.txt (무가중치 그래프)
```
8                    # 정점 개수
1 2 3                # 정점 1의 인접 정점: 2, 3
2 1 4 5              # 정점 2의 인접 정점: 1, 4, 5
...
```

### input2.txt (가중치 그래프)
```
5                              # 정점 개수
1 2 7 3 4 4 6 5 1             # 정점 1 → 2(가중치7), 3(가중치4), 4(가중치6), 5(가중치1)
2                              # 정점 2는 나가는 간선 없음
3 2 2 4 5                      # 정점 3 → 2(가중치2), 4(가중치5)
...
```

## 출력 형식

### DFS/BFS 출력
```
1. 그래프 탐방 수행 결과

그래프 [1]
----------------------------
깊이 우선 탐색
1 – 2 – 4 – 8 – 5 – 6 – 3 – 7 
너비 우선 탐색
1 – 2 – 3 – 4 – 5 – 6 – 7 – 8 
============================
```

### Dijkstra 출력
```
2. 최단 경로 구하기 수행 결과

그래프 [1]
----------------------------
시작점: 1
정점 [2]: 1 – 5 – 4 – 2, 길이: 5
정점 [3]: 1 – 3, 길이: 4
...
=========================
```

## 문제 해결

### 컴파일 오류
- 패키지 구조 확인: `package graph;`
- 클래스 이름과 파일 이름 일치 확인

### 실행 오류
- **파일 위치 확인**: input1.txt, input2.txt가 JAR 파일이나 실행 디렉터리와 같은 위치에 있어야 함
- **파일 형식 확인**: 정점 개수와 실제 정점 정보가 일치해야 함
- **JAR 실행 시**: `java -jar graph-program.jar` 명령어 사용

### 출력 형식 불일치
- 정점 구분자: ` – ` (공백 포함)
- 줄바꿈 확인
- 헤더 텍스트 정확히 일치

## 협업 팁
1. **Git 브랜치 사용**
   - Person 1: `feature/graph-traversal`
   - Person 2: `feature/dijkstra-io`
   
2. **자주 커밋하고 푸시**
   - 작은 단위로 커밋
   - TODO 하나 완료할 때마다 커밋 권장

3. **Main.java는 마지막에 통합**
   - 각자 구현 완료 후 함께 테스트
   - 출력 형식 최종 검증

## 참고 자료
- 요구사항 명세서: `요구사항_명세서.md`
- 프로젝트 과제: `(2025)프로젝트 과제.pdf`
