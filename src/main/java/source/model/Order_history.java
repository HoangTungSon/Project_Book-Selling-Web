package source.model;

import javax.persistence.*;

@Entity
@Table(name = "order_history")
public class Order_history {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer book_quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order_history() {
    }

    public Order_history(Integer book_quantity, User user) {
        this.book_quantity = book_quantity;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBook_quantity() {
        return book_quantity;
    }

    public void setBook_quantity(Integer book_quantity) {
        this.book_quantity = book_quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
