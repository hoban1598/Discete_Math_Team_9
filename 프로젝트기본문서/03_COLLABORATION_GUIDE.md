# 협업 가이드 (2인 작업)

## 👥 역할 분담

### 👤 Person 1: 그래프 기본 구조 + 탐색 알고리즘
**담당 파일:**
- `src/graph/Graph.java`
- `src/graph/GraphTraversal.java`

**구현 내용:**
1. **Graph.java** - 그래프 인접 행렬 구현
   - [ ] `addEdge(int from, int to)` - 무가중치 간선 추가
   - [ ] `addEdge(int from, int to, int weight)` - 가중치 간선 추가
   - [ ] `hasEdge(int from, int to)` - 간선 존재 여부 확인
   
2. **GraphTraversal.java** - DFS/BFS 구현
   - [ ] `dfsRecursive()` - 재귀 DFS 구현
   - [ ] `bfs()` - 큐를 이용한 BFS 구현

**예상 작업 시간:** 2-3시간

---

### 👤 Person 2: 파일 입출력 + 최단 경로
**담당 파일:**
- `src/graph/GraphFileReader.java`
- `src/graph/Dijkstra.java`

**구현 내용:**
1. **GraphFileReader.java** - 파일 파싱
   - [ ] `readUnweightedGraphs()` - input1.txt 읽기
   - [ ] `readWeightedGraphs()` - input2.txt 읽기
   
2. **Dijkstra.java** - 최단 경로 알고리즘
   - [ ] `dijkstra()` - Dijkstra 알고리즘 구현
   - [ ] `Result.getPath()` - 경로 복원 구현

**예상 작업 시간:** 2-3시간

---

## 📋 작업 순서

### Step 1: 초기 설정 (함께)
```bash
# Git 저장소 초기화 (선택)
git init
git add .
git commit -m "Initial project structure"

# 브랜치 생성
git checkout -b feature/graph-traversal    # Person 1
git checkout -b feature/dijkstra-io        # Person 2
```

### Step 2: 개별 작업
각자 담당 파일의 TODO 주석을 찾아서 구현합니다.

**Person 1 작업 순서:**
1. `Graph.java` 구현 → 컴파일 테스트
2. `GraphTraversal.java` 구현 → 간단한 테스트 코드로 검증

**Person 2 작업 순서:**
1. `GraphFileReader.java` 구현 → 파일 읽기 테스트
2. `Dijkstra.java` 구현 → 경로 계산 테스트

### Step 3: 통합 테스트 (함께)
```bash
# 컴파일
cd /Users/david/Workspace/DisceteMath_Prj
javac src/graph/*.java

# 실행
java -cp src graph.Main
```

### Step 4: 출력 검증
출력 형식이 요구사항과 정확히 일치하는지 확인:
- 정점 구분자: ` – ` (공백 포함)
- 헤더 텍스트
- 줄바꿈 및 구분선

---

## 🔧 구현 팁

### Person 1을 위한 팁

#### Graph.java
```java
// 무가중치 간선 추가
public void addEdge(int from, int to) {
    adjMatrix[from][to] = 1;
}

// 가중치 간선 추가
public void addEdge(int from, int to, int weight) {
    adjMatrix[from][to] = weight;
}

// 간선 존재 여부
public boolean hasEdge(int from, int to) {
    if (isWeighted) {
        return adjMatrix[from][to] != INF;
    } else {
        return adjMatrix[from][to] == 1;
    }
}
```

#### GraphTraversal.java - DFS
```java
private static void dfsRecursive(Graph graph, int current, boolean[] visited, List<Integer> result) {
    visited[current] = true;
    result.add(current);
    
    // 인접 정점을 오름차순으로 방문
    for (int next = 1; next <= graph.getNumVertices(); next++) {
        if (!visited[next] && graph.hasEdge(current, next)) {
            dfsRecursive(graph, next, visited, result);
        }
    }
}
```

#### GraphTraversal.java - BFS
```java
public static List<Integer> bfs(Graph graph, int start) {
    List<Integer> result = new ArrayList<>();
    boolean[] visited = new boolean[graph.getNumVertices() + 1];
    Queue<Integer> queue = new LinkedList<>();
    
    queue.offer(start);
    visited[start] = true;
    
    while (!queue.isEmpty()) {
        int current = queue.poll();
        result.add(current);
        
        for (int next = 1; next <= graph.getNumVertices(); next++) {
            if (!visited[next] && graph.hasEdge(current, next)) {
                visited[next] = true;
                queue.offer(next);
            }
        }
    }
    
    return result;
}
```

---

### Person 2를 위한 팁

