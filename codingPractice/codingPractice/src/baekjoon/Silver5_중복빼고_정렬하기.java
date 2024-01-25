package baekjoon;


import java.util.Arrays;
import java.util.Scanner;

public class Silver5_중복빼고_정렬하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for(int i = 0; i < N; i ++) {
            arr[i] = sc.nextInt();
        }

        arr = Arrays.stream(arr).distinct().sorted().toArray();

        StringBuilder sb = new StringBuilder();

        for (int i :
                arr) {
            sb.append(i+ " ");
        }

        System.out.println(sb.toString().trim());
    }
}
