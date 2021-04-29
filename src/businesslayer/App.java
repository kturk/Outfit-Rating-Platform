package businesslayer;
import businesslayer.model.User;
import businesslayer.model.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import java.io.FileOutputStream;

public class App {

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


        JAXBContext contextObj = JAXBContext.newInstance(Users.class);

        Marshaller marshallerObj = contextObj.createMarshaller();
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerObj.marshal(users, new FileOutputStream("test.xml"));


//        File file = new File("question.xml");
//        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
//
//        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        Question que= (Question) jaxbUnmarshaller.unmarshal(file);



    }



}
