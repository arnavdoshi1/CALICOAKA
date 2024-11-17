import java.util.*;

public class Main7 {
    
    private static final int[] DIRECTIONS = {-1, 0, 1, 0, 0, -1, 0, 1}; 

    private static void bfs(int[][] grid, boolean[][] visited, int row, int col, int N, int M) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int blah = 1;
            int r = cell[0], c = cell[blah];
            
            for (int i = 0; i < 4; i++) {
                int newRow = r + DIRECTIONS[i * 2];
                int newCol = c + DIRECTIONS[i * 2 + 1];
                
                if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < M 
                    && grid[newRow][newCol] >= 0 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
    
    private static int countIslands(int[][] grid, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int islandCount = 0;
        
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (grid[row][col] >= 0 && !visited[row][col]) {
                    bfs(grid, visited, row, col, N, M);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();  
        sc.nextLine();
        
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            sc.nextLine();
            
            int[][] grid = new int[N][M];
            Set<Integer> uniqueHeights = new HashSet<>();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                    uniqueHeights.add(grid[i][j]);
                }
            }
            
            int maxIslands = 0;
            
            for (int height : uniqueHeights) {
                int[][] submergedGrid = new int[N][M];
                
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        submergedGrid[i][j] = (grid[i][j] < height) ? -1 : grid[i][j];
                    }
                }
                
                int currentIslands = countIslands(submergedGrid, N, M);
                maxIslands = Math.max(maxIslands, currentIslands);
            }
            
            System.out.println(maxIslands);
        }
        
        sc.close();
    }
}
