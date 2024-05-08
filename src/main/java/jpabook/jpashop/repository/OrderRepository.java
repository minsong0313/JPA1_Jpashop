package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    @PersistenceContext
    private final EntityManager em;

    //주문
    public void save(Order order) {
        em.persist(order);
    }

    //단건 조회
    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    //public List<Order> findAll(OrderSearch orderSearch) {}

}
