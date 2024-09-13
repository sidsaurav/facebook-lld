package service;

import entities.Facebook;
import entities.Post;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class FacebookServiceImpl implements FacebookService{
    Facebook facebook;

    public FacebookServiceImpl() {
        this.facebook = Facebook.getInstance();
    }

    @Override
    public void addUser(int userId){
        User user = new User(userId);
        facebook.getUserMap().put(userId, user);
    }

    @Override
    public void post(int userId, int postId) {
        if(!checkUser(userId)){
            System.out.println("User is not available");
            return;
        }

        Post post = new Post(postId, "abc", userId);

        facebook.getPostMap().put(postId, post);
        facebook.getUserMap().get(userId).getUserPostId().add(postId);
    }

    @Override
    public void follow(int followerId, int followeeId) {
        if(!checkUser(followerId)){
            System.out.println("User is not available");
            return;
        }

        if(!checkUser(followeeId)){
            System.out.println("User is not available");
            return;
        }

        if(checkIsFollowing(followerId, followeeId)){
            System.out.println("Follower already follows followee");
        }

        facebook.getUserMap().get(followerId).getFollowed().add(followeeId);
    }

    @Override
    public void unfollow(int followerId, int followeeId) {
        if(!checkUser(followerId)){
            System.out.println("User is not available");
            return;
        }

        if(!checkUser(followeeId)){
            System.out.println("User is not available");
            return;
        }

        if(!checkIsFollowing(followerId, followeeId)){
            System.out.println("Follower do not follow followee");
            return;
        }

        facebook.getUserMap().get(followerId).getFollowed().remove(followeeId);
    }

    @Override
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = getTopNPost(userId, 100000);
        return newsFeed;
    }

    @Override
    public List<Integer> getNewsFeedPaginated(Integer userId, Integer pageNumber) {
        List<Integer> newsFeed = getTopNPost(userId, 100000);
        List<Integer> pagedNewsFeed = newsFeed.subList((pageNumber-1)*facebook.PAGE_SIZE, (pageNumber)*facebook.PAGE_SIZE - 1);
        return pagedNewsFeed;
    }

    @Override
    public void deletePost(int postId) {
        if(!facebook.getPostMap().containsKey(postId)) {
            System.out.println("Post not available");
        }

        Post post = facebook.getPostMap().get(postId);

        facebook.getPostMap().remove(postId);
        facebook.getUserMap().get(post.getUserId()).getUserPostId().remove(postId);
    }

    private boolean checkUser(Integer userId) {
        User user = facebook.getUserMap().get(userId);
        return user != null;
    }

    private boolean checkIsFollowing(int followerId, int followeeId) {
        return facebook.getUserMap().get(followerId).getFollowed().contains(followeeId);
    }

    private List<Integer> getTopNPost(Integer userId, Integer N) {
        Set<Integer> following = facebook.getUserMap().get(userId).getFollowed();
        PriorityQueue<Post> pq = new PriorityQueue<>((a, b) -> b.getCreatedAt() - a.getCreatedAt());
        for (Integer user: following) {
            for(Integer post: facebook.getUserMap().get(user).getUserPostId()) {
                Post p = facebook.getPostMap().get(post);
                pq.add(p);
            }
        }

        List<Integer> postList = new ArrayList<>();
        for(int i = 0; i<N && !pq.isEmpty(); i++){
            postList.add(pq.poll().getPostId());
        }

        return postList;
    }
}
