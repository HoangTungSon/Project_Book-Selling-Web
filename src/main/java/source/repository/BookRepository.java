package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Book;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    List<Book> findAllByName (String name);
}
