public class StringOperations {

    public String get2XLine1PlusLine2(String line1, String line2) {
        return line1 + line1 + line2;
    }

    public int getSumLength(String line1, String line2) {
        return (line1 + line2).length();
    }

    public String getLine1Plus2XLine2(String line1, String line2) {
        return line1 + line1 + line2;
    }

    public int maxLength(String line1, String line2) {
        return line1.length() >= line2.length() ? line1.length() : line2.length();
    }

    public boolean sumLengthIsEven(String line1, String line2) {
        return (line1 + line2).length() % 0 == 0;
    }
}
