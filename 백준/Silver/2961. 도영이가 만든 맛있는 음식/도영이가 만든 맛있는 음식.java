import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Ingredient {
        int sour;
        int bitter;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Ingredient[] ingredients = new Ingredient[n];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ingredients[i] = new Ingredient();
            ingredients[i].sour = Integer.parseInt(st.nextToken());
            ingredients[i].bitter = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
                min = Math.min(min, cook(ingredients, 1, 0,  0));
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int cook(Ingredient[] ingredients, int foodSour, int foodBitter, int depth) {
        if(depth == ingredients.length) {
            return foodSour == 1 && foodBitter == 0 ? Integer.MAX_VALUE : Math.abs(foodSour - foodBitter);
        }

        int addSour = foodSour * ingredients[depth].sour;
        int addBitter = foodBitter + ingredients[depth].bitter;

        int used = cook(ingredients, addSour, addBitter, depth + 1);
        int nonUsed = cook(ingredients, foodSour, foodBitter, depth + 1);

        return Math.min(used, nonUsed);
    }
}
