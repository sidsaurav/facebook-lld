import service.FacebookService;
import service.FacebookServiceImpl;

public class Main {
    public static void main(String[] args) {
        FacebookService fb = new FacebookServiceImpl();

        fb.addUser(1);
        fb.addUser(2);
        fb.addUser(3);

        fb.follow(1, 2);
        fb.follow(1, 3);
        fb.follow(2,3);

        fb.post(2,101);
        fb.post(2, 201);
        fb.post(3,301);
        fb.post(2,202);
        fb.post(2,302);

        fb.deletePost(301);

        System.out.println(fb.getNewsFeed(1));
    }
}