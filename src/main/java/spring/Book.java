package spring;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book")
public class Book {

	   @Id
	    @Column(name = "bookId")
	    private int bookId;
	     
	    @Column(name = "title")
	    private String title;
	     
	    @Column(name= "price")
	    private BigDecimal price;
	    
	    @Column(name= "volume")
	    private int volume;
	    
	    @Temporal(TemporalType.DATE)
	    @Column(name= "publishDate")
	    private  Date publishDate;
	     
	    public Book() {
	    }

		public Book(int bookId, String title, BigDecimal price, int volume, Date publishDate) {
			super();
			this.bookId = bookId;
			this.title = title;
			this.price = price;
			this.volume = volume;
			this.publishDate = publishDate;
		}

		
		public int getBookId() {
			return bookId;
		}

		public void setBookId(int bookId) {
			this.bookId = bookId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public int getVolume() {
			return volume;
		}

		public void setVolume(int volume) {
			this.volume = volume;
		}

		public Date getPublishDate() {
			return publishDate;
		}

		public void setPublishDate(Date publishDate) {
			this.publishDate = publishDate;
		}

		@Override
		public String toString() {
			return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
					+ ", publishDate=" + publishDate + "]";
		}

		
	    
	    
}
