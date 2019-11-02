package source.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import source.model.Author;
import source.model.Book;
import source.service.AuthorService;
import source.service.BookService;
import source.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    //-------------------Retrieve All Books--------------------------------------------------------

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> listAllBook() {
        List<Book> books = bookService.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    //-------------------Retrieve Single Book--------------------------------------------------------

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        System.out.println("Fetching Book with id " + id);
        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    //-------------------Create a Book--------------------------------------------------------

    @RequestMapping(value = "/books/", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody() Book book, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Book " + book.getName());

        Author author = new Author();
        author.setName(book.getAuthor_name());

        authorService.save(author);
        book.setAuthor(author);

        bookService.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Book --------------------------------------------------------

    @RequestMapping(value = "/books/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
        System.out.println("Updating Book " + id);

        Book book1 = bookService.findById(id);
        if (book1 == null) {
            System.out.println("Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        book1.setName(book.getName());
        book1.setAuthor(book.getAuthor());
        book1.setPublisher(book.getPublisher());
        book1.setId(book.getId());

        bookService.save(book1);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    //------------------- Delete a Book --------------------------------------------------------

    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Book with id " + id);

        Book book = bookService.findById(id);
        if (book == null) {
            System.out.println("Unable to delete. Book with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
