class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int currentHealth = health;
        int length = attacks.length;
        int lastTime = attacks[length-1][0];
        int time = 0;
        int index = 0;
        int success = 0;

        while(currentHealth > 0 && time <= lastTime) {
            if(time != attacks[index][0]) {
                currentHealth += bandage[1];
                success++;

                if(success == bandage[0]) {
                    success = 0;
                    currentHealth += bandage[2];
                }

                if(currentHealth > health) {
                    currentHealth = health;
                }
            } else {
                currentHealth -= attacks[index][1];
                index++;
                success = 0;
            }
            time++;
        }



        return currentHealth <= 0 ? -1 : currentHealth;
    }
}