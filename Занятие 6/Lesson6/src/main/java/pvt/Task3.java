package pvt;

public class Task3 {
    public String getSum(String line1, String line2) {
        return line1 + line2;
    }

    public String getReverseSum(String line1, String line2, String line3) {
        return line3 + line2 + line1;
    }

    public int getLength(String line) {
        return line.length();
    }

    public String get2XLine1PlusLine2(String line1, String line2) {
        return line1 + line1 + line2;
    }

    public int getSumLength(String line1, String line2) {
        return (line1 + line2).length();
    }

    public String getLine1Plus2XLine2(String line1, String line2) {
        return line1 + line2 + line2;
    }

    public int maxLength(String line1, String line2) {
        return line1.length() >= line2.length() ? line1.length() : line2.length();
    }

    public boolean sumLengthIsEven(String line1, String line2) {
        return (line1 + line2).length() % 2 == 0;
    }

    public int getIntSum(int a, int b) {
        return a + b;
    }

    public int getMult(int a, int b) {
        return a * b;
    }
}
