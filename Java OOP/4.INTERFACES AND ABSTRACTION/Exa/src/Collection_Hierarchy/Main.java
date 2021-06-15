package Collection_Hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AddCollection addOne=new AddCollection();
        AddRemoveCollection addRemoveOne=new AddRemoveCollection();
        MyListImpl myList=new MyListImpl();

        String[] words=reader.readLine().split("\\s+");
        int removeCount=Integer.parseInt(reader.readLine());


        System.out.println(AddToCollection(addOne,addRemoveOne,myList, words));
        System.out.println(RemoveFromCollection(addRemoveOne,myList, words,removeCount));


    }
    private static String RemoveFromCollection(AddRemoveCollection addRemoveOne, MyListImpl myList, String[] words,int count) {
        StringBuilder a = new StringBuilder();
        StringBuilder aR = new StringBuilder();
        for (int i = 0; i <= count-1; i++) {
            a.append(addRemoveOne.remove());
            a.append(" ");
            aR.append(myList.remove());
            aR.append(" ");

        }a.append(System.lineSeparator()).append(aR);

        return a.toString().trim();
    }

    private static String AddToCollection(AddCollection collection,AddRemoveCollection addRemoveCollection,MyListImpl myList, String[] words) {
        StringBuilder a = new StringBuilder();
        StringBuilder aR = new StringBuilder();
        StringBuilder l = new StringBuilder();
        for (int i = 0; i <= words.length - 1; i++) {
            a.append(collection.add(words[i]));
            a.append(" ");
            aR.append(addRemoveCollection.add(words[i]));
            aR.append(" ");
            l.append(myList.add(words[i]));
            l.append(" ");
        }a.append(System.lineSeparator()).append(aR).append(System.lineSeparator()).append(l);

        return a.toString().trim();
    }
}
