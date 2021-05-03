package businesslayer.model;

import businesslayer.Observable;
import businesslayer.Observer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

public class Collection implements ICollection, Observable {

    private static int count = 1;
    private int id;
    private String collectionName;
    @XmlElementWrapper(name="OutfitIds")
    @XmlElement(name = "Id")
    private final List<Integer> outfitIds;
    private final List<Observer> observers;

    public Collection() {
        this.id = count;
        count++;
        this.outfitIds = new ArrayList<Integer>();
        this.observers = new ArrayList<Observer>();
    }

    public Collection(String collectionName) {
        this.id = count;
        count++;

        this.collectionName = collectionName;
        this.outfitIds = new ArrayList<Integer>();
        this.observers = new ArrayList<Observer>();

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
        this.notifyObservers();
    }


    @Override
    public void removeOutfit(Integer outfitId) {
        this.getOutfitIds().remove(outfitId);  // TODO Check the contains logic here?
        this.notifyObservers();
    }


    @Override
    public String toString() {
        return "Collection " + id + ":   " + collectionName + "    " + getNumOfOutfits() + " Outfits";
    }

    private String getNumOfOutfits(){
        return Integer.toString(outfitIds.size());
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observers){
            observer.update(outfitIds);
        }
    }
}
