package Clone.Modules;

public class Address {
    private String name;
    private int age;
    private String sex;

    public static class Builder{
        private String name;
        private int age;
        private String sex;

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(int age) {
            this.age = age;
            return this;
        }

        public Builder withSex(String sex) {
            this.sex = sex;
            return this;
        }
        public static Builder getBuilder() {
            return  new Builder();
        }
        public Address build() {
            return new Address().setName(this.name).setAge(this.age).setSex(this.sex);
        }

    }

    public String getName() {
        return name;
    }

    public Address setName(String name) {
        this.name = name;
        return  this;
    }

    public int getAge() {
        return age;

    }

    public Address setAge(int age) {
        this.age = age;
        return  this;
    }

    public String getSex() {
        return sex;
    }

    public Address setSex(String sex) {
        this.sex = sex;
        return  this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
