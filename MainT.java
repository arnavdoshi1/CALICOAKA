import java.util.*;
import java.math.*;

public class MainT {
  
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    
    public static List<int[]> precomputeHouses(int maxN) {
        List<int[]> houses = new ArrayList<>();
        
        
        for (int x = 1; x <= 300; x++) {
            for (int y = 1; y <= 300; y++) {
                if (gcd(x, y) == 1) {
                    houses.add(new int[]{x, y});
                }
            }
        }
        
       
        houses.sort((a, b) -> {
            int distA = a[0] + a[1];
            int distB = b[0] + b[1];
            if (distA == distB) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(distA, distB);
        });
        
        return houses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        List<int[]> houses = precomputeHouses(100);

        
        int T = sc.nextInt();
        
       
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] house = houses.get(N - 1); // Addresses are 1-based, so subtract 1
            System.out.println(house[0] + " " + house[1]);
        }
        
        sc.close();
    }
}
