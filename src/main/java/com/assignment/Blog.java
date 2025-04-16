package com.assignment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@ToString
@EqualsAndHashCode
public class Blog {
    private final List<BlogPost> posts;
    private final List<Person> contributors;

    public Blog(List<BlogPost> posts, List<Person> contributors) {
        this.posts = posts;
        this.contributors = contributors;
    }

    public void printContributors() {
        contributors.forEach(contributor -> System.out.println(contributor.getFirstName()));
    }

    public List<String> getPostsByAuthorAge(Integer age) {
        return posts.stream()
            .filter(post -> {
                Person author = contributors.stream()
                    .filter(p -> Objects.equals(p.getId(), post.getAuthorId()))
                    .findFirst()
                    .orElse(null);
                return author != null && author.getAge() == age;
            })
            .map(BlogPost::getId)
            .collect(Collectors.toList());
    }
}
