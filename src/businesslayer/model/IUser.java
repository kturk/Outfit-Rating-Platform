package businesslayer.model;

import java.util.List;

public interface IUser {

    String getUserName();

    void setUserName(String userName);

    String getPassword();

    void setPassword(String password);

    List<IUser> getFollowingUsers();

    List<IUser> getFollowerUsers();

    List<ICollection> getCollections();

    void addFollowingUser(IUser user);

    void removeFollowingUser(IUser user);

    void addFollowerUser(IUser user);

    void removeFollowerUser(IUser user);

    void createCollection(ICollection collection);

    void deleteCollection(ICollection collection);

    void addOutfitToCollection(IOutfit outfit, int collectionId);

    void removeOutfitFromCollection(IOutfit outfit, int collectionId);
}
