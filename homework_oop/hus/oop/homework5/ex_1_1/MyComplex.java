package hus.oop.homework5.ex_1_1;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.setReal(real);
        this.setImag(imag);
    }

    public String toString() {
        if (imag >= 0) {
            return "(" + real + "+" + imag + "i)";
        } else {
            return "(" + real + imag + "i)";
        }
    }

    public boolean isReal() {
        return this.getImag() == 0;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public boolean isImaginary() {
        return this.getReal() == 0;
    }

    public boolean equals(double real, double imag) {
        return (this.getImag() == imag) && (this.getReal() == real);
    }

    public boolean equals(MyComplex another) {
        return (this.getImag() == another.getImag()) && (this.getReal() == another.getReal());
    }

    public double magnitude() {
        return Math.sqrt(this.getReal() * this.getReal() + this.getImag() * this.getImag());
    }

    public double argument() {
        return Math.atan2(this.getImag(), this.getReal());
    }

    public MyComplex add(MyComplex right) {
        this.setReal(this.getReal() + right.getReal());
        this.setImag(this.getImag() + right.getImag());
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double newReal = this.getReal() + right.getReal();
        double newImag = this.getImag() + right.getImag();
        return new MyComplex(newReal, newImag);
    }

    public MyComplex subtractNew(MyComplex right) {
        double newReal = this.getReal() - right.getReal();
        double newImag = this.getImag() - right.getImag();
        return new MyComplex(newReal, newImag);
    }

    public MyComplex subtract(MyComplex right) {
        this.setReal(this.getReal() - right.getReal());
        this.setImag(this.getImag() - right.getImag());
        return this;
    }

    public MyComplex multiply(MyComplex right) {
        double resultReal = this.real * right.real - this.imag * right.imag;
        double resultImag = this.real * right.imag + this.imag * right.real;
        return new MyComplex(resultReal, resultImag);
    }

    public MyComplex divide(MyComplex right) {
        double denominator = right.real * right.real + right.imag * right.imag;
        if (denominator == 0) {
            throw new ArithmeticException("Division by zero");
        }
        double resultReal = (this.real * right.real + this.imag * right.imag) / denominator;
        double resultImag = (this.imag * right.real - this.real * right.imag) / denominator;
        return new MyComplex(resultReal, resultImag);
    }

    public MyComplex conjugate() {
        return new MyComplex(this.getReal(), -this.getImag());
    }


}
