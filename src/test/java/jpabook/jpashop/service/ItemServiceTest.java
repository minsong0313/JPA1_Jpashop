package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

    @Autowired EntityManager em;
    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;

    @Test
    public void 상품등록() throws Exception {
        // given
        Book book = new Book();
        book.setName("book1");

        System.out.println("book = " + book.getId()); //em.persis 하기 전이라 null

        // when
        Long itemId = itemService.saveItem(book);
        System.out.println("book = " + book.getId()); //위 코드에 의해서 persis 되어 id가 부여됨, 1출력
        System.out.println("itemId = " + itemId);

        // then
        assertEquals(book, itemRepository.findOne(itemId));
    }

    @Test
    public void 상품조회() throws Exception {
        // given
        Book book = new Book();
        book.setName("book1");
        em.persist(book);

        System.out.println("book = " + book.getId());

        // when
        Item findBook = itemService.findOne(book.getId());
        System.out.println("findBook = " + findBook.getId());
        System.out.println("book = " + book.getId());

        // then
        assertEquals(book, itemRepository.findOne(findBook.getId()));
    }

}