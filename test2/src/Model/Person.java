package Model;

public class Person {
    private String id;
    private String fullName;
    private String age;
    private Address address;
    private String birthday;

    public Person() {
    }

    public Person(String id, String fullName, String age, Address address, String birthday) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age='" + age + '\'' +
                ", address=" + address.toString() +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
