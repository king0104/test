import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class 문제2_문자열재정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int sum = 0;
        char[] array = new char[str.length()];
        int j = 0;
        for(int i = 0; i<str.length();i++){
            if((str.charAt(i) - '0') <= 9){
                sum += (str.charAt(i) - '0');
            }
            else{
                array[j] = str.charAt(i);
                j++;
            }
        }

        Arrays.sort(array);
        String sortedString = new String(array);
        System.out.println(sortedString);
    }
}
