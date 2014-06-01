public class Table {

    public static void main(String[] args) {
        String[] firstLine = {"\u250C", "\u2500", "\u252C", "\u2500", "\u2510"};
        String[] secondLine = {"\u251C", "\u2500", "\u253C", "\u2500", "\u2524"};
        String[] thirdLine = {"\u2514", "\u2500", "\u2534", "\u2500", "\u2518"};
        String[][] allTheLines = {firstLine, secondLine, thirdLine};
        String between = "\u2502";
        String table = "";
        for (int i = 1; i < allTheLines.length + 1; i++) {
            System.out.println(rows(firstLine, secondLine, thirdLine, table, i));
            if (i == 1 | i == 2)
                System.out.println(bordersOfCell(between));
        }
    }

    public static String rows(String[]firstLine, String[]secondLine, String[]thirdLine, String table, int i) {
        if (i == 1) {
            for (int t = 0; t < firstLine.length; t++) {
                table += firstLine[t];
            }
            return table;
        }
        if (i == 2) {
            for (int t = 0; t < secondLine.length; t++) {
                table += secondLine[t];
            }
            return table;
        }
        if (i == 3) {
            for (int t = 0; t < thirdLine.length; t++) {
                table += thirdLine[t];
            }
            return table;
        }
        return "";
    }


    public static String bordersOfCell(String val) {
        String innerBordersLines = "";
        for (int i = 0; i < 3; i++) {
            if (i == 0)
                innerBordersLines += val;
            else
                innerBordersLines += "." + val;
        }
        return innerBordersLines;
    }
}
