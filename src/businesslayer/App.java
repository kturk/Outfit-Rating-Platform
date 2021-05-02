package businesslayer;
import businesslayer.controller.LoginController;
<<<<<<< HEAD
import businesslayer.model.*;
=======
import businesslayer.model.IOutfit;
import businesslayer.model.Outfit;
import businesslayer.model.User;
import businesslayer.model.Users;
import com.google.gson.internal.LinkedTreeMap;
>>>>>>> f66cacc39d35390ec3ec71b76e579db8a450c19e
import dataaccesslayer.DataHandler;
import presentationlayer.LoginScreen;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception{

//        MainScreen mainScreen = new MainScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        MainScreen mainScreen = new MainScreen();
//        LoginController loginController = new LoginController(null, loginScreen);

        Mediator mediator = new Mediator();

        Users users = new Users();

        User testUser1 = new User("kemal", "arda");
        testUser1.createCollection(new Collection("hnm"));
        User follow1 = new User("can", "pas1");
        User follow2 = new User("arda", "qubit");
        testUser1.addFollowingUser(follow1);
        testUser1.addFollowingUser(follow2);

        User testUser2 = new User("tu2", "pas2");
        User follow3 = new User("fol3", "folpas3");
        User follow4 = new User("fol4", "folpas4");
        testUser2.addFollowingUser(follow3);
        testUser2.addFollowingUser(follow4);

        User testUser3 = new User("tu3", "pas3");
        User follow5 = new User("fol5", "folpas5");
        User follow6 = new User("fol5", "folpas5");
        testUser3.addFollowingUser(follow5);
        testUser3.addFollowerUser(follow6);

        users.getUserList().add(testUser1);
        users.getUserList().add(testUser2);
        users.getUserList().add(testUser3);

        List<User> userList = new ArrayList<>();
        userList.add(testUser1); userList.add(follow1); userList.add(follow2);
        userList.add(testUser2); userList.add(follow3); userList.add(follow4);
        userList.add(testUser3); userList.add(follow5); userList.add(follow6);

        Outfit outfit1 = new Outfit("Brand1",
                IOutfit.ClothingType.CASUAL,
                IOutfit.Gender.MALE,
                IOutfit.Size.L,
                IOutfit.Color.BLACK);
        outfit1.setNumberOfLikes(10);
        outfit1.setNumberOfDislikes(5);
        Outfit outfit2 = new Outfit("Brand2",
                IOutfit.ClothingType.SPORT,
                IOutfit.Gender.FEMALE,
                IOutfit.Size.XL,
                IOutfit.Color.YELLOW);
        outfit2.setNumberOfLikes(2);
        outfit2.setNumberOfDislikes(16);
        Outfit outfit3 = new Outfit("Brand3",
                IOutfit.ClothingType.ELEGANT,
                IOutfit.Gender.PREFERNOTTOSAY,
                IOutfit.Size.XXS,
                IOutfit.Color.ORANGE);
        outfit3.setNumberOfLikes(3);
        outfit3.setNumberOfDislikes(6);

        List<Outfit> outfitList = new ArrayList<>();
        outfitList.add(outfit1); outfitList.add(outfit2); outfitList.add(outfit3);

        mediator.setUserList(userList);
        mediator.setOutfitList(outfitList);
        mediator.start();


        DataHandler dataHandler = new DataHandler("testXML.xml", "testJson.json");
        dataHandler.writeXML(users);
        dataHandler.writeJson(outfitList);

        Users read_users = dataHandler.readXML();
        for (User user: read_users.getUserList()){
            System.out.println(user.getId());
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(user.getFollowingUsers().get(0).getId());
        }

        List<Outfit> read_outfits = dataHandler.readJson();
        for (Outfit outfit : read_outfits){
            System.out.println(outfit.getBrandName());
            System.out.println(outfit.getColor());
            System.out.println(outfit.getClass().getSimpleName());
        }

    }

}
