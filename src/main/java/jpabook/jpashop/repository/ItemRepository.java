package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Slf4j //Logger
public class ItemRepository {

    @PersistenceContext
    EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
        }else{
            Item merge = em.merge(item);
            //merge 영속상태, 파라미터 item 준영속 상태
            //값이 없으면 null로 변경할 위험을 가지고 있다.
        }
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }

}
