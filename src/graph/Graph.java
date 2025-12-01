package graph;

/**
 * Graph 클래스 - 인접 행렬을 사용한 그래프 표현
 * 담당: Person 1
 * 
 * 기능:
 * - 인접 행렬(adjacency matrix)로 그래프 저장
 * - 무가중치 그래프: adjMatrix[i][j] = 1 (간선 존재), 0 (간선 없음)
 * - 가중치 그래프: adjMatrix[i][j] = weight (간선 가중치), INF (간선 없음)
 */
public class Graph {
    private int numVertices;           // 정점의 개수
    private int[][] adjMatrix;         // 인접 행렬
    private boolean isWeighted;        // 가중치 그래프 여부
    public static final int INF = Integer.MAX_VALUE / 2;  // 무한대 (간선 없음 표시)
    
    /**
     * 생성자
     * @param n 정점의 개수
     * @param weighted 가중치 그래프 여부 (true: 가중치, false: 무가중치)
     */
    public Graph(int n, boolean weighted) {
        this.numVertices = n;
        this.isWeighted = weighted;
        this.adjMatrix = new int[n + 1][n + 1];  // 1-indexed (정점 번호가 1부터 시작)
        
        // 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (weighted) {
                    adjMatrix[i][j] = INF;  // 가중치 그래프는 INF로 초기화
                } else {
                    adjMatrix[i][j] = 0;     // 무가중치 그래프는 0으로 초기화
                }
            }
        }
    }
    
    /**
     * 간선 추가 (무가중치 그래프용)
     * @param from 출발 정점
     * @param to 도착 정점
     */
    public void addEdge(int from, int to) {
        // TODO: Person 1 구현
        // 무가중치 그래프의 간선 추가
        // adjMatrix[from][to] = 1;
    }
    
    /**
     * 간선 추가 (가중치 그래프용)
     * @param from 출발 정점
     * @param to 도착 정점
     * @param weight 간선의 가중치
     */
    public void addEdge(int from, int to, int weight) {
        // TODO: Person 1 구현
        // 가중치 그래프의 간선 추가
        // adjMatrix[from][to] = weight;
    }
    
    /**
     * 정점 개수 반환
     */
    public int getNumVertices() {
        return numVertices;
    }
    
    /**
     * 인접 행렬 반환
     */
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
    
    /**
     * 가중치 그래프 여부 반환
     */
    public boolean isWeighted() {
        return isWeighted;
    }
    
    /**
     * 정점 from에서 정점 to로의 간선이 존재하는지 확인
     * @param from 출발 정점
     * @param to 도착 정점
     * @return 간선 존재 여부
     */
    public boolean hasEdge(int from, int to) {
        // TODO: Person 1 구현
        // 무가중치: adjMatrix[from][to] == 1
        // 가중치: adjMatrix[from][to] != INF
        return false;
    }
    
    /**
     * 정점 from에서 정점 to로의 간선 가중치 반환
     * @param from 출발 정점
     * @param to 도착 정점
     * @return 간선 가중치 (무가중치 그래프는 1, 간선 없으면 INF)
     */
    public int getWeight(int from, int to) {
        // TODO: Person 1 구현
        return adjMatrix[from][to];
    }
}

