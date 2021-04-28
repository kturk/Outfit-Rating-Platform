package businesslayer.model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class User implements IUser {

    private static int count = 1;
    private int id;
    private String userName;
    private String password;
    private List<IUser> followingUsers;
    private List<IUser> followerUsers;
    private List<ICollection> collections;

    public User() {
        this.id = count;
        count++;
        this.followingUsers = new ArrayList<IUser>();
        this.followerUsers = new ArrayList<IUser>();
        this.collections = new ArrayList<ICollection>();
    }

    public User(String userName, String password) {
        this.id = count;
        count++;
        this.userName = userName;
        this.password = password;
        this.followingUsers = new ArrayList<IUser>();
        this.followerUsers = new ArrayList<IUser>();
        this.collections = new ArrayList<ICollection>();
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public List<IUser> getFollowingUsers() {
        return followingUsers;
    }

    @Override
    public List<IUser> getFollowerUsers() {
        return followerUsers;
    }

    @Override
    public List<ICollection> getCollections() {
        return collections;
    }

    @Override
    public void addFollowingUser(IUser user) {
        this.getFollowingUsers().add(user);  // TODO direct access or getter?
    }

    @Override
    public void removeFollowingUser(IUser user) {
        this.getFollowingUsers().remove(user);
    }

    @Override
    public void addFollowerUser(IUser user) {
        this.getFollowerUsers().add(user);
    }

    @Override
    public void removeFollowerUser(IUser user) {
        this.getFollowerUsers().remove(user);
    }

    @Override
    public void createCollection(ICollection collection) {
        this.getCollections().add(collection);
    }

    @Override
    public void deleteCollection(ICollection collection) {
        this.getCollections().remove(collection);
    }

    @Override
    public void addOutfitToCollection(IOutfit outfit, int collectionId) {
        ICollection selectedCollection = getCollectionById(collectionId);
        if (selectedCollection != null)
            selectedCollection.addOutfit(outfit.getId());
        else
            throw new NoSuchElementException();
    }

    @Override
    public void removeOutfitFromCollection(IOutfit outfit, int collectionId) {
        ICollection selectedCollection = getCollectionById(collectionId);
        if (selectedCollection != null)
            selectedCollection.removeOutfit(outfit.getId());
        else
            throw new NoSuchElementException();
    }

    private ICollection getCollectionById(int collectionId) {
        for (ICollection collection: this.getCollections()) {
            if (collection.getId() == collectionId)
                return collection;
        }
        return null;
    }
}
