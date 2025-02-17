package com.assignment;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@Jacksonized
public class BlogPost {
    private String id;
    private String authorId;
    private String postContent;

    // Constructor and getter methods

    private BlogPost(String id, String authorId, String postContent) {
        this.id = id;
        this.authorId = authorId;
        this.postContent = postContent;
    }

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getPostContent() {
        return postContent;
    }

    // Static builder class
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String authorId;
        private String postContent;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder authorId(String authorId) {
            this.authorId = authorId;
            return this;
        }

        public Builder postContent(String postContent) {
            this.postContent = postContent;
            return this;
        }

        public BlogPost build() {
            if (id == null || authorId == null || postContent == null) {
                throw new IllegalArgumentException("All fields must be provided");
            }
            return new BlogPost(id, authorId, postContent);
        }
    }
}
