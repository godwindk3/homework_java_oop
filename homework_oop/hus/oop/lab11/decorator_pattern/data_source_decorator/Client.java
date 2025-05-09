package hus.oop.lab11.decorator_pattern.data_source_decorator;

public class Client {
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn,10000";

        DataSource file = new FileDataSource("output.txt");


        DataSource compressed = new CompressionDecorator(file);

        DataSource encrypted = new EncryptionDecorator(compressed);

        encrypted.writeData(salaryRecords);

//        String result = encrypted.readData();
//        System.out.println("Final result: " + result);
    }
}
