package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Author;

import java.util.List;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    List<Author> findAllByName (String name);
}
