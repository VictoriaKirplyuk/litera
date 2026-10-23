package dev.victoria.litera.entity;

import jakarta.persistence.*;

import java.time.Year;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books")
public class BookEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "isbn", nullable = false, length = 20, unique = true)
    @Convert(converter = BookIsbnConverter.class)
    private String ISBN;

    @Column(name = "language_code", nullable = false, length = 2)
    private String languageCode;

    @Column(name = "published_at", nullable = false)
    private Year publishedAt;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @Column(name = "page_count")
    private Integer pageCount;

    @Column(name = "print_run")
    private Integer printRun;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private final Set<AuthorEntity> authors = new HashSet<>();

    public BookEntity(
                      String title,
                      String ISBN,
                      String languageCode,
                      Year publishedAt,
                      Integer ageLimit,
                      Integer pageCount,
                      Integer printRun) {
        this.title = title;
        this.ISBN = ISBN;
        this.languageCode = languageCode;
        this.publishedAt = publishedAt;
        this.ageLimit = ageLimit;
        this.pageCount = pageCount;
        this.printRun = printRun;
    }

    public BookEntity() {}

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

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Year getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Year publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPrintRun() {
        return printRun;
    }

    public void setPrintRun(Integer printRun) {
        this.printRun = printRun;
    }

    public void setAuthors(Set<AuthorEntity> authors) {
        this.authors.addAll(authors);
    }

    public Set<AuthorEntity> getAuthors() {
        return authors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(ISBN, that.ISBN) && Objects.equals(languageCode, that.languageCode) && Objects.equals(publishedAt, that.publishedAt) && Objects.equals(ageLimit, that.ageLimit) && Objects.equals(pageCount, that.pageCount) && Objects.equals(printRun, that.printRun);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ISBN, languageCode, publishedAt, ageLimit, pageCount, printRun);
    }
}
