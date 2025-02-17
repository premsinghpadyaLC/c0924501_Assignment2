package com.assignment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    private final List<BlogPost> posts;  // Use BlogPost instead of BlogPostTest
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }

    // Example method to show how to use the posts and contributors
    public void printContributors() {
        contributors.forEach(contributor -> System.out.println(contributor.getFirstName()));
    }
}
