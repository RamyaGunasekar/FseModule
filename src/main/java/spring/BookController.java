package spring;

import java.util.List;

import org.apache.sling.commons.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@Controller
public class BookController {
	
	@Autowired
	private IBookDomain bookDomain;

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	@ResponseBody
public BookDTO getBookById(@PathVariable int id) throws JSONException {

		BookDTO bookDTO=bookDomain.getBookById(id);
	return bookDTO;

}
	
	@RequestMapping(value = "/bookList",method = RequestMethod.GET)
	@ResponseBody
public List<BookDTO> getBookList() throws JSONException {

		List<BookDTO> bookDTOList=bookDomain.getBookList();
	return bookDTOList;

}

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
public BookDTO createBook(@RequestBody BookDTO bookDTO) throws JSONException {
		
		BookDTO book=bookDomain.createBook(bookDTO);
	return book;
}

	@RequestMapping(value = "/modify", method = RequestMethod.PUT)
	@ResponseBody
public BookDTO modifyBook(@RequestBody BookDTO bookDTO) throws JSONException {

		BookDTO book=bookDomain.modifyBook(bookDTO);
	return book;

}
	

	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
	@ResponseBody
public String deleteBook(@PathVariable int id) throws JSONException {

		String message=bookDomain.deleteBook(id);
	return message;

}
}
