package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) //의존관계가 없으면 호출자체가 안된다.
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) { //호출은 되지만 Null값이 들어온다.
            System.out.println("noBean2 = " + noBean2);
        }
        
        @Autowired
        public void setNoBean3(Optional<Member> noBean3) { //스프링 빈이 없으면 Optional.empty 출력
            System.out.println("noBean3 = " + noBean3);
        } 
    }

}
