package com.assignment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainClass {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        // Load JSON files from resources folder using class loader
        try (
            InputStream personStream = MainClass.class.getClassLoader().getResourceAsStream("person.json");
            InputStream blogPostStream = MainClass.class.getClassLoader().getResourceAsStream("blogPosts.json")
        ) {
            // Check if the files exist
            if (personStream == null || blogPostStream == null) {
                System.out.println(" One or both JSON files not found in src/main/resources/");
                return;
            }

            // Deserialize JSON into Java objects
            List<Person> persons = objectMapper.readValue(
                    personStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Person.class));

            List<BlogPost> blogPosts = objectMapper.readValue(
                    blogPostStream,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, BlogPost.class));

            // Create Blog instance
            Blog blog = new Blog(blogPosts, persons);

            // Example: Get posts by authors aged 30
            int targetAge = 30;
            List<String> postsByAge = blog.getPostsByAuthorAge(targetAge);

            System.out.println("Posts by authors aged " + targetAge + ":");
            postsByAge.forEach(System.out::println);

            // Summary
            System.out.println("\nSummary:");
            System.out.println("Total blog posts: " + blogPosts.size());
            System.out.println("Total contributors: " + persons.size());

            // Print all Person details (Full name)
            System.out.println("\nContributors Details:");
            persons.forEach(person -> {
                String fullName = person.getFirstName() + " " + person.getLastName();
                System.out.println("ID: " + person.getId());
                System.out.println("Full Name: " + fullName);
                System.out.println("Age: " + person.getAge());
                System.out.println("Gender: " + person.getGender());
                System.out.println("----");
            });

            // Print all BlogPost details
            System.out.println("\n Blog Post Details:");
            blogPosts.forEach(blogPost -> {
                System.out.println("Post ID: " + blogPost.getId());
                System.out.println("Author ID: " + blogPost.getAuthorId());
                System.out.println("Content: " + blogPost.getPostContent());
                System.out.println("----");
            });

        } catch (IOException e) {
            System.out.println(" Error reading JSON files:");
            e.printStackTrace();
        }
    }
}
