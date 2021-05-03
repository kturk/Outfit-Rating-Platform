package dataaccesslayer;

import businesslayer.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataInitializer {


    public static List<Outfit> getInitialOutfits() {
        Outfit outfit1 = new Outfit("Benetton",
                IOutfit.ClothingType.CASUAL,
                IOutfit.Gender.MALE,
                IOutfit.Size.L,
                IOutfit.Color.BLACK);
        Outfit outfit2 = new Outfit("Mavi",
                IOutfit.ClothingType.SPORT,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.XL,
                IOutfit.Color.YELLOW);
        Outfit outfit3 = new Outfit("Loft",
                IOutfit.ClothingType.ELEGANT,
                IOutfit.Gender.MALE,
                IOutfit.Size.XXS,
                IOutfit.Color.ORANGE);
        Outfit outfit4 = new Outfit("KAFT",
                IOutfit.ClothingType.PARTY,
                IOutfit.Gender.MALE,
                IOutfit.Size.M,
                IOutfit.Color.PINK);
        Outfit outfit5 = new Outfit("LTB",
                IOutfit.ClothingType.CASUAL,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.L,
                IOutfit.Color.PURPLE);
        Outfit outfit6 = new Outfit("Derimod",
                IOutfit.ClothingType.ELEGANT,
                IOutfit.Gender.MALE,
                IOutfit.Size.S,
                IOutfit.Color.RED);
        Outfit outfit7 = new Outfit("Armani",
                IOutfit.ClothingType.ELEGANT,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.XS,
                IOutfit.Color.GREY);
        Outfit outfit8 = new Outfit("Burberry",
                IOutfit.ClothingType.SPORT,
                IOutfit.Gender.MALE,
                IOutfit.Size.XXL,
                IOutfit.Color.GREEN);
        Outfit outfit9 = new Outfit("Chanel",
                IOutfit.ClothingType.PARTY,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.XL,
                IOutfit.Color.PINK);
        Outfit outfit10 = new Outfit("Prada",
                IOutfit.ClothingType.ELEGANT,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.XS,
                IOutfit.Color.YELLOW);
        Outfit outfit11 = new Outfit("Gucci",
                IOutfit.ClothingType.PARTY,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.L,
                IOutfit.Color.BLACK);
        Outfit outfit12 = new Outfit("Benetton",
                IOutfit.ClothingType.SPORT,
                IOutfit.Gender.MALE,
                IOutfit.Size.XXL,
                IOutfit.Color.BLACK);
        Outfit outfit13 = new Outfit("Mavi",
                IOutfit.ClothingType.CASUAL,
                IOutfit.Gender.MALE,
                IOutfit.Size.M,
                IOutfit.Color.RED);
        Outfit outfit14 = new Outfit("Chanel",
                IOutfit.ClothingType.CASUAL,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.S,
                IOutfit.Color.BLUE);
        Outfit outfit15 = new Outfit("Loft",
                IOutfit.ClothingType.CASUAL,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.XS,
                IOutfit.Color.ORANGE);

        List<Outfit> outfits = new ArrayList<>();
        outfits.add(outfit1); outfits.add(outfit2); outfits.add(outfit3); outfits.add(outfit4); outfits.add(outfit5);
        outfits.add(outfit6); outfits.add(outfit7); outfits.add(outfit8); outfits.add(outfit9); outfits.add(outfit10);
        outfits.add(outfit11); outfits.add(outfit12); outfits.add(outfit13); outfits.add(outfit14); outfits.add(outfit15);

        return outfits;
    }


    public static Users getInitialUsers() {
        User user1 = new User("tugkantuglular", "tugkan123");
        User user2 = new User("dilekozturk", "dilek123");
        User user3 = new User("serhatcaner", "serhat123");
        User user4 = new User("selmatekir", "selma123");
        User user5 = new User("serapsahin", "serap123");
        User user6 = new User("yalinbastanlar", "yalin123");
        User user7 = new User("kemalturk", "kemal123");
        User user8 = new User("canertanguler", "caner123");

        List<User> users = new ArrayList<>();
        users.add(user1); users.add(user2); users.add(user3); users.add(user4);
        users.add(user5); users.add(user6); users.add(user7); users.add(user8);

        Users userList = new Users();
        userList.setUserList(users);

        return userList;
    }
}
