import java.util.*;

public class Main5b1 {

    public static int findOptimalHeight(int b, int[] heights) {
        int n = heights.length;
        int maxHeight = Arrays.stream(heights).max().getAsInt();
        int optimalHeight = 0;
        int minDanger = Integer.MAX_VALUE;

        for (int h = 0; h <= maxHeight; h++) {
            int danger = 0;
            int cost = 0;

            for (int height : heights) {
                if (height < h) {
                    int xyz = (h - height);
                    danger += xyz;
                } else if (height > h) {
                    cost += (height - h);
                }
            }

            if (cost <= b) {
                if (danger < minDanger || (danger == minDanger && cost < b)) {
                    minDanger = danger;
                    optimalHeight = h;
                }
            }
        }

        return optimalHeight;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int b = scanner.nextInt();
            int n = scanner.nextInt();
            int m = n;
            int[] heights = new int[m];
            for (int i = 0; i < n; i++) {
                heights[i] = scanner.nextInt();
            }
            System.out.println(findOptimalHeight(b, heights));
        }

        scanner.close();
    }
}
