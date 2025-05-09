package hus.oop.lab11.decorator_pattern.data_source_decorator;

public class CompressionDecorator extends DataSourceDecorator {

    public CompressionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        String compressed = "COMPRESSED(" + data + ")";
        System.out.println("[CompressionDecorator] Compressed data: " + compressed);
        super.writeData(compressed);
    }

    @Override
    public String readData() {
        String data = super.readData();
        String decompressed = data.replace("COMPRESSED(", "").replace(")", "");
        System.out.println("[CompressionDecorator] Decompressed data: " + decompressed);
        return decompressed;
    }
}
