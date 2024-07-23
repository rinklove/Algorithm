import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static final Scanner sc = new Scanner(System.in);
    static int[] flavor, cal;
    static int N, L, answer = Integer.MIN_VALUE;
	public static void main(String args[]) throws Exception
	{
		int T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
            init();
            int max = getMax(0, 0, 0);
			System.out.printf("#%d %d\n", test_case, max);
		}
	}
    
    private static void init() {
        N = sc.nextInt();
        L = sc.nextInt();

		flavor = new int[N];
        cal = new int[N];
        
        for(int i = 0; i < N; i++) {
                flavor[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
    }
    
    private static int getMax(int total, int depth, int currentCal) {
        if(depth == N) {
            if(answer < total) {
                return total;
            }
            return 0;
        }
        int tmp1 = getMax(total, depth + 1, currentCal);
        
        int tmp2 = 0;
        if(currentCal + cal[depth] <= L) {
            currentCal += cal[depth];
        	tmp2 = getMax(total + flavor[depth], depth + 1, currentCal);    
            currentCal -= cal[depth];
        }
		return Math.max(tmp1, tmp2);
    }
}