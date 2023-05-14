package gold;
import java.io.*;
import java.util.*;
public class B_1717_집합의표현{
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int quest = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(quest == 0){
                union(a,b);
            }else{
                if(checkSame(a,b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        System.out.print(sb.toString());
    }
    private static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(a>b) parent[b] =a;
            else parent[a] = b;
        }
    }
    private static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
    private static boolean checkSame(int a,int b){
        a = find(a);
        b = find(b);
        if(a == b) return true;
        else return false;
    }
}