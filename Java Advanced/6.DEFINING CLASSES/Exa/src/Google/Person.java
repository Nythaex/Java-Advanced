package Google;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Person {
    private Company company;
    private Car car;
    private Pokemons pokemons;
    private Children children;
    private Parents parents;

    public void addInfo(String[] tokens){

    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public String toSting() {
        StringBuilder print = new StringBuilder();

        print.append("Company:");
        print.append(System.lineSeparator());
        if (company != null) {
            print.append(company.toString());
            print.append(System.lineSeparator());
        }


        print.append("Car:");
        print.append(System.lineSeparator());
        if (car != null) {
            print.append(car.getCar());
            print.append(System.lineSeparator());
        }
        print.append("Pokemon:");
        print.append(System.lineSeparator());
        if (pokemons!=null) {

            for (String p: pokemons.getPokemons()
                 ) {
                print.append(p);
                print.append(System.lineSeparator());
            }
        }
        print.append("Parents:");
        print.append(System.lineSeparator());
        if (parents!= null) {
            for (String p: parents.getParents()
            ) {
                print.append(p);
                print.append(System.lineSeparator());
            }
        }

        print.append("Children:");
        print.append(System.lineSeparator());
        if (children!=null) {
            for (String p: children.getChildren()
            ) {
                print.append(p);
                print.append(System.lineSeparator());
            }
        }
        return print.toString();
    }

}
