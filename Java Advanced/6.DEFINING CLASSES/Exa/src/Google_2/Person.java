package Google_2;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private Pokemons pokemons;
    private Children children;
    private Parents parents;

    public Person(String name) {
        this.name = name;
        this.pokemons = new Pokemons();
        this.children = new Children();
        this.parents = new Parents();
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Pokemons getPokemons() {
        return pokemons;
    }

    public Children getChildren() {
        return children;
    }

    public Parents getParents() {
        return parents;
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
        for (String p : pokemons.getPokemons()
        ) {
            print.append(p);
            print.append(System.lineSeparator());
        }
        print.append("Parents:");
        print.append(System.lineSeparator());

        for (String p : parents.getParents()
        ) {
            print.append(p);
            print.append(System.lineSeparator());
        }


        print.append("Children:");
        print.append(System.lineSeparator());

        for (String p : children.getChildren()
        ) {
            print.append(p);
            print.append(System.lineSeparator());
        }

        return print.toString();
    }

}
