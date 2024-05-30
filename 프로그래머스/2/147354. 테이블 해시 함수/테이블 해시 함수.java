import java.util.Arrays;

class Solution {
    /*
        col -> index data튜플에서 (col-1)번째 인덱스를 기준으로 오름차순
            -> 값이 동일하면 첫번째 값을 기준으로 내림차순
        
        0 =   0
        4 = 100
        
        길이를 맞춘 후 xor 연산 수행 
    */
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        //튜플 정렬
        Arrays.sort(data, (c1, c2) -> c1[col-1] == c2[col-1] ? c2[0] - c1[0] : c1[col-1] - c2[col-1]);
        
        //각 튜플의 S_i를 구하기
        int arr[] = getS_i(data, row_begin, row_end);
        
        //구한 S_i의 xor 연산 수행하기  
        for(int i : arr) {
            answer = answer^i;
        }
        
           
        return answer;
    }
    
    private int[] getS_i(int[][] data, int row_begin, int row_end) {
        int index = 0;
        int[] s_arr = new int[row_end - row_begin + 1];
        
        // 각 튜플에 대해서 S_i 값을 저장 후 반환하기
        for(int i = row_begin-1; i < row_end; i++) {
            for(int j = 0; j < data[i].length; j++) {
                data[i][j] %= (i+1);
                s_arr[index] += data[i][j];
            }
            index++;
        }
        return s_arr;
    }
    
//     ^연산자를 사용하지 않고 구현하기..
//     private int findXorValue(int[] arr) {
//         StringBuilder sb = new StringBuilder();
//         //이진수 문자로 저장
//         String[] binaryStrings = convertBinaryString(arr);
        
//         //각 자릿수에 대해서 xor 연산의 결과를 StrinBuilder에 저장
//         for(int i = 0; i < binaryStrings[0].length(); i++) {
//             char c = binaryStrings[0].charAt(i);
//             for(int j = 1; j < binaryStrings.length; j++) {
//                 c = c == binaryStrings[j].charAt(i) ? '0' : '1';
//             }
//             sb.append(c);
//         }
        
//         //이진수 문자열을 정수로 반환
//         return Integer.parseInt(sb.toString(), 2);
//     }
    
    
//     private String[] convertBinaryString(int[] arr) {
//         String[] binaryStrings = new String[arr.length];
//         int max = 0; //변환한 이진수 문자열 중 가장 긴 길이
        
//         for(int i = 0; i < arr.length; i++) {
//             binaryStrings[i] = Integer.toBinaryString(arr[i]);
//             max = Math.max(max, binaryStrings[i].length());
//         }
        
//         //이진수 문자열의 길이를 맞추기
//         fitLength(binaryStrings, max);
        
//         return binaryStrings;
//     }
    
//     /*
//       0
//       100
//     */
//     private void fitLength(String[] arr, int max) {
//         StringBuilder sb = new StringBuilder();
//         int index = 0;
        
//         //가장 긴 문자열 길이에 맞춰서 앞자리에 0 추가하기
//         for(String s : arr) {
//             for(int i = 0; i < max - s.length(); i++) {
//                 sb.append("0");
//             }
//             sb.append(s);
//             arr[index++] = sb.toString();
//             sb.setLength(0);
//         }
//     }
}