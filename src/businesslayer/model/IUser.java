package businesslayer.model;

import java.util.List;

public interface IUser {

    int getId();

    String getUserName();

    void setUserName(String userName);

    String getPassword();

    void setPassword(String password);

    // @XmlElement
    List<User> getFollowingUsers();

    // @XmlElement
    List<User> getFollowerUsers();

    // @XmlElement
    List<Collection> getCollections();

    void addFollowingUser(User user);

    void removeFollowingUser(IUser user);

    void addFollowerUser(User user);

    void removeFollowerUser(IUser user);

    void createCollection(Collection collection);

    void deleteCollection(ICollection collection);

    void addOutfitToCollection(IOutfit outfit, int collectionId);

    void removeOutfitFromCollection(IOutfit outfit, int collectionId);
}
