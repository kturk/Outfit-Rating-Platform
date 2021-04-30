package businesslayer.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users
{
    @XmlElement(name = "User")
    private List<User> userList = new ArrayList<User>();

    public List<User> getUserList() {
        return this.userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
