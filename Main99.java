import java.util.*;

public class Main99 {

    static Map<Integer, Set<Integer>> graph = new HashMap<>();

    public static int scan(int v) {
        System.out.println("SCAN " + v);
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();  
    }

    public static void submit(int d) {
        System.out.println("SUBMIT " + d);
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        if ("CORRECT".equals(result)) {
            System.exit(0);  
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  
        
        for (int testCase = 0; testCase < T; testCase++) {
            graph.clear();

            
            scan(1);  
            scan(1);  
            scan(1);  
            scan(39); 
            scan(314); 
            scan(69); 
            submit(2); 

            scan(500); 
            scan(1);   
            submit(1); 
        }
    }
}
