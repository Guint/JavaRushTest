package org.gvp.boookmanager.dao;


import org.apache.lucene.search.Query;
import org.gvp.boookmanager.model.Book;
import org.gvp.boookmanager.support.search.SearchField;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @PersistenceContext
    private EntityManager em;


    @Override
    public Book save(Book book) {
        logger.info("Save" + book);
        if (book.getId() == null) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }


    @Override
    public boolean delete(Long id) {
        /*Book book = em.getReference(Book.class, id);
        em.remove(book);
        */

        return em.createNamedQuery(Book.DELETE)
                .setParameter("id", id)
                .executeUpdate() != 0;
    }


    @Override
    public Book get(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
        logger.info("Get all");
        return em.createNamedQuery(Book.GET_ALL, Book.class).getResultList();
    }


    @Override
    public List<Book> search(String searchText) {
        if(searchText == null || searchText.isEmpty()) return Collections.emptyList();
        FullTextEntityManager fem = Search.getFullTextEntityManager(em);
        try {
            fem.createIndexer().startAndWait();
        } catch (InterruptedException e) {
            throw new RuntimeException("Indexing db error");
        }
        QueryBuilder qb = fem.getSearchFactory()
                .buildQueryBuilder().forEntity(Book.class).get();
        Query query = qb.keyword()
                .onFields(SearchField.TITLE.toString(), SearchField.AUTHOR.toString())
                .matching(searchText)
                .createQuery();
        javax.persistence.Query pq = fem.createFullTextQuery(query, Book.class);
        return pq.getResultList();


    }

}
