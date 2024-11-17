import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = scanner.nextInt();
        
        for (int t = 0; t < T; t++) {
            int B = scanner.nextInt();
            int N = scanner.nextInt();
            
            int[] S = new int[N];
            for (int i = 0; i < N; i++) {
                S[i] = scanner.nextInt();
            }
            
            int bestHeight = -1;
            int bestDanger = Integer.MAX_VALUE;
            int bestCost = Integer.MAX_VALUE;
            
            for (int height = 0; height <= 100; height++) {
                int danger = 0;
                int cost = 0;
                
                for (int i = 0; i < N; i++) {
                    if (S[i] < height) {
                        danger += height - S[i]; 
                    } else {
                        cost += S[i] - height; 
                    }
                }
                
                
                if (cost <= B) {
                    if (danger < bestDanger || (danger == bestDanger && cost < bestCost)) {
                        bestDanger = danger;
                        bestCost = cost;
                        bestHeight = height;
                    }
                }
            }
            
            
            System.out.println(bestHeight);
        }
        
        scanner.close();
    }
}
