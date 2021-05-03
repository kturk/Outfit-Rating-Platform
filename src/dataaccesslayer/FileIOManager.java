package dataaccesslayer;

import businesslayer.model.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public final class FileIOManager {

    public static Marshaller getMarshaller() {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = contextObj.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            return marshaller;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Unmarshaller getUnmarshaller() {
        try {
            JAXBContext contextObj = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = contextObj.createUnmarshaller();

            return unmarshaller;
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Gson getGson(){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson;
    }
}
