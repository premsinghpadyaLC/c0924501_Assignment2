## Assignment 2 Explanation both Part 1 and 2 - Premsingh Padya

### **Overview**
This project involves creating a Blog application with classes for `Person`, `BlogPost`, and `Blog`. The assignment has two parts, and this document explains what was done in both parts. Part 1 includes class creation with validation, and Part 2 expands the application with additional functionality and a main method to interact with JSON data.

### **Part 1 - Initial Implementation**

In Part 1, the following tasks were completed:

1. **`Person` Class:**
   - **Variables:**
     - `String id`: Unique identifier for each person.
     - `String firstName`: First name of the person.
     - `String lastName`: Last name of the person.
     - `Integer age`: Age of the person.
     - `String gender`: Gender of the person.
   - **Validation:**
     - If `id`, `firstName`, `lastName`, or `gender` are `null`, or if `age` is negative, an exception is thrown.
   - **Builder Pattern:**
     - A builder class (`PersonBuilder`) was implemented to allow flexible object creation.
     - The `@Jacksonized` annotation is used for deserialization from JSON.
   - **Getters, `toString()`, and `equals()`:**
     - These methods are implemented to access class fields and compare objects.

2. **`BlogPost` Class:**
   - **Variables:**
     - `String id`: Unique identifier for each blog post.
     - `String authorId`: References the `id` of the author (`Person`).
     - `String postContent`: Content of the blog post.
   - **Validation:**
     - If `id` or `authorId` is `null`, an exception is thrown.
   - **Builder Pattern:**
     - A builder class (`BlogPostBuilder`) was implemented to construct `BlogPost` objects.
     - The `@Jacksonized` annotation is used for deserialization from JSON.
   - **Getters, `toString()`, and `equals()`:**
     - These methods are implemented to access class fields and compare objects.

3. **`Blog` Class:**
   - **Variables:**
     - `List<BlogPost> posts`: A list of blog posts.
     - `List<Person> contributors`: A list of contributors (people who write the blog posts).
   - **Methods:**
     - `getPostsByAuthorAge(Integer age)`: Filters blog posts based on the author's age using Java Streams. This method returns a list of `BlogPost` IDs written by authors matching the specified age.

4. **Unit Tests for `Person` and `BlogPost`:**
   - Unit tests were written to verify that:
     - The `Person` class handles invalid data correctly (e.g., null or negative values).
     - The `BlogPost` class handles missing values properly and successfully creates objects.

### **Part 2 - Advanced Features & Methods**

In Part 2, we expanded the functionality as follows:

1. **`getPostsByAuthorAge(Integer age)` Implementation:**
   - This method filters blog posts by author's age using Java Streams and returns the `BlogPost` IDs.
   - It efficiently retrieves posts based on author age using the Stream API, ensuring that no loops are manually used.

2. **Main Class:**
   - The main method was updated to:
     - **Read JSON Files:**
       - The `person.json` and `blogPosts.json` files are read into lists of `Person` and `BlogPost` objects using Jackson's `ObjectMapper`.
     - **Create Blog Instance:**
       - A `Blog` instance is created using the `BlogPost` and `Person` lists.
     - **Handle Author Age Filter:**
       - The method `getPostsByAuthorAge(Integer age)` is called to retrieve posts by authors aged 30.
     - **Display Blog Summary:**
       - The total number of blog posts and contributors is printed to the console.
     - **Graceful Error Handling:**
       - The program gracefully handles missing or corrupt JSON files and logs appropriate error messages.

3. **Unit Tests for `Blog` Class:**
   - Unit tests were written to:
     - Verify that the `getPostsByAuthorAge` method works correctly.
     - Handle edge cases, such as missing author IDs or invalid data.
     - Test scenarios with empty input or corrupt data in JSON files.

### **File Structure**

Here is the final directory structure of the project:

```
src/
├── com/
│   └── assignment/
│       ├── Person.java
│       ├── BlogPost.java
│       ├── Blog.java
│       ├── MainClass.java
│       └── EXPLANATION.md
resources/
├── blogPosts.json
└── person.json
```

### **What We Have Done So Far**
- **Classes:**
  - Implemented `Person`, `BlogPost`, and `Blog` classes with all required validations and methods.
  - Used Java Streams for filtering data based on age.
- **JSON Handling:**
  - Read and deserialized JSON files for persons and blog posts.
- **Error Handling:**
  - Implemented error handling for missing or corrupt JSON files and invalid data.
- **Unit Tests:**
  - Created unit tests for `Person`, `BlogPost`, and `Blog` classes to validate data and functionality.

### **Future Enhancements (if applicable)**
- Further optimizations and performance enhancements can be made based on real-world requirements.

---


```bash
# Add the explanation file to the repo
git add EXPLANATION.md

# Commit the changes
git commit -m "Added explanation of the assignment implementation"

# Push the changes to GitHub
git push origin final-implementation-including-Part-2
```

This file provides a clear summary of what am done, and it will serve as a useful reference for reviewers when they look at my pull request.


Thank you. 