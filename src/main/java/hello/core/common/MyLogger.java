package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String requestURl;

    public void setRequestURl(String requestURl) {
        this.requestURl = requestURl;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURl + "] " + message);
    }

    //고객 요청이 들어올때 최초 호출을 하기위해 스프링에 달라고 할때 호출된다.
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString(); //전세계에서 유니크한 아이디가 생성 (겹칠 확율이 거의 없는수준)
        System.out.println("[" + uuid + "] request scope bean create : " + this);
    }

    //request scope는 소멸이 된다.
    //스프링 관리후 서버에서 빠져나갈때 소멸
    @PreDestroy 
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close : " + this);
    }
}

