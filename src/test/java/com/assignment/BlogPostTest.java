package com.assignment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlogPostTest {
    @Test
    void testValidBlogPostCreation() {
        BlogPost post = BlogPost.builder()
                .id("B001")
                .authorId("P001")
                .postContent("This is a test blog post.")
                .build();

        assertEquals("B001", post.getId());
        assertEquals("P001", post.getAuthorId());
        assertEquals("This is a test blog post.", post.getPostContent());
    }

    @Test
    void testInvalidBlogPostCreation() {
        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id(null)
                .authorId("P001")
                .postContent("Content")
                .build());

        assertThrows(IllegalArgumentException.class, () -> BlogPost.builder()
                .id("B002")
                .authorId(null)
                .postContent("Content")
                .build());
    }
}
