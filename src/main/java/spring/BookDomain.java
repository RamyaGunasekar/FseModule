package spring;

import java.util.ArrayList;
import java.util.List;

import org.apache.sling.commons.json.JSONException;
import org.springframework.stereotype.Component;

@Component
public class BookDomain implements IBookDomain{

	public BookDTO getBookById(int id) throws JSONException {
		BookRepository bookService = new BookRepository();
		Book book1 =new Book();
		book1=bookService.findById(id);
		BookDTO bookDTO=new BookDTO();
		bookDTO.setBookId(book1.getBookId());
		bookDTO.setPrice(book1.getPrice());
		bookDTO.setTitle(book1.getTitle());
		bookDTO.setVolume(book1.getVolume());
		bookDTO.setPublishDate(book1.getPublishDate());
		bookDTO.setMessage("Book Retrieved successfully");
		return bookDTO;
	}

	public List<BookDTO> getBookList() throws JSONException {
		BookRepository bookService = new BookRepository();
		List<BookDTO> list=new ArrayList<BookDTO>();
		List<Book> books1 = bookService.findAll();
		System.out.println("Books added are :");
		for (Book book1 : books1) {
			BookDTO bookDTO=new BookDTO();
			bookDTO.setBookId(book1.getBookId());
			bookDTO.setPrice(book1.getPrice());
			bookDTO.setTitle(book1.getTitle());
			bookDTO.setVolume(book1.getVolume());
			bookDTO.setPublishDate(book1.getPublishDate());
			list.add(bookDTO);
		}
		return list;
	}

	public BookDTO createBook(BookDTO bookDTO) throws JSONException {
		BookRepository bookService = new BookRepository();
		Book book1 =new Book();
		book1.setBookId(bookDTO.getBookId());
		book1.setPrice(bookDTO.getPrice());
		book1.setTitle(bookDTO.getTitle());
		book1.setVolume(bookDTO.getVolume());
		book1.setPublishDate(bookDTO.getPublishDate());
		bookService.persist(book1);
		bookDTO.setMessage("Create successful");
		return bookDTO;
	}

	public BookDTO modifyBook(BookDTO bookDTO) throws JSONException {
		
		BookRepository bookService = new BookRepository();
		Book book1 =new Book();
		book1=bookService.findById(bookDTO.getBookId());
		book1.setPrice(bookDTO.getPrice());
		book1.setTitle(bookDTO.getTitle());
		book1.setVolume(bookDTO.getVolume());
		book1.setPublishDate(bookDTO.getPublishDate());
		bookService.update(book1);
		book1=bookService.findById(bookDTO.getBookId());
		bookDTO.setBookId(book1.getBookId());
		bookDTO.setPrice(book1.getPrice());
		bookDTO.setTitle(book1.getTitle());
		bookDTO.setVolume(book1.getVolume());
		bookDTO.setPublishDate(book1.getPublishDate());
		bookDTO.setMessage("Modify successful");
		return bookDTO;
	}

	public String deleteBook(int id) throws JSONException {
		BookRepository bookService = new BookRepository();
		bookService.delete(id);
		String msg="Delete successful";
		return msg;
	}

}
