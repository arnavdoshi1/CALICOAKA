import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());

        for (int t = 0; t < T; t++) {
            String[] dimensions = scanner.nextLine().split(" ");
            int N = Integer.parseInt(dimensions[0]);
            int M = Integer.parseInt(dimensions[1]);

            char[][] grid = new char[N][M];
            for (int i = 0; i < N; i++) {
                grid[i] = scanner.nextLine().toCharArray();
            }

            if (isTriangle(grid, N, M)) {
                System.out.println("phineas");
            } else {
                System.out.println("ferb");
            }
        }

        scanner.close();
    }

    private static boolean isTriangle(char[][] grid, int N, int M) {
        int minRow = N, maxRow = -1, minCol = M, maxCol = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '#') {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        if (width == height) {
            int hashCount = 0;
            for (int i = minRow; i <= maxRow; i++) {
                for (int j = minCol; j <= maxCol; j++) {
                    if (grid[i][j] == '#') {
                        hashCount+=1;
                    }
                }
            }
            return hashCount == (height * (height + 1)) / 2;
        } else {
            for (int i = minRow; i <= maxRow; i++) {
                for (int j = minCol; j <= maxCol; j++) {
                    if (grid[i][j] != '#') {
                        return false;
                    }
                }
            }
            return false;
        }
    }
}
