package spring;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "subject")
public class Subject {


	   @Id
	    @Column(name = "subjectId")
	    private int subjectId;
	     
	    @Column(name = "subtitle")
	    private String subtitle;
	     
	    @Column(name= "durationInHours")
	    private int durationInHours;
	    
	    @Column(name= "bookId")
	    private int bookId;
	    
	    public Subject() {
	    }

	    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	    private Set<Book> bookSet;
	   
		public Subject(int subjectId, String subtitle, int durationInHours, int bookId) {
			super();
			this.subjectId = subjectId;
			this.subtitle = subtitle;
			this.durationInHours = durationInHours;
			this.bookId = bookId;
		}

		public Set<Book> getBookSet() {
			return bookSet;
		}

		public void setBookSet(Set<Book> bookSet) {
			this.bookSet = bookSet;
		}

		public int getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}

		public String getSubtitle() {
			return subtitle;
		}

		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}

		public int getDurationInHours() {
			return durationInHours;
		}

		public void setDurationInHours(int durationInHours) {
			this.durationInHours = durationInHours;
		}

		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		@Override
		public String toString() {
			return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours
					+ ", bookId=" + bookId + ", bookSet=" + bookSet + "]";
		}


		
	    
}
