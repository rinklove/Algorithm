import java.io.*;
import java.util.*;

public class Main {

    static Set<String> set = new HashSet<>();
    static String[] letters;
    static int l, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        letters = new String[c];

        st = new StringTokenizer(br.readLine(), " ");
        br.close();

        for (int i = 0; i < letters.length; i++) {
            letters[i] = st.nextToken();
        }

        //알파벳 순으로 정렬
        Arrays.sort(letters);
        dfs("", 0, 0, 0);

        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        for(String s : list) {
            bw.write(s);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(String password, int con, int vow, int index) {
        if(password.length() == l) {
            if(con >= 1 && vow >= 2) {
                set.add(password);
            }
            return;
        }
        if(index == letters.length) return;


        dfs(password, con, vow, index+1);
        if(letters[index].matches("[aeiou]")) con++;
        else vow++;
        dfs(password + letters[index], con, vow, index+1);

    }
}
