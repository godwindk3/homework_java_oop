package hus.oop.lab11.iterator_pattern.facebook_iterator;

public class Application {
    public static void main(String[] args) {
        SocialNetwork facebook = new Facebook();
        SocialSpammer spammer = new SocialSpammer();

        Profile user = new Profile("001", "an@example.com");

        System.out.println("Sending to friends: ");
        ProfileIterator friendIterator = facebook.createFriendsIterator(user.getId());
        spammer.send(friendIterator, "Important message for friends!");

        System.out.println("\nSending to coworkers:");
        ProfileIterator coworkerIterator = facebook.createCoworkersIterator(user.getId());
        spammer.send(coworkerIterator, "Confidential message for coworkers!");
    }
}
