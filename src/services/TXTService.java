package services;

import list.List;

public class TXTService<T> {
    private String path;

    public TXTService(String fileName) {
        path = System.getProperty("user.dir") + fileName;
    }

    public void create(T model) {

    }
    public List<T> read() {
        return new List<T>();
    }
}
