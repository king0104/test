import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {

    private int time;
    private char direction;
    // 생성자
    public Node(int time,char direction){
        this.time = time;
        this.direction = direction;
    }

    public int getTime() {
        return this.time;
    }

    public char getDirection(){
        return this.direction;
    }

}

class Position{

    private int x;
    private int y;
    // 생성자
    public Position(int x, int y){
        this.x=x;
        this.y=y;
    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class 문제5_뱀 {

    public static int n,k,l;
    public static int[][] arr = new int[101][101];
    // info 라는 arraylist
    // Node라는 객체를 담는 공간.
        // Node 객체
        // 1. 특정 노드(위치)에서의 시간과 방향을 담을 수 있는 객체
        // 2. 그 시간과 방향을 리턴할 수 있는 메서드 존재
    public static ArrayList<Node> info = new ArrayList<>();

    // 오른쪽 보고 있는 것 기준이니까 첫번째가 동. / 동 남 서 북
    public static int dx[] = {0,1,0,-1};
    public static int dy[] = {1,0,-1,0};

    public static int turn(int direction, char c){
        if(c=='L') direction = (direction==0)? 3 : direction-1;
        else direction = (direction + 1) % 4;
        return direction;
    }

    public static int simulate() {
        int x=1, y=1; // 뱀의 머리 위치(테두리가 벽이라서 시작이 1,1)
        arr[x][y] = 2; // 뱀이 존재하는 위치는 2로 표시
        int direction = 0; // 처음에는 동쪽을 보고 있음
        int time = 0; // 시작한 뒤 지난 '초' 시간
        int index = 0; // 다음에 회전할 정보
        // 뱀이 차지하고 있는 위치 정보(꼬리가 앞쪽)
        Queue<Position> q = new LinkedList<>();
            // Position이라는 직접 만든 객체(클래스)를 넣는 큐
        q.offer(new Position(x,y));

        while(true){
            // 0. 해당 방향으로 한칸 이동
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            // 1. 맵 범위 안에 있고, 뱀의 몸통이 없는 위치라면,
            if(1<=nx && nx<= n && 1<=ny && ny <= n && arr[nx][ny] != 2){
                // 1-1. 사과가 없다면, 이동 후에 꼬리 제거
                if(arr[nx][ny] == 0){
                    arr[nx][ny] = 2; // _1. 이동한 위치 표시
                    q.offer(new Position(nx, ny)); // _1-1. 이동한 위치 큐에 넣기
                    Position prev = q.poll(); // _2. 이전 위치 저장
                    arr[prev.getX()][prev.getY()] = 0; // _2-1. 이전 위치 = 0 (아무것도 없는 상태로 초기화 시켜주기)
                }
                // 1-2. 사과가 있다면, 이동 후에 꼬리 그대로
                if(arr[nx][ny] == 1){
                    arr[nx][ny] = 2; // _1. 이동한 위치 표시
                    q.offer(new Position(nx,ny)); // _1-1. 이동한 위치 큐에 넣기
                }
            }
            // 2. 맵 범위 밖이거나 몸통과 부딪힘
            else{
                time += 1;
                break;
            }
            // 3. 다음 위치가 뱀의 머리가 된다.
            x = nx;
            y = ny;
            time += 1;
            // 입력받은 회전 시간과 같으면 회전.
            // (근데 왜 index<1 이 되어야 하나..?)
            if(index < 1 && time == info.get(index).getTime()){
                direction = turn(direction, info.get(index).getDirection());
                index += 1;
            }
        }
        return time;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        // 1. 사과 위치 표시
        for(int i=0;i<k;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }
        // 2. '몇 초 뒤', '어디로 회전할지' 정보 입력
        for(int i=0;i<l;i++){
            int x = sc.nextInt();
            char c = sc.next().charAt(0);
            info.add(new Node(x,c));
        }
        System.out.println(simulate());
    }
}
