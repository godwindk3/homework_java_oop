package hus.oop.lab11.iterator_pattern.facebook_iterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileId);
    ProfileIterator createCoworkersIterator(String profileId);
}
