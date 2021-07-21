import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문제1_럭키스트레이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
         String str = br.readLine();

         int n = str.length() / 2;
         int sum1 = 0;
         for(int i=0;i<n;i++){
             sum1 += (str.charAt(i) - '0');
         }
         int sum2 = 0;
         for(int j=n;j<str.length();j++){
             sum2 += (str.charAt(j) - '0');
         }

         if(sum1 == sum2)
             System.out.println("LUCKY");
         else
             System.out.println("READY");

    }
}

// 답지와 내가 다른 점
// 1. summary라는 하나의 변수에
// 2. 앞부분 절반은 쭉 더해주고
// 3. 뒷부분 절반은 쭉 빼줘서
// 4. summary == 0일때 LUCKY 출력!

/*
import java.util.*;

public class Main {

    public static String str;
    public static int summary = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        // 왼쪽 부분의 자릿수의 합 더하기
        for (int i = 0; i < str.length() / 2; i++) {
            summary += str.charAt(i) - '0';
        }

        // 오른쪽 부분의 자릿수의 합 빼기
        for (int i = str.length() / 2; i < str.length(); i++) {
            summary -= str.charAt(i) - '0';
        }

        // 왼쪽 부분과 오른쪽 부분의 자릿수 합이 동일한지 검사
        if (summary == 0) System.out.println("LUCKY");
        else System.out.println("READY");
    }
}
 */
