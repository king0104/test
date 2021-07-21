import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실전2_게임개발 {
    public static int n,m,now_x,now_y,dir;

    public static int[][] arr = new int[50][50];

    // 북, 동, 남, 서 방향 정의
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,1,0,-1};

    public static void turn_left(){
        dir -= 1;
        if (dir == -1)
            dir = 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n,m 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 현재 x,y,dir 입력받기
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        now_x = Integer.parseInt(st2.nextToken());
        now_y = Integer.parseInt(st2.nextToken());
        dir = Integer.parseInt(st2.nextToken());

        // 전체 맵 정보 입력받기
        for(int i=0;i<n;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st3.nextToken());
            }
        }


        // 0. 현재 위치 방문 => 1로 만들기
        arr[now_x][now_y] = 1;

        for(int i=0;i<3;i++){

        }



        // 1. 다음 좌표 정의
        int next_x, next_y;
        if(dir==0){
            next_x = now_x;
            next_y = now_y + 1;
        }
        else if(dir==1){
            next_x = now_x + 1;
            next_y = now_y;
        }
        else if(dir==2){
            next_x = now_x;
            next_y = now_y - 1;
        }
        else{
            next_x = now_x - 1;
            next_y = now_y;
        }
        // 2. 다음 위치 방문 가능 -> 전진 + 방문한 좌표 1로 만들기
        if(arr[next_y][next_x]==0){
            now_x = next_x;
            now_y = next_y;
            arr[now_x][now_y] = 1;
        }
        // 3. 다음 위치 방문 불가능 -> 한칸 후진
        else{

        }






    }
}
