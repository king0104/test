import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = 1 ,y = 1;

        StringTokenizer st2 = new StringTokenizer(br.readLine());


        while(st2.hasMoreTokens()){

            String word = st2.nextToken();

            if(x<1 || x>n || y<1 || y>n)
                continue;
            else {
                switch (word) {
                    case "L":
                        y--;
                    case "R":
                        y++;
                    case "U":
                        x--;
                    case "D":
                        x++;
                }
            }
        }

        System.out.println(x + " " + y );

    }
}
