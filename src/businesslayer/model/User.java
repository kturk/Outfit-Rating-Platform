package businesslayer.model;

import businesslayer.Observable;
import businesslayer.Observer;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Observable{

    private static int count = 1;
    private int id;
    private String userName;
    private String password;
    @XmlElementWrapper(name="FollowingUsers")
    @XmlElement(name = "FollowingUser")
    private List<User> followingUsers;
    @XmlElementWrapper(name="FollowersUsers")
    @XmlElement(name = "FollowerUser")
    private List<User> followerUsers;
    private List<Collection> collections;
    @XmlTransient
    private List<Observer> observers;

    public User() {
        this.id = count;
        count++;
        this.followingUsers = new ArrayList<User>();
        this.followerUsers = new ArrayList<User>();
        this.collections = new ArrayList<Collection>();
        this.observers = new ArrayList<Observer>();
    }

    public User(String userName, String password) {
        this.id = count;
        count++;
        this.userName = userName;
        this.password = password;
        this.followingUsers = new ArrayList<User>();
        this.followerUsers = new ArrayList<User>();
        this.collections = new ArrayList<Collection>();
        this.observers = new ArrayList<Observer>();

    }

//    @XmlAttribute
    public int getId() { return this.id;}

//    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    @XmlElement
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    @XmlElement
    public List<User> getFollowingUsers() {
        return followingUsers;
    }

//    @XmlElement
    public List<User> getFollowerUsers() {
        return followerUsers;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public void addFollowingUser(User user) {
        this.getFollowingUsers().add(user);  // TODO direct access or getter?
    }

    public void removeFollowingUser(User user) {
        this.getFollowingUsers().remove(user);
    }

    public void addFollowerUser(User user) {
        this.getFollowerUsers().add(user);
    }

    public void removeFollowerUser(User user) {
        this.getFollowerUsers().remove(user);
    }

    public void createCollection(Collection collection) {
        this.getCollections().add(collection);
        this.notifyObservers();
    }

    public void deleteCollection(Collection collection) {
        this.getCollections().remove(collection);
    }

    public void addOutfitToCollection(IOutfit outfit, int collectionId) {
        ICollection selectedCollection = getCollectionById(collectionId);
        if (selectedCollection != null)
            selectedCollection.addOutfit(outfit.getId());
        else
            throw new NoSuchElementException();
    }

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


    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for(Observer observer : observers) {
            observer.update(this.collections);
        }
    }
}
