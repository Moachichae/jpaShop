package jpabook.jpashop.repository.order.simpleQuery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {
    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() { // 재사용 되기가 희박하다. 넘어오는 데이터가 적다.
        return em.createQuery(                         // api스펙에 의존하게 되므로 논리적인 의존계층이 깨져있다.
                        "select new jpabook.jpashop.repository.order.simpleQuery.OrderSimpleQueryDto" +
                                "(o.id, m.name, o.orderDate, o.status, d.address)" +
                                " from Order o" +
                                " join o.member m" +
                                " join o.delivery d", OrderSimpleQueryDto.class)
                .getResultList();
    }
}
