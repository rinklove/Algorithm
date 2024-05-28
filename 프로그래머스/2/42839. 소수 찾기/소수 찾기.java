import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
//123
//1 2 3 12 13
class Solution {
    private final Set<Integer> primes = new HashSet<>();  //소수
    private final Set<Integer> numberSet = new HashSet<>(); //조합 가능한 수
    public int solution(String numbers) {
        int answer = 0;
        initPrimes();
        dfs(numbers, "");
        System.out.println("numberSet = " + numberSet);
        answer = findAnswer();
        
        return answer;
    }
    
    
    private int findAnswer() {
        int answer = 0;
        
        //numberSet의 숫자가 소수이면 +1
        for(Integer number : numberSet) {
            if(primes.contains(number)) {
                System.out.println("number = " + number);
                answer++;
            }
        }
        return answer;
    }
    
    //소수를 저장하는 Set 초기화하기
    private void initPrimes() {
        int limit = 9999999;
        boolean[] isPrime = initArr(limit);

        // 에라토스테네스의 체를 이용하여 소수를 찾음
        findPrime(isPrime, limit);

        // 소수를 설정
        setPrimes(isPrime, limit);
    }
    
    //각 수에 대하여 소수 여부를 판별할 수 있는 배열 반환하기
    private boolean[] initArr(int limit) {
        boolean[] arr = new boolean[limit + 1];
        Arrays.fill(arr, true);

        arr[0] = arr[1] = false;
        return arr;
    }
    
    private void findPrime(boolean[] isPrime, int limit) {
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
    
    private void setPrimes(boolean[] isPrime, int limit) {
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }
    
    //각 숫자 카드로 조합할 수 있는 모든 수를 numberSet에 저장하기
    //
    /**
        12345 ""
        2345 1 / 1345 2 / 1245 3 / 1235 4 / 1234 5
        345 12 
        45 123 
        5 1234 
        "" 12345
        4 1235
        35 124
        
    */
    private void dfs(String numbers, String others) {
        if(!numbers.isEmpty()) {
            numberSet.add(Integer.parseInt(numbers));
        }
        
        if(!others.isEmpty()) {
            numberSet.add(Integer.parseInt(others));    
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            dfs(numbers.substring(0,i)+numbers.substring(i+1), others + c); 
        }
    }
    
    
}