package org.gvp.boookmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.gvp.boookmanager.support.validation.Year;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Book.DELETE, query = "DELETE FROM Book b WHERE b.id=:id AND b.user.id=:userId"),
        @NamedQuery(name = Book.GET_ALL, query = "SELECT b FROM Book b WHERE b.user.id=:userId ORDER BY b.author ASC")
})
@Table(name = "books")
@Indexed
@AnalyzerDef(name = "customAnalyzer",
        tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
                        @Parameter(name = "language", value = "English")
                })
        })
public class Book extends AbstractBaseEntity{

    public static final String DELETE = "Book.delete";
    public static final String GET_ALL = "Book.getAll";

    @Column(name = "title")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO, analyzer = @Analyzer(definition = "customAnalyzer"))
    @NotBlank(message = "Enter a title")
    private String title;

    @Column(name = "description")
    @NotBlank(message = "Enter a title")
    @Size(min = 1, max = 255, message = "Description must contain from 1 to 255 characters")
    private String description;

    @Column(name = "author")
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @NotBlank(message = "Enter a name of author")
    private String author;

    @Column(name = "isbn")
    @NotNull(message = "Enter ISBN")
    @Pattern(regexp = "^978[0-9]{10}$", message = "Enter correct ISBN. 13 digit starts with 978")
    private String isbn;

    @Column(name = "printYear")
    @Year()
    private Integer printYear;

    @Column(name = "readAlready")
    private boolean readAlready;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@NotNull(groups = View.Persist.class)
    @JsonIgnore
    private User user;

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPrintYear() {
        return printYear;
    }

    public void setPrintYear(Integer printYear) {
        this.printYear = printYear;
    }

    public boolean isReadAlready() {
        return readAlready;
    }

    public void setReadAlready(boolean readAlready) {
        this.readAlready = readAlready;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", printYear=" + printYear +
                ", readAlready=" + readAlready +
                '}';
    }
}
