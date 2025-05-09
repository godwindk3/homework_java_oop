package hus.oop.lab11.iterator_pattern.facebook_iterator;

import java.util.List;

public class FacebookIterator implements ProfileIterator {
    private Facebook facebook;
    private String profileId, type;

    private int currentPosition = 0;
    private List<Profile> cache = null;

    public FacebookIterator(Facebook facebook, String profileId, String type) {
        this.facebook = facebook;
        this.profileId = profileId;
        this.type = type;
    }

    private void lazyInit() {
        if (cache == null) {
            cache = facebook.socialGraphRequest(profileId, type);
        }
    }

    @Override
    public boolean hasMore() {
        lazyInit();
        return currentPosition < cache.size();
    }

    public Profile getNext() {
        if (!hasMore()) return null;
        return cache.get(currentPosition++);
    }
}
