import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age;
    protected String address;

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        if (age != null) {
            return true;
        }
        return false;
    }

    public boolean hasAddress() {
        if (this.address == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        if (hasAge()) {
            throw new IllegalStateException("Возраст уже задан");
        }
        if (age < 0) {
            throw new IllegalStateException("Возраст не корректный");
        }
        this.age = OptionalInt.of(age);
    }

    public void happyBirthday() {
        if (!hasAge()) {
            throw new IllegalStateException("Возраст не установлен");
        }
        this.age = OptionalInt.of(this.age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(0);
        child.setAddress(this.address);
        return child;
    }

    @Override
    public String toString() {
        String string = name + " " + surname + " ";
        if (this.hasAge()) {
            string += "возраст " + age.getAsInt() + " ";
        }
        if (this.hasAddress()) {
            string += "из города " + address;
        }
        return string;
    }
}
