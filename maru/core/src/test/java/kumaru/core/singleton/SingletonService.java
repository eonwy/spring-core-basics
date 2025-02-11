package kumaru.core.singleton;

public class SingletonService {
    //    static으로 하나의 객체 인스턴스를 미리 만들어둠
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

//    생성자를 private으로 선언해 외부에서 new 예약어로 여러 객체 인스턴스를 만들지 못하게 함
    private SingletonService() {
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
