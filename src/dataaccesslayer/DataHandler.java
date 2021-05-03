package dataaccesslayer;

import businesslayer.model.Outfit;
import businesslayer.model.Users;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.List;

public class DataHandler {

    private String xmlPath;
    private String jsonPath;

    public DataHandler(String xmlPath, String jsonPath) {
        this.xmlPath = xmlPath;
        this.jsonPath = jsonPath;
        initializeDataIfFileNotExist();
    }

    public Users readXML() {
        try {
            Unmarshaller unmarshaller = FileIOManager.getUnmarshaller();
            Users users = null;
            if (unmarshaller != null)
                users = (Users) unmarshaller.unmarshal(new FileInputStream(this.xmlPath));
            else
                System.out.println("Couldn't read Users from file.");
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
                marshaller.marshal(users, new FileOutputStream(this.xmlPath));
            else
                System.out.println("Null Marshaller");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Outfit> readJson(){
        try {
            Reader reader = new FileReader(this.jsonPath);
            Gson gson = FileIOManager.getGson();
            List<Outfit> outfits = gson.fromJson(reader, new TypeToken<List<Outfit>>(){}.getType());
            reader.close();
            return outfits;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeJson(Object object){
        try {
            Writer writer = new FileWriter(this.jsonPath);
            Gson gson = FileIOManager.getGson();
            gson.toJson(object, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeDataIfFileNotExist() {
        if (!new File(this.jsonPath).exists() || !new File(this.xmlPath).exists()) {
            this.writeJson(DataInitializer.getInitialOutfits());
            this.writeXML(DataInitializer.getInitialUsers());
        }

    }
}
