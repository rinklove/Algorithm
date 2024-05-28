import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class Solution {
    private final Set<Integer> primes = new HashSet<>();  //소수
    private final Set<Integer> numberSet = new HashSet<>(); //조합 가능한 수
    
    public int solution(String numbers) {
        int answer = 0;
        
        //소수인 숫자를 세팅
        initPrimes();
        //dfs를 활용하여 조합 가능한 모든 수 저장
        dfs(numbers, "");
        
        //조합된 수 중에서 소수가 몇 개인지 반환
        answer = findAnswer();
        
        return answer;
    }
    
    
    private int findAnswer() {
        int answer = 0;
        
        //numberSet의 숫자가 소수이면 +1
        for(Integer number : numberSet) {
            if(primes.contains(number)) {
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
    
    //dfs를 활용하여 모든 수 조합하기
    private void dfs(String numbers, String others) {        
        if(!others.isEmpty()) {
            numberSet.add(Integer.parseInt(others));    
        }
        
        for(int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            dfs(numbers.substring(0,i)+numbers.substring(i+1), others + c); 
        }
    }   
}