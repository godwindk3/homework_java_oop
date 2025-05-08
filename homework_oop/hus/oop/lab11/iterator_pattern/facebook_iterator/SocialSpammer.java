package hus.oop.lab11.iterator_pattern.facebook_iterator;

public class SocialSpammer {
    public void send(ProfileIterator iterator, String message) {
        while (iterator.hasMore()) {
            Profile profile = iterator.getNext();
            System.out.println("Send email to " + profile.getEmail() + ": " + message);
        }

    }
}
