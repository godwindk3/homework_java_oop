package hus.oop.lab11.decorator_pattern.data_source_decorator;

public class EncryptionDecorator extends DataSourceDecorator{

    public EncryptionDecorator(DataSource wrappee) {
        super(wrappee);
    }

    @Override
    public void writeData(String data) {
        String encrypted = "ENCRYPTED(" + data + ")";
        System.out.println("[EncryptionDecorator] Encrypted data: " + encrypted);
        super.writeData(encrypted);
    }

    @Override
    public String readData() {
        String data = super.readData();
        String decrypted = data.replace("ENCRYPTED(", "").replace(")", "");
        System.out.println("[EncryptionDecorator] Decrypted data " + decrypted);
        return decrypted;
    }
}
