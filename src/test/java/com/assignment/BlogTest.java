package com.assignment;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BlogTest {

    @Test
    void testGetPostsByAuthorAge() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        Person person2 = new Person.PersonBuilder()
                .id("P002")
                .firstName("Jane")
                .lastName("Smith")
                .age(25)
                .gender("Female")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        BlogPost blogPost2 = BlogPost.builder()
                .id("B002")
                .authorId(person2.getId())
                .postContent("Content by Jane")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1, blogPost2);
        List<Person> contributors = Arrays.asList(person1, person2);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 30
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(1, result.size());
        assertTrue(result.contains("B001"));

        // Test: Get posts by authors aged 25
        result = blog.getPostsByAuthorAge(25);
        assertEquals(1, result.size());
        assertTrue(result.contains("B002"));
    }

    @Test
    void testGetPostsByAuthorAgeWithNoMatches() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1);
        List<Person> contributors = Arrays.asList(person1);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 40 (no such author)
        List<String> result = blog.getPostsByAuthorAge(40);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetPostsByMultipleAuthors() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        Person person2 = new Person.PersonBuilder()
                .id("P002")
                .firstName("Jane")
                .lastName("Smith")
                .age(25)
                .gender("Female")
                .build();

        Person person3 = new Person.PersonBuilder()
                .id("P003")
                .firstName("Alice")
                .lastName("Johnson")
                .age(30)
                .gender("Female")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        BlogPost blogPost2 = BlogPost.builder()
                .id("B002")
                .authorId(person2.getId())
                .postContent("Content by Jane")
                .build();

        BlogPost blogPost3 = BlogPost.builder()
                .id("B003")
                .authorId(person3.getId())
                .postContent("Content by Alice")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1, blogPost2, blogPost3);
        List<Person> contributors = Arrays.asList(person1, person2, person3);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 30
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(2, result.size());
        assertTrue(result.contains("B001"));
        assertTrue(result.contains("B003"));
    }

    @Test
    void testGetPostsByAgeWithEmptyList() {
        // Setup test data with empty lists
        List<BlogPost> posts = Arrays.asList();
        List<Person> contributors = Arrays.asList();
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 30 (no posts)
        List<String> result = blog.getPostsByAuthorAge(30);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetPostsByAuthorAgeWithOnePost() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1);
        List<Person> contributors = Arrays.asList(person1);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 30
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(1, result.size());
        assertTrue(result.contains("B001"));
    }

    @Test
    void testGetPostsByAuthorAgeWithNoPostForAgeRange() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1);
        List<Person> contributors = Arrays.asList(person1);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 20 (no posts for this age)
        List<String> result = blog.getPostsByAuthorAge(20);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetPostsByAuthorAgeWithMultipleAuthorsSameAge() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        Person person2 = new Person.PersonBuilder()
                .id("P002")
                .firstName("John")
                .lastName("Smith")
                .age(30)
                .gender("Male")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        BlogPost blogPost2 = BlogPost.builder()
                .id("B002")
                .authorId(person2.getId())
                .postContent("Content by John")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1, blogPost2);
        List<Person> contributors = Arrays.asList(person1, person2);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 30
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(2, result.size());
        assertTrue(result.contains("B001"));
        assertTrue(result.contains("B002"));
    }

    @Test
    void testGetPostsByAuthorAgeWithDifferentAgeGroups() {
        // Setup test data
        Person person1 = new Person.PersonBuilder()
                .id("P001")
                .firstName("Premsingh")
                .lastName("Padya")
                .age(30)
                .gender("Male")
                .build();

        Person person2 = new Person.PersonBuilder()
                .id("P002")
                .firstName("Alice")
                .lastName("Johnson")
                .age(45)
                .gender("Female")
                .build();

        BlogPost blogPost1 = BlogPost.builder()
                .id("B001")
                .authorId(person1.getId())
                .postContent("Content by Premsingh")
                .build();

        BlogPost blogPost2 = BlogPost.builder()
                .id("B002")
                .authorId(person2.getId())
                .postContent("Content by Alice")
                .build();

        List<BlogPost> posts = Arrays.asList(blogPost1, blogPost2);
        List<Person> contributors = Arrays.asList(person1, person2);
        Blog blog = new Blog(posts, contributors);

        // Test: Get posts by authors aged 30
        List<String> result = blog.getPostsByAuthorAge(30);
        assertEquals(1, result.size());
        assertTrue(result.contains("B001"));

        // Test: Get posts by authors aged 45
        result = blog.getPostsByAuthorAge(45);
        assertEquals(1, result.size());
        assertTrue(result.contains("B002"));
    }
}
