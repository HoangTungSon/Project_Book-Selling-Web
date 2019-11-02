package source.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private Set<Book> bookAuthors;

    public Author() {
    }

    public Author(String name, Set<Book> bookAuthors) {
        this.name = name;
        this.bookAuthors = bookAuthors;
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

    public Set<Book> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(Set<Book> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }
}
