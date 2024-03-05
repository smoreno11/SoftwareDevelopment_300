public class Complex {

  private double real;
  private double imaginary;

    public Complex(double real, double imaginary) {
        setReal(real);
        setImaginary(imaginary);
    }


    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public boolean isReal() {
        return imaginary == 0;
    }

    public String toString() {
        if (imaginary == 0) {
            return String.format("%.2f", real);
        } else if (real == 0) {
            return String.format("%.2fi", imaginary);
        } else {
            return String.format("%.2f + %.2fi", real, imaginary);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof Complex) {
            Complex other = (Complex) o;
            return this.real == other.real && this.imaginary == other.imaginary;
        }
        return false;
    }
  
}
