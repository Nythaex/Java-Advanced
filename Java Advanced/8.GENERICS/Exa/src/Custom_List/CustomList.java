package Custom_List;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void Add(T element) {
        this.list.add(element);
    }

    public void Remove(int index) {
        this.list.remove(index);
    }

    public boolean Contains(T element) {
        return this.list.contains(element);
    }

    public void Swap(int firstIndex, int secondIndex) {
        Collections.swap(this.list, firstIndex, secondIndex);
    }

    public int Greater(T element) {
        int count = 0;
        for (T e : list
        ) {
            if (element.compareTo(e) < 0) {
                count++;
            }
        }
        return count;
    }

    public T Max() {
        T max = list.get(0);
        for (int i = 0; i < this.list.size() - 1; i++) {
            if (list.get(i + 1).compareTo(list.get(i)) > 0) {
                max = list.get(i + 1);
            }
        }
        return max;
    }

    public T Min() {
        T min = list.get(0);
        for (int i = 0; i < this.list.size() - 1; i++) {
            if (list.get(i + 1).compareTo(list.get(i)) < 0) {
                min = list.get(i + 1);
            }
        }
        return min;
    }

    public void Print() {
        for (T n : list
        ) {
            System.out.println(n);
        }
        ;
    }

    public void Sort() {
        Collections.sort(list);
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            public boolean hasNext() {
                return index < list.size();

            }

            @Override
            public T next() {
                T print = list.get(this.index);
                this.index++;
                return print;
            }
        };
    }
}
