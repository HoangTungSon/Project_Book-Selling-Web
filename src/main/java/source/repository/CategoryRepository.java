package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Category;

import java.util.List;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long> {

    List<Category> findAllByName (String name);
}
