import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class 문제2_문자열재정렬_arraylist사용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int sum = 0;
        ArrayList<Character> array = new ArrayList<Character>();
        int j = 0;
        for(int i = 0; i<str.length();i++){
            if((str.charAt(i) - '0') <= 9){
                sum += (str.charAt(i) - '0');
            }
            else{
                array.add(str.charAt(i));
                j++;
            }
        }

        Collections.sort(array);
        for(int i=0;i<array.size();i++){
            sb.append(array.get(i));
        }
        System.out.println(sb.toString() + sum);
    }
}
