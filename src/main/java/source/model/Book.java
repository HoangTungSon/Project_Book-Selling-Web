package source.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String publisher;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany
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

}
