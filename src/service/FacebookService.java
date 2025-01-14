package service;

import java.util.List;

public interface FacebookService {
    public void addUser(int userId);
    public void post(int userId, int postId);
    public void follow(int followerId, int followeeId);
    public void unfollow(int followerId, int followeeId);
    public List<Integer> getNewsFeed(int userId);
    public List<Integer> getNewsFeedPaginated(Integer userId, Integer pageNumber);
    public void deletePost(int postId);
}
