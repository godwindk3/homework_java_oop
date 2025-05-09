package hus.oop.lab11.decorator_pattern.data_source_decorator;

public interface DataSource {
    void writeData(String data);

    String readData();
}
