package businesslayer.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements IUser {

    private static int count = 1;
    private int id;
    private String userName;
    private String password;
    private List<User> followingUsers;
    private List<User> followerUsers;
    private List<Collection> collections;

    public User() {
        this.id = count;
        count++;
        this.followingUsers = new ArrayList<User>();
        this.followerUsers = new ArrayList<User>();
        this.collections = new ArrayList<Collection>();
    }

    public User(String userName, String password) {
        this.id = count;
        count++;
        this.userName = userName;
        this.password = password;
        this.followingUsers = new ArrayList<User>();
        this.followerUsers = new ArrayList<User>();
        this.collections = new ArrayList<Collection>();
    }

    @XmlAttribute
    @Override
    public int getId() { return this.id;}

    @XmlElement(type = Object.class)
    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement(type = Object.class)
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @XmlElement(type = Object.class)
    @Override
    public List<User> getFollowingUsers() {
        return followingUsers;
    }

    @XmlElement(type = Object.class)
    @Override
    public List<User> getFollowerUsers() {
        return followerUsers;
    }

    @Override
    public List<Collection> getCollections() {
        return collections;
    }

    @Override
    public void addFollowingUser(User user) {
        this.getFollowingUsers().add(user);  // TODO direct access or getter?
    }

    @Override
    public void removeFollowingUser(IUser user) {
        this.getFollowingUsers().remove(user);
    }

    @Override
    public void addFollowerUser(User user) {
        this.getFollowerUsers().add(user);
    }

    @Override
    public void removeFollowerUser(IUser user) {
        this.getFollowerUsers().remove(user);
    }

    @Override
    public void createCollection(Collection collection) {
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
