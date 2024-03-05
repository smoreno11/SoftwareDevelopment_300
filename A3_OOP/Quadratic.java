public class Quadratic {

  private int a;
  private int b;
  private int c;
  private String comment;

    public Quadratic(int a, int b, int c) {
        setA(a);
        setB(b);
        setC(c);
        setComment();
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getComment() {
        return comment;
    }

    public int discriminant() {
        return b * b - 4 * a * c;
    }

    private void setComment() {
        if (a == 0) {
            comment = "Linear equation: one real root";
        } else if (discriminant() == 0) {
            comment = "Quadratic with one real root";
        } else if (discriminant() > 0) {
            comment = "Two distinct real roots";
        } else {
            comment = "Two distinct complex roots";
        }
    }

    public String toString() {
        return "Quadratic equation: " + a + "x^2 + " + b + "x + " + c + " = 0";
    }

    public boolean equals(Object o) {
        if (o instanceof Quadratic) {
            Quadratic other = (Quadratic) o;
            return this.a == other.a && this.b == other.b && this.c == other.c;
        }
        return false;
    }

    public ComplexPair solveQuadratic() {
        ComplexPair result;
        Complex firstRoot, secondRoot;

        int discrim = discriminant();

        if (a == 0) {
            firstRoot = new Complex(-c / b, 0);
            result = new ComplexPair(firstRoot, firstRoot);
        } else if (discrim == 0) {
            firstRoot = new Complex(-b / (2.0 * a), 0);
            result = new ComplexPair(firstRoot, firstRoot);
        } else if (discrim > 0) {
            firstRoot = new Complex((-b + Math.sqrt(discrim)) / (2.0 * a), 0);
            secondRoot = new Complex((-b - Math.sqrt(discrim)) / (2.0 * a), 0);
            result = new ComplexPair(firstRoot, secondRoot);
        } else {
            firstRoot = new Complex(-b / (2.0 * a), Math.sqrt(-discrim) / (2.0 * a));
            secondRoot = new Complex(-b / (2.0 * a), -Math.sqrt(-discrim) / (2.0 * a));
            result = new ComplexPair(firstRoot, secondRoot);
        }

        return result;
    }
  
}
