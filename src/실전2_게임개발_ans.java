import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 실전2_게임개발_ans {
    public static int n,m,now_x,now_y,dir;

    public static int[][] arr = new int[50][50];
    public static int[][] d = new int[50][50];

    // 북, 동, 남, 서 방향 정의
    public static int dx[] = {-1,0,1,0};
    public static int dy[] = {0,1,0,-1};

    public static void turn_left(){
        dir -= 1;
        if (dir == -1)
            dir = 3;
    }

    public static void check(){
        d[now_y][now_x] = 1;
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
        for (int i = 0; i < n; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st3.nextToken());
            }
        }

        int cnt = 1;
        int turn_time = 0; // 4방향 전체 다 돌았는지 검사용
        check(); // 현재 위치 방문 표시
        while(true){
            // 1. 왼쪽 방향으로 돌기
            turn_left();
            int next_x = now_x + dx[dir];
            int next_y = now_y + dy[dir];
            // 2-1. 왼쪽 방향에 아직 가보지 않은 칸이 존재
            if(d[next_y][next_x]==0 && arr[next_y][next_x]==0){
                // 이동
                now_x = next_x;
                now_y = next_y;
                // 방문표시
                check();
                // 육지갯수 1 증가
                cnt++;
                turn_time = 0;
                continue;
            }
            // 2-2. 왼쪽 방향에 가보지 않은 칸 없음
            else{
                turn_time++;
            }

            // 4방향 전체 검사 완료시
            // 3. 네 방향 모두 이미 가본 칸이거나 바다로 된 칸인 경우
            if(turn_time==4){
                next_x = now_x - dx[dir];
                next_y = now_y - dy[dir];
                // 3-1. 뒤쪽 방향이 육지인 경우
                if(arr[next_y][next_x]==0){
                    now_x = next_x;
                    now_y = next_y;
                    turn_time = 0;
                }
                // 3-2. 뒤쪽 방향이 바다인 경우
                else break;
            }
        }
        System.out.println(cnt);

    }

}
