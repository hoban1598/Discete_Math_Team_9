package graph;

import java.io.*;
import java.util.*;

// 메인 실행 파일
public class Main {
    
    public static void main(String[] args) {
        try {
            // Part 1: DFS/BFS
            System.out.println("1. 그래프 탐방 수행 결과");
            System.out.println();
            
            List<Graph> unweightedGraphs = GraphFileReader.readUnweightedGraphs("input1.txt");
            
            for (int i = 0; i < unweightedGraphs.size(); i++) {
                Graph graph = unweightedGraphs.get(i);
                
                System.out.println("그래프 [" + (i + 1) + "]");
                System.out.println("----------------------------");
                
                // DFS
                List<Integer> dfsResult = GraphTraversal.dfs(graph, 1);
                System.out.println("깊이 우선 탐색");
                System.out.println(GraphTraversal.formatPath(dfsResult));
                
                // BFS
                List<Integer> bfsResult = GraphTraversal.bfs(graph, 1);
                System.out.println("너비 우선 탐색");
                System.out.println(GraphTraversal.formatPath(bfsResult));
                
                System.out.println("============================");
                System.out.println();
            }
            
            // Part 2: Dijkstra
            System.out.println("2. 최단 경로 구하기 수행 결과");
            System.out.println();
            
            List<Graph> weightedGraphs = GraphFileReader.readWeightedGraphs("input2.txt");
            
            for (int i = 0; i < weightedGraphs.size(); i++) {
                Graph graph = weightedGraphs.get(i);
                
                System.out.println("그래프 [" + (i + 1) + "]");
                System.out.println("----------------------------");
                System.out.println("시작점: 1");
                
                Dijkstra.Result result = Dijkstra.dijkstra(graph, 1);
                
                // 각 정점까지 최단 경로 출력
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

