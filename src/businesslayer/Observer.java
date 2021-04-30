package businesslayer;

import businesslayer.model.Collection;

import java.util.ArrayList;
import java.util.List;

public interface Observer {

    public void update(List<Collection> list);
}
