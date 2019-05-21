package spring;

import java.util.List;

import org.apache.sling.commons.json.JSONException;

public interface IBookDomain {

	public BookDTO getBookById(int id) throws JSONException;
	
	public List<BookDTO> getBookList() throws JSONException;
	
	public BookDTO createBook( BookDTO bookDTO) throws JSONException;
	
	public BookDTO modifyBook(BookDTO bookDTO) throws JSONException;
	
	public String deleteBook( int id) throws JSONException;
}
