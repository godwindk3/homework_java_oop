package hus.oop.lab4.ex_1_7;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
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

    public String toString() {
        if (this.imag >= 0) {
            return this.real + " + " + this.imag + "i";
        } else {
            return this.real + " - " + (-this.imag) + "i";
        }
    }

    public boolean isReal() {
        return imag == 0;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public boolean isImaginary() {
        return real == 0;
    }

    public boolean equals(double real, double imag) {
        return (this.real == real && this.imag == imag);
    }

    public boolean equals(MyComplex another) {
        return (this.real == another.real && this.imag == another.imag);
    }

    public double magnitude() {
        return Math.sqrt(this.imag * this.imag + this.real * this.real);
    }

    public MyComplex addInto(MyComplex right) {
        this.real += right.real;
        this.imag += right.imag;
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double newReal = this.real + right.real;
        double newImag = this.imag + right.imag;
        return new MyComplex(newReal, newImag);

    }

    public MyComplex subtract(MyComplex right) {
        this.real -= right.real;
        this.imag -= right.imag;
        return this;
    }

    public MyComplex subtractNew(MyComplex right) {
        double newReal = this.real - right.real;
        double newImag = this.imag - right.imag;
        return new MyComplex(newReal, newImag);
    }

    public MyComplex multiply(MyComplex right) {
        double resultReal = this.real * right.real - this.imag * right.imag;
        double resultImag = this.real * right.imag - this.imag * right.real;
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

    public double argument() {
        return Math.atan2(this.imag, this.real);
    }

    public MyComplex conjugate() {
        return new MyComplex(this.real, -this.imag);
    }
}
