package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {
    /*
    이렇게 되면 클래스 레벨에 올라가기 때문에 딱 하나만 올라간다. static영역에 하나만 올라간다
    자기자신을 내부에 private로 가지고 있는데 static 으로 가지고있다.
     */

    //1. static 영역에 객체를 딱 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    /*
    자바가 뜰때 내부적으로 static영역의 new객체를 생성해서 instance에 참조를 넣어둔다.
    그러면 자기자신의 객체를 생성해서 instance 에만 들어가있다.
    */

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }

    //3. 생성자를 private로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    /*
    자바가 뜨면서 static 영역에 있는 instance 를 초기화 하면서 new연산자를 통해 객체의 참조값을 가진다.
    instance 에 있는 참조를 꺼낼수 있는 방법은 getInstance()밖에 없다.
    또한 SingletonService 클래스의 객체를 생성할 수 있는곳은 아무곳도 없다. (외부에서 new로 생성 불가능)
    */
}
