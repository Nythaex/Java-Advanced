package Say_Hello_Extended;

public class Bulgarian extends BasePerson {
    private String name;

    public Bulgarian(String name) {
       super(name);
    }

    @Override
    public String sayHello(){
        return "здравей";
    }
}
