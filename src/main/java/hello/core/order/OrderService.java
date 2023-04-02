package hello.core.order;

public interface OrderService {
    Order create(Long memberId, String itemName, int itemPrice); //최종결과 반환
}
