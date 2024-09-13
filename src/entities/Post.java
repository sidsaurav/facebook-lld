package entities;

import java.util.Set;

public class Post {
    Integer postId;
    String content;
    Integer userId;
    Integer createdAt;

    private static int time = 1;

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Post(Integer postId, String content, Integer userId) {
        this.postId = postId;
        this.content = content;
        this.userId = userId;
        this.createdAt = time++;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
