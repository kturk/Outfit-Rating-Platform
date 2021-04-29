package businesslayer.model;

import java.util.ArrayList;
import java.util.List;

public class Outfit implements IOutfit {

    private static int count = 1;
    private int id;
    private String brandName;
    private ClothingType clothingType;
    private Gender gender;
    private Size size;
    private Color color;
    private int numberOfLikes;
    private int numberOfDislikes;
    private List<String> comments;

    public Outfit() {
        this.id = count;
        count++;
        this.numberOfLikes = 0;
        this.numberOfDislikes = 0;
        this.comments = new ArrayList<String>();
    }

    public Outfit(String brandName, ClothingType clothingType, Gender gender, Size size, Color color) {
        this.id = count;
        count++;
        this.brandName = brandName;
        this.clothingType = clothingType;
        this.gender = gender;
        this.size = size;
        this.color = color;
        this.numberOfLikes = 0;
        this.numberOfDislikes = 0;
        this.comments = new ArrayList<String>();
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
    public String getBrandName() {
        return brandName;
    }

    @Override
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public ClothingType getClothingType() {
        return clothingType;
    }

    @Override
    public void setClothingType(ClothingType clothingType) {
        this.clothingType = clothingType;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    @Override
    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    @Override
    public int getNumberOfDislikes() {
        return numberOfDislikes;
    }

    @Override
    public void setNumberOfDislikes(int numberOfDislikes) {
        this.numberOfDislikes = numberOfDislikes;
    }

    @Override
    public List<String> getComments() {
        return comments;
    }

    @Override
    public void increaseNumberOfLikes() {
        this.numberOfLikes++;  // TODO this.setNumberOfLikes(this.getNumberOfLikes() + 1);
    }

    @Override
    public void decreaseNumberOfLikes() {
        this.numberOfLikes--;
    }

    @Override
    public void increaseNumberOfDislikes() {
        this.numberOfDislikes++;
    }

    @Override
    public void decreaseNumberOfDislikes() {
        this.numberOfDislikes--;
    }

    @Override
    public void addComment(String comment) {
        this.getComments().add(comment);
    }

    @Override
    public void removeComment(String comment) {
        this.getComments().remove(comment);  // TODO Check the contains logic here?
    }
}
