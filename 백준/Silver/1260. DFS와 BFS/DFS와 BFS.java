import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        List<Integer>[] map = new List[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            map[n1].add(n2);
            map[n2].add(n1);
        }

        for(List<Integer> nodes: map) {
            Collections.sort(nodes);
        }
        
        dfs(map, start, bw);
        bw.newLine();

        Arrays.fill(visited, false);
        bfs(map, start, bw);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs(List<Integer>[] map, int node, BufferedWriter bw) throws IOException {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);

        while(!q.isEmpty()) {
            int poll = q.poll();
            if(visited[poll]) continue;

            visit(poll, bw);
            for(Integer n : map[poll]) {
                if(!visited[n]) {
                    q.offer(n);
                }
            }
        }

    }

    private static void dfs(List<Integer>[] map, int node, BufferedWriter bw) throws IOException {
        visit(node, bw);

        for(Integer n : map[node]) {
            if(!visited[n]) {
                dfs(map, n, bw);
            }
        }
    }

    private static void visit(int node, BufferedWriter bw) throws IOException {
        bw.write(node +" ");
        visited[node] = true;
    }
}
