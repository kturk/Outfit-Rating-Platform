package dataaccesslayer;

import businesslayer.model.Outfit;
import businesslayer.model.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

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
//                .registerTypeAdapter(Admin.class, new AdminSerializer()) TODO delete this
                .setPrettyPrinting()
                .create();
        return gson;
    }
}
