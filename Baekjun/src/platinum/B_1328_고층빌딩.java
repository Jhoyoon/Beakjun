package platinum;
import java.io.*;
import java.util.*;
public class B_1328_고층빌딩{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long[][][] D = new long[200][200][200];
        long MOD = 1000000007;
        D[1][1][1] = 1;
        for(int i=2;i<=N;i++){
            for(int j=1;j<=L;j++){
                for(int k = 1;k<=R;k++){
                    D[i][j][k] = (D[i-1][j][k-1]+D[i-1][j-1][k]+(D[i-1][j][k]*(i-2)))%MOD;
                }
            }
        }
        System.out.print(D[N][L][R]);
    }
}