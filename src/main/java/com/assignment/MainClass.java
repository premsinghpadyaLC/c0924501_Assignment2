package com.assignment;

import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        // Create instances of Person using the builder pattern
        Person person1 = new Person.PersonBuilder()
            .id("P001")
            .firstName("John")
            .lastName("Doe")
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

        // Output details of the persons
        System.out.println("Person 1 Details:");
        System.out.println("ID: " + person1.getId());
        System.out.println("Name: " + person1.getFirstName() + " " + person1.getLastName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Gender: " + person1.getGender());
        System.out.println();

        System.out.println("Person 2 Details:");
        System.out.println("ID: " + person2.getId());
        System.out.println("Name: " + person2.getFirstName() + " " + person2.getLastName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Gender: " + person2.getGender());
        System.out.println();

        // Create BlogPost instances using the builder pattern
        BlogPost blogPost1 = BlogPost.builder()
            .id("B001")
            .authorId(person1.getId())
            .postContent("This is the first blog post content.")
            .build();

        BlogPost blogPost2 = BlogPost.builder()
            .id("B002")
            .authorId(person2.getId())
            .postContent("This is the second blog post content.")
            .build();

        // Create a list of BlogPosts
        List<BlogPost> blogPosts = Arrays.asList(blogPost1, blogPost2);

        // Create a list of Persons (contributors)
        List<Person> contributors = Arrays.asList(person1, person2);

        // Create the Blog instance
        Blog blog = new Blog(blogPosts, contributors);

        // Display information about blog posts
        System.out.println("Blog Posts:");
        blogPosts.forEach(post -> {
            System.out.println("Post ID: " + post.getId());
            System.out.println("Author ID: " + post.getAuthorId());
            System.out.println("Content: " + post.getPostContent());
            System.out.println();
        });

        // Print contributors to the blog
        System.out.println("Contributors:");
        blog.printContributors();
    }
}
