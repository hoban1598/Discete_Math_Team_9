package graph;

import java.util.*;

/**
 * GraphTraversal 클래스 - DFS와 BFS 구현
 * 담당: Person 1
 * 
 * 기능:
 * - 깊이 우선 탐색 (DFS): 재귀 또는 스택 사용
 * - 너비 우선 탐색 (BFS): 큐 사용
 * - 시작 정점: 항상 1번
 * - 인접 정점 방문 순서: 번호가 작은 것부터
 */
public class GraphTraversal {
    
    /**
     * 깊이 우선 탐색 (DFS)
     * @param graph 탐색할 그래프
     * @param start 시작 정점 (보통 1번)
     * @return 방문 순서대로 정점 번호를 담은 리스트
     */
    public static List<Integer> dfs(Graph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getNumVertices() + 1];  // 1-indexed
        
        // TODO: Person 1 구현
        // DFS 구현 (재귀 또는 스택 사용)
        // 1. start 정점부터 시작
        // 2. 방문한 정점은 visited 배열에 표시
        // 3. 인접 정점 중 번호가 작은 것부터 방문 (1, 2, 3, ... 순)
        // 4. 방문 순서대로 result 리스트에 추가
        
        dfsRecursive(graph, start, visited, result);
        
        return result;
    }
    
    /**
     * DFS 재귀 헬퍼 메서드
     * @param graph 탐색할 그래프
     * @param current 현재 정점
     * @param visited 방문 여부 배열
     * @param result 결과 리스트
     */
    private static void dfsRecursive(Graph graph, int current, boolean[] visited, List<Integer> result) {
        // TODO: Person 1 구현
        // 1. current 정점 방문 처리
        // 2. result에 추가
        // 3. current의 인접 정점들을 오름차순으로 순회하며 재귀 호출
        
        // 힌트:
        // visited[current] = true;
        // result.add(current);
        // for (int next = 1; next <= graph.getNumVertices(); next++) {
        //     if (!visited[next] && graph.hasEdge(current, next)) {
        //         dfsRecursive(graph, next, visited, result);
        //     }
        // }
    }
    
    /**
     * 너비 우선 탐색 (BFS)
     * @param graph 탐색할 그래프
     * @param start 시작 정점 (보통 1번)
     * @return 방문 순서대로 정점 번호를 담은 리스트
     */
    public static List<Integer> bfs(Graph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getNumVertices() + 1];  // 1-indexed
        Queue<Integer> queue = new LinkedList<>();
        
        // TODO: Person 1 구현
        // BFS 구현 (큐 사용)
        // 1. start 정점을 큐에 추가하고 방문 처리
        // 2. 큐가 빌 때까지:
        //    a. 큐에서 정점을 꺼냄
        //    b. result에 추가
        //    c. 인접 정점 중 미방문 정점을 번호 순서대로 큐에 추가
        
        // 힌트:
        // queue.offer(start);
        // visited[start] = true;
        // while (!queue.isEmpty()) {
        //     int current = queue.poll();
        //     result.add(current);
        //     for (int next = 1; next <= graph.getNumVertices(); next++) {
        //         if (!visited[next] && graph.hasEdge(current, next)) {
        //             visited[next] = true;
        //             queue.offer(next);
        //         }
        //     }
        // }
        
        return result;
    }
    
    /**
     * 방문 순서를 포맷팅하여 출력 형식으로 변환
     * @param path 방문 순서 리스트
     * @return "1 – 2 – 3 – 4" 형식의 문자열
     */
    public static String formatPath(List<Integer> path) {
        if (path.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append(" – ");  // 양쪽 공백 포함 하이픈
            }
        }
        sb.append(" ");  // 끝에 공백 추가
        
        return sb.toString();
    }
}

