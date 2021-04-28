package businesslayer.model;

import java.util.List;

public interface ICollection {

    int getId();

    void setId(int id);

    String getCollectionName();

    void setCollectionName(String collectionName);

    List<Integer> getOutfitIds();

    void addOutfit(int outfitId);

    void removeOutfit(int outfitId);
}
