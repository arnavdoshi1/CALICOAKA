import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine()); 
        
        for (int t = 0; t < T; t++) {
            String S = scanner.nextLine();
            int i = 0;
            while (i < S.length()) {
                char token = S.charAt(i);

                if (token == 'O') {
                    System.out.println("[###OREO###]");
                } else if (token == 'R' && i + 1 < S.length() && S.charAt(i + 1) == 'E') {
                    System.out.println("[--------]");
                    i++; 
                } else if (token == '&') {
                    System.out.println();
                }
                i+=1;
            }
        }

        scanner.close();
    }
}