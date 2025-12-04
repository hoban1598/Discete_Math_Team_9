package graph;

import java.util.*;

// Dijkstra 알고리즘 - 최단 경로
public class Dijkstra {
    
    // 결과 담는 클래스
    public static class Result {
        public int[] distance;  // 각 정점까지의 최단 거리
        public int[] parent;    // 경로 복원용
        public int numVertices;
        
        public Result(int n) {
            this.numVertices = n;
            this.distance = new int[n + 1];
            this.parent = new int[n + 1];
            
            Arrays.fill(distance, Graph.INF);
            Arrays.fill(parent, -1);
        }
        
        // 경로 복원 - parent 배열 역추적
        public List<Integer> getPath(int dest) {
            List<Integer> path = new ArrayList<>();
            
            if (distance[dest] == Graph.INF) {
                return path;  // 못 가는 경우
            }
            
            // dest부터 거꾸로 올라가기
            for (int v = dest; v != -1; v = parent[v]) {
                path.add(v);
            }
            
            Collections.reverse(path);  // 뒤집어야 start->dest 순서
            return path;
        }
    }
    
    // Dijkstra 메인 알고리즘
    public static Result dijkstra(Graph graph, int start) {
        int n = graph.getNumVertices();
        Result result = new Result(n);
        boolean[] visited = new boolean[n + 1];
        
        result.distance[start] = 0;  // 시작점은 거리 0
        
        for (int i = 0; i < n; i++) {
            // 아직 방문 안한 정점 중에 제일 가까운 거 찾기
            int minDist = Graph.INF;
            int u = -1;
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && result.distance[v] < minDist) {
                    minDist = result.distance[v];
                    u = v;
                }
            }
            
            if (u == -1) break;  // 더 이상 갈 곳 없음
            visited[u] = true;
            
            // u에서 갈 수 있는 정점들 거리 업데이트
            for (int v = 1; v <= n; v++) {
                if (!visited[v] && graph.getWeight(u, v) != Graph.INF) {
                    int newDist = result.distance[u] + graph.getWeight(u, v);
                    if (newDist < result.distance[v]) {  // 더 짧으면 갱신
                        result.distance[v] = newDist;
                        result.parent[v] = u;
                    }
                }
            }
        }
        
        return result;
    }
    
    // 출력 형식 맞추기
    public static String formatPath(List<Integer> path) {
        if (path.isEmpty()) {
            return "도달 불가";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append(" – ");
            }
        }
        
        return sb.toString();
    }
}

