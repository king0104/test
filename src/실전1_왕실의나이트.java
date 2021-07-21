import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실전1_왕실의나이트 {
    // 핵심 알고리즘
    // 1. char to int
    // 2. 가능한 경로의 경우의 수를 배열에 저장하기!!! - 이게 진짜 중요!! 무조건 쓰인다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();
        // 현재 위치를 x,y로 표현(정수)
        int x = str.charAt(0) - 'a' + 1;
        int y = str.charAt(1) -'0';


        int[] dx = {-2,-2,+2,+2,-1,+1,-1,+1};
        int[] dy = {-1,+1,-1,+1,-2,-2,+2,+2};

        int cnt = 0;
        for(int i=0;i<8;i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x > 0 && next_x <9 && next_y>0 && next_y<9)
                cnt++;
        }
        System.out.println(cnt);

    }
}
