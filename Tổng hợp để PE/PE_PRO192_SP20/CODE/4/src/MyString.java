
public class MyString implements IString {

    @Override
    public int f1(String string) {
        int sum = 0;
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c) && Character.getNumericValue(c) % 2 == 0) {
                sum += Character.getNumericValue(c);
            }

        }
        return sum;
    }

    // remove even digit 
    @Override
    public String f2(String string) {
        StringBuilder s1 = new StringBuilder(string);
        // khi dùng delete của StringBuilder thì loop ngược chuỗi 
        for (int i = s1.length() - 1; i >= 0; i--) {
            char c = s1.charAt(i);
            if (Character.isDigit(c) && Character.getNumericValue(c) % 2 == 0) {
                s1.deleteCharAt(i);
            }

        }
        string = s1.toString();
        return string;
    }

}
