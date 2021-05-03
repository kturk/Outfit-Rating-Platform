package businesslayer.model;

import businesslayer.Observable;
import businesslayer.Observer;

import javax.xml.bind.annotation.*;
import java.util.*;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Observable{

    private static int count = 1;
    private int id;
    @XmlID
    private String stringId;
    private String userName;
    private String password;
    @XmlElementWrapper(name="FollowingUsers")
    @XmlElement(name = "FollowingUser")
    @XmlIDREF
    private List<User> followingUsers;
    @XmlElementWrapper(name="FollowersUsers")
    @XmlElement(name = "FollowerUser")
    @XmlIDREF
    private List<User> followerUsers;
    @XmlElementWrapper(name="Collections")
    @XmlElement(name = "Collection")
    private List<Collection> collections;
    @XmlTransient
    private List<Observer> observers;
    private List<Integer> likedOutfitIds;
    private List<Integer> dislikedOutfitIds;

    public User() {
        this.id = count;
        count++;
        this.stringId = Integer.toString(id);
        this.followingUsers = new ArrayList<User>();
        this.followerUsers = new ArrayList<User>();
        this.collections = new ArrayList<Collection>();
        this.observers = new ArrayList<Observer>();
        this.likedOutfitIds = new ArrayList<Integer>();
        this.dislikedOutfitIds = new ArrayList<Integer>();
    }

    public User(String userName, String password) {
        this.id = count;
        count++;
        this.stringId = Integer.toString(id);
        this.userName = userName;
        this.password = password;
        this.followingUsers = new ArrayList<User>();
        this.followerUsers = new ArrayList<User>();
        this.collections = new ArrayList<Collection>();
        this.observers = new ArrayList<Observer>();
        this.likedOutfitIds = new ArrayList<Integer>();
        this.dislikedOutfitIds = new ArrayList<Integer>();
    }

    public int getId() { return this.id;}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFollowingUsers() {
        return followingUsers;
    }

    public List<User> getFollowerUsers() {
        return followerUsers;
    }

    public List<Collection> getCollections() {
        return collections;
    }

    public List<Integer> getLikedOutfitIds() {
        return likedOutfitIds;
    }

    public List<Integer> getDislikedOutfitIds() {
        return dislikedOutfitIds;
    }

    public void addFollowingUser(User user) {
        this.getFollowingUsers().add(user);  // TODO direct access or getter?
        this.notifyObservers();
    }

    public void removeFollowingUser(User user) {
        this.getFollowingUsers().remove(user);
        this.notifyObservers();
    }

    public void addFollowerUser(User user) {
        this.getFollowerUsers().add(user);
        this.notifyObservers();
    }

    public void removeFollowerUser(User user) {
        this.getFollowerUsers().remove(user);
        this.notifyObservers();
    }

    public void createCollection(Collection collection) {
        this.getCollections().add(collection);
        this.notifyObservers();
    }

    public Boolean isDislikedOutfitsContainsId(Integer id) {
        return this.getDislikedOutfitIds().contains(id);
    }

    public Boolean isLikedOutfitsContainsId(Integer id) {
        return this.getLikedOutfitIds().contains(id);
    }

    public void addLikedOutfitId(Integer id) {
        if (isDislikedOutfitsContainsId(id))
            this.removeDisLikedOutfitId(id);
        this.getLikedOutfitIds().add(id);
        notifyObservers();
    }

    public void addDislikedOutfitId(Integer id) {
        if (isLikedOutfitsContainsId(id))
            this.removeLikedOutfitId(id);
        this.getDislikedOutfitIds().add(id);
        notifyObservers();
    }

    private void removeLikedOutfitId(Integer id) {
        this.getLikedOutfitIds().remove(id);
    }

    private void removeDisLikedOutfitId(Integer id) {
        this.getDislikedOutfitIds().remove(id);
    }

    public List<Collection> getFollowedCollections() {
        List<Collection> followedCollections = new ArrayList<Collection>();
        for(User user : this.getFollowingUsers()) {
            followedCollections.addAll(user.getCollections());
        }

        return followedCollections;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers) {
            if(observer.getClass().getSimpleName().equals("UserCollectionsScreen")){
                observer.update(this.getCollections());
            }
            else if(observer.getClass().getSimpleName().equals("SeeUsersScreen")){
                observer.update(this.getFollowingUsers());
            }
            else if(observer.getClass().getSimpleName().equals("SeeOutfitsScreen")){
                List<Integer> likesAndDislikes = new ArrayList<Integer>(this.getLikedOutfitIds());
                likesAndDislikes.add(-1);
                likesAndDislikes.addAll(this.getDislikedOutfitIds());
                observer.update(likesAndDislikes);
            }


        }
    }

    @Override
    public String toString() {
        return "ID: " + stringId +
                " -- " + userName.toUpperCase();
    }
}
