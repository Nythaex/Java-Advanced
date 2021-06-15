package Book;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Library library=new Library(new Book("asf",21,"safafs","asfas"),
                new Book("iva",2123,"s12fs","s"),
                new Book("nikf",-1," ",":D"));


        for (Book book : library) {
            System.out.println(book.toString());
        }

    }
}
