package spring;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
public class BookDao implements BookDaoInterface<Book, Integer> {
	 
    private Session currentSession;
     
    private Transaction currentTransaction;
 
    public BookDao() {
    }
 
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }
     
    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }
 
    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(Book entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Book entity) {
        getCurrentSession().update(entity);
    }
 
    public Book findById(Integer i) {
        Book book = (Book) getCurrentSession().get(Book.class, i);
        return book; 
    }
 
    public void delete(Book entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Book> findAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book").list();
        return books;
    }
 
    public void deleteAll() {
        List<Book> entityList = findAll();
        for (Book entity : entityList) {
            delete(entity);
        }
    }

    public void persist(Subject entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Subject entity) {
        getCurrentSession().update(entity);
    }
 
    public Subject findSubjectId(Integer i) {
    	Subject subject = (Subject) getCurrentSession().get(Subject.class, i);
        return subject; 
    }
 
    public void delete(Subject entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Subject> findAllSubjects() {
        List<Subject> subjectList = (List<Subject>) getCurrentSession().createQuery("from Subject").list();
        return subjectList;
    }
 
    public void deleteAllSubjects() {
        List<Subject> entityList = findAllSubjects();
        for (Subject entity : entityList) {
            delete(entity);
        }
	}

    @SuppressWarnings("unchecked")
    public List<Subject> orderAllSubjects() {
        List<Subject> subjectList = (List<Subject>) getCurrentSession().createQuery("from Subject order by subtitle").list();
        return subjectList;
    }
    
    @SuppressWarnings("unchecked")
    public List<Book> orderAll() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book order by title").list();
        return books;
    }
    
    @SuppressWarnings("unchecked")
    public List<Book> orderByDate() {
        List<Book> books = (List<Book>) getCurrentSession().createQuery("from Book order by publishDate").list();
        return books;
    }
}
