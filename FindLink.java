import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegPhraseLink {

    public static void main(String[] args) {
        String text = readFile("PageHTML.txt");
        findMatch(text);
    }

    private static String readFile(String fileName) {
        String encoding = "windows-1251"; //utf-8
        int BUFFER_SIZE = 4096;
        StringBuilder result = new StringBuilder();
        char[] buffer = new char[BUFFER_SIZE];

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName), encoding);
            BufferedReader in = new BufferedReader(reader);
            int read;
            while ((read = in.read(buffer)) > 0)
                result.append(buffer, 0, read);
            return result.toString();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unknown encoding " + encoding);
        } catch (Exception e) {
            System.err.println("Failed to read file " + new File(fileName).getAbsolutePath());
        }

        return null;
    }

    public static void findMatch(String filename) {
        int n = 1;
        Pattern pattern = Pattern.compile("<\\s*a\\s*href\\s*=\\s*\"http://(.+?\\Q.\\E(com|ru|org|net)/?.*?)\"");
        Matcher matcher = pattern.matcher(filename);
        while (matcher.find()) {
            System.out.println("Found " + n + ": " + matcher.group(1));
            n += 1;
        }
    }
}
