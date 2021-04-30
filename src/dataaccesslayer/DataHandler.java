package dataaccesslayer;

import businesslayer.model.Users;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class DataHandler {

    private String filePath;

    public DataHandler(String filePath) {
        this.filePath = filePath;
    }

    public Users readXML() {
        try {
            Unmarshaller unmarshaller = FileIOManager.getUnmarshaller();
            Users users = null;
            if (unmarshaller != null)
                users = (Users) unmarshaller.unmarshal(new FileInputStream(this.filePath));
            else
                System.out.println("Couldn't read Users from file.");  // TODO can be deleted
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void writeXML(Users users) {
        try {
            Marshaller marshaller = FileIOManager.getMarshaller();
            if (marshaller != null)
                marshaller.marshal(users, new FileOutputStream(this.filePath));
            else
                System.out.println("Null Marshaller");  // TODO can be deleted
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
