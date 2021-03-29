package ru.savalek.espserver;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;

public class Minifier {

    private static final String HTML_PATH = "/home/saval/IdeaProjects/ESP Server/src/main/java/ru/savalek/espserver/Panel.html";
    private static final String RESULT_PATH = "/home/saval/IdeaProjects/ESP Server/src/main/java/ru/savalek/espserver/result.txt";

    public static void main(String[] args) throws Exception {
        String htmlString = FileUtils.readFileToString(new File(HTML_PATH), Charset.defaultCharset());
        htmlString = htmlString.replaceAll("\\n", "");
        htmlString = htmlString.replaceAll("\\t", "");
        htmlString = htmlString.replaceAll(" +", " ");
        htmlString = htmlString.replaceAll("\"", "'");
        htmlString = String.format("    String s = \"HTTP/1.1 200 OK\\r\\nContent-Type: text/html\\r\\n\\r\\n%s\";\n", htmlString);
        FileUtils.write(new File(RESULT_PATH), htmlString, Charset.defaultCharset());
    }
}
