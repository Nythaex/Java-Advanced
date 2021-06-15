package Book;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String...values) {
        setYear(year);
        setTitle(title);
        setAuthors(Arrays.asList(values.clone()));
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public int compareTo(Book o) {
        if (this.title.compareTo(o.title)==0){
            return Integer.compare(this.year,o.year);
        }
        return this.title.compareTo(o.title);
    }
}
