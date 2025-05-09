package hus.oop.lab11.iterator_pattern.facebook_iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facebook implements SocialNetwork {
    private Map<String, List<Profile>> friendsMap = new HashMap<>();
    private Map<String, List<Profile>> coworkersMap = new HashMap<>();

    public Facebook() {
        Profile p1 = new Profile("001", "an@example.com");
        Profile p2 = new Profile("002", "binh@example.com");
        Profile p3 = new Profile("003", "chi@example.com");

        friendsMap.put("001", List.of(p2, p3));
        coworkersMap.put("001", List.of(p3));
    }

    public List<Profile> socialGraphRequest(String profiledId, String type) {
        if (type.equals("friends")) {
            return friendsMap.getOrDefault(profiledId, new ArrayList<>());
        } else if (type.equals("coworkers")) {
            return coworkersMap.getOrDefault(profiledId, new ArrayList<>());
        }
        return new ArrayList<>();
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileId) {
        return new FacebookIterator(this, profileId, "friends");
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileId) {
        return new FacebookIterator(this, profileId, "coworkers");
    }

}
