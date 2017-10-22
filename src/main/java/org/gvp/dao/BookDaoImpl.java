package org.gvp.dao;

import org.gvp.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);
    private SessionFactory sessionFactory;
    private final static String SEARCH_QUERY = "from Book where %s =:%s";

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(book);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        book.setReadAlready(false);
        logger.info("Book successfully update. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);

        if(book != null){
            session.delete(book);
        }

        logger.info("Book successfully removed. Book details: " + book);
    }


    @Override
    public void makeRead(Book book) {
        Session session = this.sessionFactory.getCurrentSession();

        if (!book.isReadAlready()) book.setReadAlready(!book.isReadAlready());
        session.update(book);

        logger.info("Book is read update. Book details: " + book);
    }

    @Override
    public Book getBookById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Book book = (Book) session.load(Book.class, id);
        logger.info("Book successfully loaded. Book details: " + book);

        return book;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        for(Book book : bookList){
            logger.info("Book list: " + book);
        }

        return bookList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> searchBooks(String searchParameter, Object searchText) {
        Session session = this.sessionFactory.getCurrentSession();
        return (List<Book>) session.createQuery(String.format(SEARCH_QUERY, searchParameter, searchParameter))
                .setParameter(searchParameter, searchText)
                .list();
    }
}
