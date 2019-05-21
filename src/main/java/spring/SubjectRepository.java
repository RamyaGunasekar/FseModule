package spring;

import java.util.List;

public class SubjectRepository {

	private static BookDao bookDao;
	
	 public SubjectRepository() {
	        bookDao = new BookDao();
	    }
	 public void persist(Subject entity) {
	        bookDao.openCurrentSessionwithTransaction();
	        bookDao.persist(entity);
	        bookDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public void update(Subject entity) {
	        bookDao.openCurrentSessionwithTransaction();
	        bookDao.update(entity);
	        bookDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public Subject findById(int i) {
	        bookDao.openCurrentSession();
	        Subject subject = bookDao.findSubjectId(i);
	        bookDao.closeCurrentSession();
	        return subject;
	    }
	 
	    public void delete(int id) {
	        bookDao.openCurrentSessionwithTransaction();
	        Subject subject = bookDao.findSubjectId(id);
	        bookDao.delete(subject);
	        bookDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public List<Subject> findAll() {
	        bookDao.openCurrentSession();
	        List<Subject> subjects = bookDao.findAllSubjects();
	        bookDao.closeCurrentSession();
	        return subjects;
	    }
	 
	    public void deleteAll() {
	        bookDao.openCurrentSessionwithTransaction();
	        bookDao.deleteAll();
	        bookDao.closeCurrentSessionwithTransaction();
	    }
	 
	    public BookDao bookDao() {
	        return bookDao;
	    }

	    public List<Subject> orderAll() {
	        bookDao.openCurrentSession();
	        List<Subject> subjects = bookDao.orderAllSubjects();
	        bookDao.closeCurrentSession();
	        return subjects;
	    }
}
