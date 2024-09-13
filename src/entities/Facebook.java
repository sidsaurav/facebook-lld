package entities;

import java.util.HashMap;
import java.util.Map;

public class Facebook {
    Map<Integer, Post> postMap;
    Map<Integer, User> userMap;

    public final static int PAGE_SIZE = 2;

    static Facebook facebook;
    private Facebook() {
        postMap = new HashMap<>();
        userMap = new HashMap<>();
    };

    public static Facebook getInstance() {
        if (facebook == null){
            facebook = new Facebook();
        }
        return facebook;
    }

    public Map<Integer, Post> getPostMap() {
        return postMap;
    }

    public void setPostMap(Map<Integer, Post> postMap) {
        this.postMap = postMap;
    }

    public Map<Integer, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<Integer, User> userMap) {
        this.userMap = userMap;
    }
}
