package spring;

import java.util.List;

public class BookRepository {

	private static BookDao bookDao;
	 
    public BookRepository() {
        bookDao = new BookDao();
    }
 
    public void persist(Book entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.persist(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Book entity) {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.update(entity);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public Book findById(int i) {
        bookDao.openCurrentSession();
        Book book = bookDao.findById(i);
        bookDao.closeCurrentSession();
        return book;
    }
 
    public void delete(int id) {
        bookDao.openCurrentSessionwithTransaction();
        Book book = bookDao.findById(id);
        bookDao.delete(book);
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public List<Book> findAll() {
        bookDao.openCurrentSession();
        List<Book> books = bookDao.findAll();
        bookDao.closeCurrentSession();
        return books;
    }
 
    public void deleteAll() {
        bookDao.openCurrentSessionwithTransaction();
        bookDao.deleteAll();
        bookDao.closeCurrentSessionwithTransaction();
    }
 
    public BookDao bookDao() {
        return bookDao;
    }

    public List<Book> orderAll() {
        bookDao.openCurrentSession();
        List<Book> books = bookDao.orderAll();
        bookDao.closeCurrentSession();
        return books;
    }
    
    public List<Book> orderByDate() {
        bookDao.openCurrentSession();
        List<Book> books = bookDao.orderByDate();
        bookDao.closeCurrentSession();
        return books;
    }
}
