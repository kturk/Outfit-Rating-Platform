package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public class Collection implements ICollection {

    private static int count = 1;
    private int id; // TODO do we need id for collections?
    private String collectionName;
    private List<Integer> outfitIds; // TODO integer or outfit itself?

    public Collection() {
        this.id = count;
        count++;
        this.outfitIds = new ArrayList<Integer>();
    }

    public Collection(String collectionName) {
        this.id = count;
        count++;
        this.collectionName = collectionName;
        this.outfitIds = new ArrayList<Integer>();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getCollectionName() {
        return collectionName;
    }

    @Override
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    @Override
    public List<Integer> getOutfitIds() {
        return outfitIds;
    }

    @Override
    public void addOutfit(int outfitId) {
        this.getOutfitIds().add(outfitId);
    }

    @Override
    public void removeOutfit(int outfitId) {
        this.getOutfitIds().remove(outfitId);  // TODO Check the contains logic here?
    }

    @Override
    public String toString() {
        System.out.println("len" + collectionName.length());
        System.out.println("lenx" + (20 - collectionName.length()));

        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(collectionName.length());
        for(int i=0; i<30-collectionName.length(); i++){
            stringBuilder.append(" ");
        }
        String splitter = stringBuilder.toString();
        return "Collection " + id + ":   " + collectionName + splitter + getNumOfOutfits() + " Outfits";

    }

    private String getNumOfOutfits(){
        return Integer.toString(outfitIds.size());
    }
}
