package graph;

// 인접 행렬로 그래프 구현
// 무가중치: 1 or 0, 가중치: weight or INF
public class Graph {
    private int numVertices;
    private int[][] adjMatrix;
    private boolean isWeighted;
    public static final int INF = Integer.MAX_VALUE / 2;  // overflow 방지용으로 /2
    
    // 생성자 - weighted가 true면 가중치 그래프
    public Graph(int n, boolean weighted) {
        this.numVertices = n;
        this.isWeighted = weighted;
        this.adjMatrix = new int[n + 1][n + 1];  // 1부터 시작하도록 n+1 크기로
        
        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (weighted) {
                    adjMatrix[i][j] = INF;  // 가중치 그래프는 INF
                } else {
                    adjMatrix[i][j] = 0;  // 무가중치는 0
                }
            }
        }
    }
    
    // 간선 추가 - 무가중치용 (1로 표시)
    public void addEdge(int from, int to) {
        adjMatrix[from][to] = 1;
    }
    
    // 간선 추가 - 가중치용 (weight 저장)
    public void addEdge(int from, int to, int weight) {
        adjMatrix[from][to] = weight;
    }
    
    public int getNumVertices() {
        return numVertices;
    }
    
    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
    
    public boolean isWeighted() {
        return isWeighted;
    }
    
    // 간선이 있는지 체크
    public boolean hasEdge(int from, int to) {
        if (isWeighted) {
            return adjMatrix[from][to] != INF;  // INF가 아니면 간선 있음
        } else {
            return adjMatrix[from][to] == 1;  // 1이면 간선 있음
        }
    }
    
    // 가중치 값 리턴
    public int getWeight(int from, int to) {
        return adjMatrix[from][to];
    }
}

