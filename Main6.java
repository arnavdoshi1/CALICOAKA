import java.util.*;

public class Main6 {
    
    public static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public static List<int[]> generateHouses() {
        List<int[]> houses = new ArrayList<>();
        
        for (int x = 1; x <= 200; x++) {
            for (int y = 1; y <= 200; y++) {
                if (gcd(x, y) == 1) {
                    houses.add(new int[]{x, y});
                }
            }
        }
        
        houses.sort((a, b) -> {
            int distA = a[0] + a[1];
            int distB = b[0] + b[1];
            if (distA != distB) {
                return distA - distB; 
            }
            return a[0] - b[0]; 
        });
        
        return houses;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        List<int[]> houses = generateHouses();
        
        int T = sc.nextInt();
        
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] house = houses.get(N - 1);  // Convert to 0-based index
            System.out.println(house[0] + " " + house[1]);
        }
        
        sc.close();
    }
}
