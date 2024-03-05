public class ComplexPair {
  
  private Complex first;
  private Complex second;

    public ComplexPair(Complex first, Complex second) {
        setFirst(first);
        setSecond(second);
    }

    public Complex getFirst() {
        return first;
    }

    public void setFirst(Complex first) {
        this.first = first;
    }

    public Complex getSecond() {
        return second;
    }

    public void setSecond(Complex second) {
        this.second = second;
    }

    public boolean bothIdentical() {
        return first.equals(second);
    }

    public String toString() {
        return "Solutions: first: " + first + "; second: " + second;
    }

    public boolean equals(Object o) {
        if (o instanceof ComplexPair) {
            ComplexPair other = (ComplexPair) o;
            return this.first.equals(other.first) && this.second.equals(other.second);
        }
        return false;
    }
}
