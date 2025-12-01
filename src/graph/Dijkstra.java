package graph;

import java.util.*;

/**
 * Dijkstra 클래스 - Dijkstra 알고리즘 구현
 * 담당: Person 2
 * 
 * 기능:
 * - 시작 정점(1번)에서 모든 정점까지의 최단 경로 찾기
 * - 인접 행렬 기반 구현
 * - 경로 복원을 위한 parent 배열 사용
 */
public class Dijkstra {
    
    /**
     * Dijkstra 알고리즘 수행 결과를 담는 클래스
     */
    public static class Result {
        public int[] distance;    // distance[i] = 시작점에서 정점 i까지의 최단 거리
        public int[] parent;      // parent[i] = 최단 경로에서 정점 i의 이전 정점
        public int numVertices;   // 정점 개수
        
        public Result(int n) {
            this.numVertices = n;
            this.distance = new int[n + 1];
            this.parent = new int[n + 1];
            
            // 초기화
            Arrays.fill(distance, Graph.INF);
            Arrays.fill(parent, -1);
        }
        
        /**
         * 시작점에서 목적지까지의 경로를 복원
         * @param dest 목적지 정점
         * @return 경로 리스트 (시작점 -> ... -> 목적지)
         */
        public List<Integer> getPath(int dest) {
            List<Integer> path = new ArrayList<>();
            
            // TODO: Person 2 구현
            // parent 배열을 역추적하여 경로 복원
            // 1. dest부터 시작하여 parent를 따라가며 경로 수집
            // 2. 역순이므로 마지막에 reverse 필요
            
            // 힌트:
            // if (distance[dest] == Graph.INF) {
            //     return path;  // 도달 불가능
            // }
            // for (int v = dest; v != -1; v = parent[v]) {
            //     path.add(v);
            // }
            // Collections.reverse(path);
            
            return path;
        }
    }
    
    /**
     * Dijkstra 알고리즘 수행
     * @param graph 가중치 그래프
     * @param start 시작 정점 (보통 1번)
     * @return 최단 거리 및 경로 정보를 담은 Result 객체
     */
    public static Result dijkstra(Graph graph, int start) {
        int n = graph.getNumVertices();
        Result result = new Result(n);
        boolean[] visited = new boolean[n + 1];
        
        // TODO: Person 2 구현
        // Dijkstra 알고리즘 구현
        // 1. 시작 정점의 거리를 0으로 초기화
        // 2. 모든 정점에 대해:
        //    a. 방문하지 않은 정점 중 최단 거리 정점 선택
        //    b. 해당 정점 방문 처리
        //    c. 인접 정점들의 거리 갱신 (새로운 거리 < 기존 거리일 때만)
        // 3. parent 배열을 이용해 경로 추적 가능하도록 저장
        
        // 힌트:
        // result.distance[start] = 0;
        // 
        // for (int i = 0; i < n; i++) {
        //     // 미방문 정점 중 최단 거리 정점 찾기
        //     int minDist = Graph.INF;
        //     int u = -1;
        //     for (int v = 1; v <= n; v++) {
        //         if (!visited[v] && result.distance[v] < minDist) {
        //             minDist = result.distance[v];
        //             u = v;
        //         }
        //     }
        //     
        //     if (u == -1) break;  // 더 이상 방문할 정점 없음
        //     visited[u] = true;
        //     
        //     // 인접 정점 거리 갱신
        //     for (int v = 1; v <= n; v++) {
        //         if (!visited[v] && graph.getWeight(u, v) != Graph.INF) {
        //             int newDist = result.distance[u] + graph.getWeight(u, v);
        //             if (newDist < result.distance[v]) {  // < 사용 (같을 때는 갱신 X)
        //                 result.distance[v] = newDist;
        //                 result.parent[v] = u;
        //             }
        //         }
        //     }
        // }
        
        return result;
    }
    
    /**
     * 경로를 포맷팅하여 출력 형식으로 변환
     * @param path 경로 리스트
     * @return "1 – 2 – 3" 형식의 문자열
     */
    public static String formatPath(List<Integer> path) {
        if (path.isEmpty()) {
            return "도달 불가";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append(" – ");  // 양쪽 공백 포함 하이픈
            }
        }
        
        return sb.toString();
    }
}

