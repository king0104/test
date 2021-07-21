import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class 문제3_문자열압축 {
    public static int flag,l,k,result;

    public static ArrayList<Integer> results = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList <Character> array = new ArrayList<Character>();

        for(int n=1;n<str.length()/2;n++){
            // 1. 첫번째로 자른 문자열 저장
            for(int i=0;i<n;i++){
                array.add(str.charAt(i));
            }
            // 2. 첫번째로 잘린 문자열과 전체 문자열 비교
            for(int j=0;j<str.length();j=j+n){
                // _1. 탐색할 남은 문자열의 수가 n개 이상
                if(j-1+n < str.length()) {
                    // 2-1. 기준 문자열과 비교
                    for (int i = 0; i < n; i++) {
                        if (array.get(i) == str.charAt(j + i)) {
                            flag++;
                            l++;
                        }
                    }
                    if (flag == n) { // 2-2. 기준 문자열과 같은 부분 존재
                        k++;
                        flag = 0;
                    }
                    else { // 2-3. 기준 문자열과 다른 부분 존재
                        if (k==1) result += n;
                        else if (k<10) result += (n+1); // 2-3.1. 현재까지 압축한 결과 저장
                        else if(k>=10) result += (n+2);
                        else result += (n+3);

                        for (int i = 0; i < n; i++) { // 2-3.2 새로운 기준 배열 생성
                            array.set(i, str.charAt(j + i));
                            j = j-n;
                            flag = 0;
                            l = 0;
                            k = 0;
                        }
                    }
                }
                // _2. 탐색할 남은 문자열의 수가 n개 미만
                else
                {
                    result += (str.length() - j);
                }
            }
            results.add(result);
        }
        Collections.sort(results);

        System.out.println(results.get(0));
    }
}
