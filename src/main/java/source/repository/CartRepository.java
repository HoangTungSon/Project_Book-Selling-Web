package source.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import source.model.Cart;

import java.util.List;

public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {


}
