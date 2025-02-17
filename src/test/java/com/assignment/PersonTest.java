package com.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    
    @Test
    void testValidPersonCreation() {
        // Creating a Person object using the builder pattern
        Person person = new Person.PersonBuilder()
                .id("P001")
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .build();

        // Asserting that the values set using builder are correctly assigned
        assertEquals("P001", person.getId());
        assertEquals("John", person.getFirstName());
        assertEquals("Doe", person.getLastName());
        assertEquals(25, person.getAge());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testInvalidPersonCreation() {
        // Testing for IllegalArgumentException when an invalid person is created
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id(null)  // id cannot be null
                .firstName("John")
                .lastName("Doe")
                .age(25)
                .gender("Male")
                .build());
    }

    @Test
    void testInvalidPersonCreationWithNegativeAge() {
        // Testing for IllegalArgumentException when an invalid age is provided
        assertThrows(IllegalArgumentException.class, () -> new Person.PersonBuilder()
                .id("P002")
                .firstName("Jane")
                .lastName("Doe")
                .age(-5)  // Age cannot be negative
                .gender("Female")
                .build());
    }
}
