public class test {
    public static void main(String[] args) {
        char x = '0';
        char y = 'a';
        // 아니 자바 형변환은 int(x) 이런식으로 강제 형변환이 불가능함???

        // 1. 자동 타입 변환
        // 1. 큰 크기의 타입에 작은 크기 타입의 변수 저장 시에 발생
        // 2. 다른 타입의 피연산자 -> 크기가 큰 타입으로 자동 형변환 후 연산
        //
        int xx = '0';
        int yy = y;

        // 2. 강제 형변환
        // 1. 작은 크기 타입 = (작은 크기 타입)큰 크기 타입
        // 무조건 작은 크기 타입으로만 강제 형변환이 가능하다.

        System.out.println(xx);
        System.out.println(yy);
    }
}
