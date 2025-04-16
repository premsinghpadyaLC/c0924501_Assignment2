package com.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void testValidPersonCreation1() {
        Person person = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        assertEquals("P001", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreation2() {
        Person person = new Person.PersonBuilder()
                .id("P002")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(35)
                .gender("Male")
                .build();

        assertEquals("P002", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(35, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreationWithDifferentAge() {
        Person person = new Person.PersonBuilder()
                .id("P003")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(28)
                .gender("Male")
                .build();

        assertEquals("P003", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(28, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreationWithLargeAge() {
        Person person = new Person.PersonBuilder()
                .id("P004")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(100)
                .gender("Male")
                .build();

        assertEquals("P004", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(100, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreationWithDifferentGender() {
        Person person = new Person.PersonBuilder()
                .id("P005")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Non-binary")
                .build();

        assertEquals("P005", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Non-binary", person.getGender());
    }

    @Test
    void testValidPersonCreationWithNullFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id("P006")
                .firstName(null) // First name cannot be null
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build());
    }

    @Test
    void testValidPersonCreationWithNullLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id("P007")
                .firstName("Premsingh")
                .lastName(null) // Last name cannot be null
                .age(30)
                .gender("Male")
                .build());
    }

    @Test
    void testValidPersonCreationWithNullGender() {
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id("P008")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender(null) // Gender cannot be null
                .build());
    }

    @Test
    void testValidPersonCreationWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id(null)  // ID cannot be null
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidPersonCreationWithNegativeAge() {
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id("P009")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(-5)  // Age cannot be negative
                .gender("Male")
                .build());
    }

    @Test
    void testValidPersonCreationWithSpecialCharacterId() {
        Person person = new Person.PersonBuilder()
                .id("P@123")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        assertEquals("P@123", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreationWithUniqueId() {
        Person person = new Person.PersonBuilder()
                .id("P015")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        assertEquals("P015", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreationWithOlderAge() {
        Person person = new Person.PersonBuilder()
                .id("P016")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(60)
                .gender("Male")
                .build();

        assertEquals("P016", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(60, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testValidPersonCreationWithNonStandardId() {
        Person person = new Person.PersonBuilder()
                .id("P018")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        assertEquals("P018", person.getId());
        assertEquals("Premsingh", person.getFirstName());
        assertEquals("Padya", person.getLastName());
        assertEquals(30, person.getAge());
        assertEquals("Male", person.getGender());
    }

}
