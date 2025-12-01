package graph;

import java.io.*;
import java.util.*;

/**
 * Main 클래스 - 프로그램 실행 진입점
 * 담당: 공통 (Person 1, Person 2 협업)
 * 
 * 실행 흐름:
 * 1. input1.txt 읽기 → DFS/BFS 수행 및 출력
 * 2. input2.txt 읽기 → Dijkstra 수행 및 출력
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            // ========== Part 1: 그래프 탐방 (DFS/BFS) ==========
            System.out.println("1. 그래프 탐방 수행 결과");
            System.out.println();
            
            List<Graph> unweightedGraphs = GraphFileReader.readUnweightedGraphs("input1.txt");
            
            for (int i = 0; i < unweightedGraphs.size(); i++) {
                Graph graph = unweightedGraphs.get(i);
                
                System.out.println("그래프 [" + (i + 1) + "]");
                System.out.println("----------------------------");
                
                // DFS 수행
                List<Integer> dfsResult = GraphTraversal.dfs(graph, 1);
                System.out.println("깊이 우선 탐색");
                System.out.println(GraphTraversal.formatPath(dfsResult));
                
                // BFS 수행
                List<Integer> bfsResult = GraphTraversal.bfs(graph, 1);
                System.out.println("너비 우선 탐색");
                System.out.println(GraphTraversal.formatPath(bfsResult));
                
                System.out.println("============================");
                System.out.println();
            }
            
            // ========== Part 2: 최단 경로 (Dijkstra) ==========
            System.out.println("2. 최단 경로 구하기 수행 결과");
            System.out.println();
            
            List<Graph> weightedGraphs = GraphFileReader.readWeightedGraphs("input2.txt");
            
            for (int i = 0; i < weightedGraphs.size(); i++) {
                Graph graph = weightedGraphs.get(i);
                
                System.out.println("그래프 [" + (i + 1) + "]");
                System.out.println("----------------------------");
                System.out.println("시작점: 1");
                
                // Dijkstra 수행
                Dijkstra.Result result = Dijkstra.dijkstra(graph, 1);
                
                // 각 정점까지의 최단 경로 출력
                for (int v = 2; v <= graph.getNumVertices(); v++) {
                    List<Integer> path = result.getPath(v);
                    String pathStr = Dijkstra.formatPath(path);
                    int distance = result.distance[v];
                    
                    if (distance == Graph.INF) {
                        System.out.println("정점 [" + v + "]: 도달 불가");
                    } else {
                        System.out.println("정점 [" + v + "]: " + pathStr + ", 길이: " + distance);
                    }
                }
                
                System.out.println("=========================");
                System.out.println();
            }
            
        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + e.getMessage());
            System.err.println("input1.txt와 input2.txt 파일이 프로그램과 같은 디렉터리에 있는지 확인하세요.");
        } catch (IOException e) {
            System.err.println("파일 읽기 오류: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

