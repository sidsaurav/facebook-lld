package entities;

import java.util.HashSet;
import java.util.Set;

public class User {
    Integer userId;
    String name;
    Set<Integer> followed;
    Set<Integer> userPostId;

    public User(Integer userId) {
        this.name = "name";
        this.userId = userId;
        this.followed = new HashSet<>();
        this.userPostId = new HashSet<>();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Integer> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<Integer> followed) {
        this.followed = followed;
    }

    public Set<Integer> getUserPostId() {
        return userPostId;
    }

    public void setUserPostId(Set<Integer> userPostId) {
        this.userPostId = userPostId;
    }
}