#### GraphFileReader.java - input1.txt 읽기
```java
public static List<Graph> readUnweightedGraphs(String filename) throws IOException {
    List<Graph> graphs = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;
    
    while ((line = br.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) continue;
        
        int n = Integer.parseInt(line);
        Graph graph = new Graph(n, false);
        
        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().trim().split("\\s+");
            int vertex = Integer.parseInt(tokens[0]);
            
            for (int j = 1; j < tokens.length; j++) {
                int adjacent = Integer.parseInt(tokens[j]);
                graph.addEdge(vertex, adjacent);
            }
        }
        
        graphs.add(graph);
    }
    
    br.close();
    return graphs;
}
```

#### GraphFileReader.java - input2.txt 읽기
```java
public static List<Graph> readWeightedGraphs(String filename) throws IOException {
    List<Graph> graphs = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;
    
    while ((line = br.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) continue;
        
        int n = Integer.parseInt(line);
        Graph graph = new Graph(n, true);
        
        int vertexCount = 0;
        while (vertexCount < n && (line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) break;
            
            String[] tokens = line.split("\\s+");
            int vertex = Integer.parseInt(tokens[0]);
            vertexCount++;
            
            // 인접정점-가중치 쌍으로 처리
            for (int j = 1; j < tokens.length; j += 2) {
                int adjacent = Integer.parseInt(tokens[j]);
                int weight = Integer.parseInt(tokens[j + 1]);
                graph.addEdge(vertex, adjacent, weight);
            }
        }
        
        graphs.add(graph);
    }
    
    br.close();
    return graphs;
}
```

#### Dijkstra.java - 알고리즘 구현
```java
public static Result dijkstra(Graph graph, int start) {
    int n = graph.getNumVertices();
    Result result = new Result(n);
    boolean[] visited = new boolean[n + 1];
    
    result.distance[start] = 0;
    
    for (int i = 0; i < n; i++) {
        // 최소 거리 정점 찾기
        int minDist = Graph.INF;
        int u = -1;
        for (int v = 1; v <= n; v++) {
            if (!visited[v] && result.distance[v] < minDist) {
                minDist = result.distance[v];
                u = v;
            }
        }
        
        if (u == -1) break;
        visited[u] = true;
        
        // 인접 정점 거리 갱신
        for (int v = 1; v <= n; v++) {
            if (!visited[v] && graph.getWeight(u, v) != Graph.INF) {
                int newDist = result.distance[u] + graph.getWeight(u, v);
                if (newDist < result.distance[v]) {  // < 사용 (같을 때 갱신 X)
                    result.distance[v] = newDist;
                    result.parent[v] = u;
                }
            }
        }
    }
    
    return result;
}
```

#### Dijkstra.java - 경로 복원
```java
public List<Integer> getPath(int dest) {
    List<Integer> path = new ArrayList<>();
    
    if (distance[dest] == Graph.INF) {
        return path;  // 도달 불가능
    }
    
    for (int v = dest; v != -1; v = parent[v]) {
        path.add(v);
    }
    
    Collections.reverse(path);
    return path;
}
```

---

## ✅ 체크리스트

### Person 1 완료 체크
- [ ] Graph.java 컴파일 성공
- [ ] GraphTraversal.java 컴파일 성공
- [ ] DFS 결과가 올바른 순서로 출력
- [ ] BFS 결과가 올바른 순서로 출력

### Person 2 완료 체크
- [ ] GraphFileReader.java 컴파일 성공
- [ ] input1.txt 파싱 성공
- [ ] input2.txt 파싱 성공
- [ ] Dijkstra.java 컴파일 성공
- [ ] 최단 경로 계산 정확
- [ ] 경로 복원 정확

### 통합 테스트 체크
- [ ] 전체 컴파일 성공
- [ ] DFS/BFS 출력 형식 일치
- [ ] Dijkstra 출력 형식 일치
- [ ] 여러 그래프 처리 정상
- [ ] 에러 처리 정상

---

## 🚨 주의사항

1. **인접 행렬 1-indexed 사용**
   - 배열 크기: `[n+1][n+1]`
   - 정점 번호: 1 ~ n

2. **방문 순서는 오름차순**
   - for문: `for (int i = 1; i <= n; i++)`

3. **Dijkstra 갱신 조건**
   - `newDist < oldDist` (< 사용)
   - `newDist <= oldDist` (X)

4. **출력 형식**
   - 정점 구분자: ` – ` (공백-하이픈-공백)
   - 마지막 정점 뒤에도 공백 1개

5. **파일 읽기**
   - 빈 줄 무시
   - EOF까지 모든 그래프 읽기

---

## 💬 소통 방법
- 막히는 부분이 있으면 서로 물어보기
- 구현 완료 시 상대방에게 알리기
- Main.java는 마지막에 함께 테스트

**좋은 협업되세요! 🎉**

