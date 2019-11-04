package source.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String author_name;

    private String publisher;

    private Long quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "category_like",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categorySet;

    public Book() {
    }

    public Book(String name, Author author, String publisher) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public Book(String name, Author author, String publisher, Set<Category> categorySet) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.categorySet = categorySet;
    }

    public Book(String name, String author_name, String publisher, Author author, Set<Category> categorySet) {
        this.name = name;
        this.author_name = author_name;
        this.publisher = publisher;
        this.author = author;
        this.categorySet = categorySet;
    }

    public Book(String name, String author_name, String publisher, Long quantity, Author author, Set<Category> categorySet) {
        this.name = name;
        this.author_name = author_name;
        this.publisher = publisher;
        this.quantity = quantity;
        this.author = author;
        this.categorySet = categorySet;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, name='%s', author='%s', publisher='%s']", id, name, author, publisher);
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
