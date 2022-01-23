import java.util.Objects;

public class Book {

    String bookName;
    int pages;
    int rating;

    public Book(String bookName, int pages, int rating) {
        this.bookName = bookName;
        this.pages = pages;
        this.rating = rating;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getRating() {
        return rating;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", pages=" + pages +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getPages() == book.getPages() && getRating() == book.getRating() && Objects.equals(getBookName(), book.getBookName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookName(), getPages(), getRating());
    }
}
