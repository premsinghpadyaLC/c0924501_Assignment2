package com.assignment;

public class Person {
    
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;

    private Person(PersonBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.gender = builder.gender;
        
        // Validate the required fields
        if (id == null || firstName == null || lastName == null || age < 0 || gender == null) {
            throw new IllegalArgumentException("Invalid data");
        }
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // Builder class
    public static class PersonBuilder {
        private String id;
        private String firstName;
        private String lastName;
        private int age;
        private String gender;

        public PersonBuilder id(String id) {
            this.id = id;
            return this;
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}
