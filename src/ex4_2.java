import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n<3)
            System.out.println(n*(60*60-45*45));
        else if(n<13)
            System.out.println(n*(60*60-45*45) + 1*15*15);
        else if(n<23)
            System.out.println(n*(60*60-45*45) + 2*15*15);
        else
            System.out.println(n*(60*60-45*45) + 3*15*15);
    }
}
