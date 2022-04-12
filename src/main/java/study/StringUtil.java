package study;

public class StringUtil {
    public  String[] SplitByComma(String value) {
        String[] result = value.split(",");
        return result;
    }

    public String RemoveBrakets(String value) {
        int start = value.indexOf("(") + 1;
        int end = value.indexOf(")");
        String result = value.substring(start, end);

        return result;
    }

    public char GetAt(String value, int index) throws StringIndexOutOfBoundsException {
        char picked;

        if (index >= value.length()) {
            throw new StringIndexOutOfBoundsException("String index out of range: " + index);
        }

        picked = value.charAt(index);
        return picked;
    }
}
