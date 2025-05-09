package hus.oop.lab11.decorator_pattern.data_source_decorator;

public class FileDataSource implements DataSource {
    private String filename;
    private String storage = "";

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        storage = data;
        System.out.println("[FileDataSource] wrote raw data: " + storage);

    }

    @Override
    public String readData() {
        System.out.println("[FileDataSource] Read raw data: " + storage);
        return storage;
    }
}
