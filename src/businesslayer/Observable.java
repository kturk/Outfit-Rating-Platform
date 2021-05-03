package businesslayer;

public interface Observable {

    void attach(Observer observer);
    void notifyObservers();
}
