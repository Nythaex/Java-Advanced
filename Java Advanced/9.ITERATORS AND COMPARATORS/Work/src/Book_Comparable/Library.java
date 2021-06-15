package Book_Comparable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private class libraryIterator implements Iterator<Book> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < listOfBooks.size();
        }

        @Override
        public Book next() {
            return listOfBooks.get(index++);
        }
    }

    private List<Book> listOfBooks;

    public Library(Book... values) {
        this.listOfBooks = Arrays.asList(values);
    }

    public libraryIterator iterator() {
        return new libraryIterator();
    }

}
