import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4_2_ans {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt=0;
        for(int i=0; i<=n;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++){
                    if(k%10 == 3 || k/10 == 3 || j%10 == 3 || j/10 == 3 || i%10 == 3)
                        cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
