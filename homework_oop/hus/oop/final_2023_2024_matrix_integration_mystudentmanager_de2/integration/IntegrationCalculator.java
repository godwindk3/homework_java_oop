package hus.oop.final_2023_2024_matrix_integration_mystudentmanager_de2.integration;

public class IntegrationCalculator {
    private Integrator integrator;
    private Polynomial poly;

    /**
     * Hàm dựng, khởi tạo đa thức cần tính tích phân.
     *
     * @param poly
     */
    public IntegrationCalculator(Polynomial poly) {
        /* TODO */
        this.poly = poly;
        this.integrator = null;
    }

    /**
     * Hàm dựng, khởi tạo phương pháp tính tích phân và đa thức cần tính tích phân.
     *
     * @param integrator
     * @param poly
     */
    public IntegrationCalculator(Integrator integrator, Polynomial poly) {
        /* TODO */
        this.integrator = integrator;
        this.poly = poly;
    }

    public void setPoly(Polynomial poly) {
        /* TODO */
        this.poly = poly;
    }

    public void setIntegrator(Integrator integrator) {
        /* TODO */
        this.integrator = integrator;
    }

    public double integrate(double lower, double upper) {
        /* TODO */
        if (integrator == null) {
            throw new IllegalStateException("Integrator chưa được thiết lập.");
        }
        if (poly == null) {
            throw new IllegalStateException("Polynomial chưa được thiết lập.");
        }
        return integrator.integrate(poly, lower, upper);
    }
}
