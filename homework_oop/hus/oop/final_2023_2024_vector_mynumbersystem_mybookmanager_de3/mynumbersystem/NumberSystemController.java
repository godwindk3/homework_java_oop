package hus.oop.final_2023_2024_vector_mynumbersystem_mybookmanager_de3.mynumbersystem;

import java.util.ArrayList;
import java.util.List;

public class NumberSystemController {
    private ANumber originalNumber;
    private List<NumberSystemConverter> converters;  // Danh sách các converter theo observer pattern

    public NumberSystemController() {
        /* TODO */
        // Khởi tạo ANumber mặc định (score 0 ở hệ 10)
        this.originalNumber = new ANumber("0", 10);
        this.converters = new ArrayList<>();
    }

    /**
     * Thêm vào converter để quan sát số ban đầu.
     * @param converter
     */
    public void registerConverter(NumberSystemConverter converter) {
        /* TODO */
        if (!converters.contains(converter)) {
            converters.add(converter);
        }
        // Khi mới đăng ký, ta muốn converter ngay lập tức có state phù hợp với originalNumber
        converter.update(originalNumber);
    }

    /**
     * Hủy quan sát số ban đầu của converter.
     * @param converter
     */
    public void unregisterConverter(NumberSystemConverter converter) {
        /* TODO */
        converters.remove(converter);
    }

    /**
     * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
     * các converter đang ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
     */
    public void notifyConverters() {
        /* TODO */
        for (NumberSystemConverter conv : converters) {
            conv.update(originalNumber);
            conv.display();
        }
    }

    public String getNumberPresentation() {
        /* TODO */
        return originalNumber.getNumberPresentation();
    }

    public void setNumberPresentation(String numberPresentation) {
        /* TODO */
        originalNumber.setNumberPresentation(numberPresentation);
        onStateChanged();
    }

    public int getRadix() {
        /* TODO */
        return originalNumber.getRadix();
    }

    public void setRadix(int radix) {
        /* TODO */
        originalNumber.setRadix(radix);
        onStateChanged();
    }

    /**
     * Được gọi khi có sự thay đổi về trạng thái (biểu diến số hoặc cơ số),
     * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đang ký quan sát
     * cập nhật lại trạng thái.
     */
    private void onStateChanged() {
        /* TODO */
        notifyConverters();
    }
}
