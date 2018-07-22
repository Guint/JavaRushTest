package org.gvp.boookmanager.dao;

import org.gvp.boookmanager.model.Book;
import org.gvp.boookmanager.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @PersistenceContext
    private EntityManager em;


    @Override
    public Book save(Book book, long userId) {
        logger.info("Save" + book);
        if(book.getId() != null && get(book.getId(), userId) == null) {
            return null;
        }
        book.setUser(em.getReference(User.class, userId));
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }


    @Override
    public boolean delete(long id, long userId) {
        /*Book book = em.getReference(Book.class, id);
        em.remove(book);
        */

        return em.createNamedQuery(Book.DELETE)
                .setParameter("id", id)
                .setParameter("userId", userId)
                .executeUpdate() != 0;
    }


    @Override
    public Book get(long id, long userId) {
        Book book = em.find(Book.class, id);
        return book != null && book.getUser().getId() == userId ? book : null;
    }

    @Override
    public List<Book> getAll(long userId) {
        logger.info("Get all");
        return em.createNamedQuery(Book.GET_ALL, Book.class).setParameter("userId", userId).getResultList();
    }

}
