package graph;

import java.io.*;
import java.util.*;

/**
 * GraphFileReader 클래스 - 파일에서 그래프 정보 읽기
 * 담당: Person 2
 * 
 * 기능:
 * - input1.txt: 무가중치 그래프 읽기 (DFS/BFS용)
 * - input2.txt: 가중치 그래프 읽기 (Dijkstra용)
 * - EOF까지 여러 그래프 읽기
 */
public class GraphFileReader {
    
    /**
     * input1.txt에서 무가중치 그래프들을 읽어서 리스트로 반환
     * @param filename 파일 이름 (예: "input1.txt")
     * @return 그래프 리스트
     * @throws IOException 파일 읽기 오류
     */
    public static List<Graph> readUnweightedGraphs(String filename) throws IOException {
        List<Graph> graphs = new ArrayList<>();
        
        // TODO: Person 2 구현
        // 1. 파일 열기
        // 2. EOF까지 반복:
        //    a. 정점 개수 N 읽기
        //    b. Graph 객체 생성 (무가중치)
        //    c. N개 줄을 읽어서 인접 정보 파싱
        //       형식: "정점번호 인접1 인접2 ..."
        //    d. addEdge()로 간선 추가
        //    e. graphs 리스트에 추가
        // 3. 파일 닫기
        
        // 힌트:
        // BufferedReader br = new BufferedReader(new FileReader(filename));
        // String line;
        // while ((line = br.readLine()) != null) {
        //     line = line.trim();
        //     if (line.isEmpty()) continue;
        //     
        //     int n = Integer.parseInt(line);
        //     Graph graph = new Graph(n, false);  // 무가중치
        //     
        //     for (int i = 0; i < n; i++) {
        //         String[] tokens = br.readLine().trim().split("\\s+");
        //         int vertex = Integer.parseInt(tokens[0]);
        //         
        //         // 인접 정점들 처리
        //         for (int j = 1; j < tokens.length; j++) {
        //             int adjacent = Integer.parseInt(tokens[j]);
        //             graph.addEdge(vertex, adjacent);
        //         }
        //     }
        //     
        //     graphs.add(graph);
        // }
        // br.close();
        
        return graphs;
    }
    
    /**
     * input2.txt에서 가중치 그래프들을 읽어서 리스트로 반환
     * @param filename 파일 이름 (예: "input2.txt")
     * @return 그래프 리스트
     * @throws IOException 파일 읽기 오류
     */
    public static List<Graph> readWeightedGraphs(String filename) throws IOException {
        List<Graph> graphs = new ArrayList<>();
        
        // TODO: Person 2 구현
        // 1. 파일 열기
        // 2. EOF까지 반복:
        //    a. 정점 개수 N 읽기
        //    b. Graph 객체 생성 (가중치)
        //    c. 여러 줄을 읽어서 인접 정보 파싱
        //       형식: "정점번호 인접1 가중치1 인접2 가중치2 ..."
        //       (정점번호만 있는 줄도 가능)
        //    d. addEdge(from, to, weight)로 간선 추가
        //    e. 빈 줄이 나오면 그래프 하나 완료
        // 3. 파일 닫기
        
        // 힌트:
        // BufferedReader br = new BufferedReader(new FileReader(filename));
        // String line;
        // while ((line = br.readLine()) != null) {
        //     line = line.trim();
        //     if (line.isEmpty()) continue;
        //     
        //     int n = Integer.parseInt(line);
        //     Graph graph = new Graph(n, true);  // 가중치
        //     
        //     // N개 정점에 대한 정보 읽기 (또는 빈 줄까지)
        //     int vertexCount = 0;
        //     while (vertexCount < n && (line = br.readLine()) != null) {
        //         line = line.trim();
        //         if (line.isEmpty()) break;
        //         
        //         String[] tokens = line.split("\\s+");
        //         int vertex = Integer.parseInt(tokens[0]);
        //         vertexCount++;
        //         
        //         // 인접 정점과 가중치 쌍으로 처리
        //         for (int j = 1; j < tokens.length; j += 2) {
        //             int adjacent = Integer.parseInt(tokens[j]);
        //             int weight = Integer.parseInt(tokens[j + 1]);
        //             graph.addEdge(vertex, adjacent, weight);
        //         }
        //     }
        //     
        //     graphs.add(graph);
        // }
        // br.close();
        
        return graphs;
    }
}

