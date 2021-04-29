package businesslayer.model;

import java.util.List;

public interface IOutfit {

    enum ClothingType {
        PARTY, ELEGANT, CASUAL, SPORT
    }

    enum Gender {
        MALE, FEMALE, PREFERNOTTOSAY
    }

    enum Size {
        XXS, XS, S, M, L, XL, XXL
    }

    enum Color {
        BLUE, RED, PURPLE, YELLOW, PINK, GREEN, ORANGE, BLACK, GREY
    }

    int getId();

    void setId(int id);

    String getBrandName();

    void setBrandName(String brandName);

    ClothingType getClothingType();

    void setClothingType(ClothingType clothingType);

    Gender getGender();

    void setGender(Gender gender);

    Size getSize();

    void setSize(Size size);

    Color getColor();

    void setColor(Color color);

    int getNumberOfLikes();

    void setNumberOfLikes(int numberOfLikes);  // TODO probably no need

    int getNumberOfDislikes();

    void setNumberOfDislikes(int numberOfDislikes);  // TODO probably no need

    List<String> getComments();

    void increaseNumberOfLikes();

    void decreaseNumberOfLikes();

    void increaseNumberOfDislikes();

    void decreaseNumberOfDislikes();

    void addComment(String comment);

    void removeComment(String comment);
}
