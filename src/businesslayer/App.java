package businesslayer;
import businesslayer.model.User;
import businesslayer.model.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class App {

//    Users users = new Users();
//    { }

    public static void main(String[] args) throws Exception{

//        MainScreen mainScreen = new MainScreen();
//        LoginScreen loginScreen = new LoginScreen();
//        MainScreen mainScreen = new MainScreen();


        Users users = new Users();

        User testUser1 = new User("kemal", "arda");
        User follow1 = new User("can", "pompa");
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
        testUser3.addFollowingUser(follow6);

        users.getUserList().add(testUser1);
        users.getUserList().add(testUser2);
        users.getUserList().add(testUser3);


        userMarshaling(users);
        userUnMarshaling();

    }

    private static void userUnMarshaling() throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Users.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Users read_users = (Users) jaxbUnmarshaller.unmarshal( new FileInputStream("test.xml") );

        for(User user : read_users.getUserList())
        {
            System.out.println(user.getId());
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(user.getFollowingUsers().get(0).getId());
        }
    }

    private static void userMarshaling(Users users) throws Exception {
        JAXBContext contextObj = JAXBContext.newInstance(Users.class);
        Marshaller marshallerObj = contextObj.createMarshaller();

        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(users, new FileOutputStream("test.xml"));
    }


}
