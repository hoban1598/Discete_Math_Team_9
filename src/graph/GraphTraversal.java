package graph;

import java.util.*;

// DFS랑 BFS 구현 - 수업 때 배운 거 그대로
public class GraphTraversal {
    
    // DFS - 재귀로 구현
    public static List<Integer> dfs(Graph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getNumVertices() + 1];
        
        dfsRecursive(graph, start, visited, result);
        return result;
    }
    
    // DFS 재귀 함수
    private static void dfsRecursive(Graph graph, int current, boolean[] visited, List<Integer> result) {
        visited[current] = true;
        result.add(current);
        
        // 인접한 정점들 중 작은 번호부터 방문
        for (int next = 1; next <= graph.getNumVertices(); next++) {
            if (!visited[next] && graph.hasEdge(current, next)) {
                dfsRecursive(graph, next, visited, result);
            }
        }
    }
    
    // BFS - 큐 사용
    public static List<Integer> bfs(Graph graph, int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getNumVertices() + 1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            
            // 인접 정점들 큐에 넣기
            for (int next = 1; next <= graph.getNumVertices(); next++) {
                if (!visited[next] && graph.hasEdge(current, next)) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        
        return result;
    }
    
    // 출력 형식 맞추기 위한 함수
    public static String formatPath(List<Integer> path) {
        if (path.isEmpty()) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append(" – ");
            }
        }
        sb.append(" ");
        
        return sb.toString();
    }
}

