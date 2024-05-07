package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    //회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    //단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    //전체 조회 - 리스트
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //jpql
                .getResultList();
    }

    //이름으로 조회
   public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class) //jpql
                .setParameter("name", name)
                .getResultList();
    }

}
