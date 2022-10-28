import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (age != null) {
            if (age.getAsInt() < 0) {
                throw new IllegalArgumentException("Возраст указан не корректно");
            }
        }
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не указаны имя или фамилия");
        }
        return new Person(name, surname, age, address);
    }
}
