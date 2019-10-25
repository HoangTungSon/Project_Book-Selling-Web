package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Book;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Iterable<Book> findAllByName (String name);
}
