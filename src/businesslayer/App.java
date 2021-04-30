package businesslayer;
import businesslayer.controller.LoginController;
import businesslayer.model.User;
import presentationlayer.LoginScreen;

import java.util.ArrayList;

public class App {

//    Users users = new Users();
//    { }

    public static void main(String[] args) throws Exception{

//        MainScreen mainScreen = new MainScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        MainScreen mainScreen = new MainScreen();
//        LoginController loginController = new LoginController(null, loginScreen);

        Mediator mediator = new Mediator();

        User testUser1 = new User("kemal", "kemal");
        User follow1 = new User("can", "can");
        User follow2 = new User("arda", "arda");
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
        testUser3.addFollowingUser(follow6);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(testUser1); userList.add(follow1); userList.add(follow2);
        userList.add(testUser2); userList.add(follow3); userList.add(follow4);
        userList.add(testUser3); userList.add(follow5); userList.add(follow6);

        mediator.setUserList(userList);

        mediator.start();


//        users.getUserList().add(testUser1);
//        users.getUserList().add(testUser2);
//        users.getUserList().add(testUser3);


//        Users users = new Users();
//
//        User testUser1 = new User("kemal", "arda");
//        User follow1 = new User("can", "pompa");
//        User follow2 = new User("arda", "qubit");
//        testUser1.addFollowingUser(follow1);
//        testUser1.addFollowingUser(follow2);
//
//        User testUser2 = new User("tu2", "pas2");
//        User follow3 = new User("fol3", "folpas3");
//        User follow4 = new User("fol4", "folpas4");
//        testUser2.addFollowingUser(follow3);
//        testUser2.addFollowingUser(follow4);
//
//        User testUser3 = new User("tu3", "pas3");
//        User follow5 = new User("fol5", "folpas5");
//        User follow6 = new User("fol5", "folpas5");
//        testUser3.addFollowingUser(follow5);
//        testUser3.addFollowingUser(follow6);
//
//        users.getUserList().add(testUser1);
//        users.getUserList().add(testUser2);
//        users.getUserList().add(testUser3);
//
//
//        userMarshaling(users);
//        userUnMarshaling();

    }

//    private static void userUnMarshaling() throws Exception {
//        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        Users read_users = (Users) jaxbUnmarshaller.unmarshal( new FileInputStream("test.xml") );
//
//        for(User user : read_users.getUserList())
//        {
//            System.out.println(user.getId());
//            System.out.println(user.getUserName());
//            System.out.println(user.getPassword());
//            System.out.println(user.getFollowingUsers().get(0).getId());
//        }
//    }
//
//    private static void userMarshaling(Users users) throws Exception {
//        JAXBContext contextObj = JAXBContext.newInstance(Users.class);
//        Marshaller marshallerObj = contextObj.createMarshaller();
//
//        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshallerObj.marshal(users, new FileOutputStream("test.xml"));
//    }


}
