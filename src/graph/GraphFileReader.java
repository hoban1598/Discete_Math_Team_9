package graph;

import java.io.*;
import java.util.*;

// 파일에서 그래프 읽기
public class GraphFileReader {
    
    // input1.txt 읽기 - DFS/BFS용 무가중치 그래프
    // 형식: N줄, 각 줄은 "정점번호 인접1 인접2 ..."
    public static List<Graph> readUnweightedGraphs(String filename) throws IOException {
        List<Graph> graphs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            
            int n = Integer.parseInt(line);  // 정점 개수
            Graph graph = new Graph(n, false);
            
            // n개의 줄 읽기
            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().trim().split("\\s+");
                int vertex = Integer.parseInt(tokens[0]);
                
                // 나머지는 인접한 정점들
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
    
    // input2.txt 읽기 - Dijkstra용 가중치 그래프
    // 형식: "정점번호 인접1 가중치1 인접2 가중치2 ..."
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
                
                // j+1이 가중치 (정점, 가중치 쌍으로 읽음)
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
}

