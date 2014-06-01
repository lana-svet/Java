public class Table2 {

    public static void main(String[] args) {
        int m = 5;
        int n = 3;

        String[] body1 = {"\u252C", "\u2500"};
        String[] body2 = {"\u253C", "\u2500"};
        String[] body3 = {"\u2534", "\u2500"};
        String[] heads = {"\u250C", "\u251C", "\u2514"};
        String[] tails = {"\u2510", "\u2524", "\u2518"};

        System.out.println(makeLine(heads[0], m, body1, tails[0]));
        linesRepeat(n, m, "\u2502", tails, heads, body2);
        System.out.println(betweenString("\u2502", m));
        System.out.println(makeLine(heads[2], m, body3, tails[2]));
    }

    public static String innerLine(int m, String[] oneMass) {
        String someString = "";
        for (int i = 1; i < m; i++) {
            for (int t = 0; t < 2; t++) {
                someString += oneMass[t];
            }
        }
        return someString;
    }

    public static String makeLine(String head, int m, String[] body, String tail){
        String newStr = head;
        newStr += "\u2500";
        newStr += innerLine(m, body);
        newStr += tail;
        return newStr;
    }

    public static String betweenString(String someStr, int m) {
        String betwString = "";
        for (int i = 0; i < m; i++) {
            betwString += someStr;
            betwString += " ";
        }
        betwString += someStr;
        return betwString;
    }

    public static void linesRepeat(int n, int m, String someStr, String[] tails, String[] heads, String[] body2) {
        for (int i = 0; i < n - 1; i++) {
            System.out.println(betweenString(someStr, m));
            System.out.println(makeLine(heads[1], m, body2, tails[1]));
        }
    }
}
