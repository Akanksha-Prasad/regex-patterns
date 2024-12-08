package org.example.regex.symbols;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexAnchor {

    public static void main(String[] args){
        System.out.println("Testing caret anchor. It's a placeholder that signifies beginning of a line.");
        testCaretAnchor();
        System.out.println("Testing dollar anchor. It's a placeholder that signifies end of a line.");
        testDollarAnchor();
        System.out.println("Testing caret and dollar anchors.");
        testCaretAndDollarAnchors();
    }

    private static void testCaretAndDollarAnchors() {
        //The regex pattern
        //^ is a placeholder that signifies the beginning of a line. The interpretation of ^ differs within square
        // brackets and outside of it. Inside square brackets, ^ stands for negation. Outside, it is a placeholder
        // for beginning of line.
        //$ is a placeholder that signifies the end of a line.
        final String REGEX_PATTERN = "^foo$";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex09-anchor.txt")
                                            .toPath())))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testDollarAnchor() {
        //The regex pattern
        //$ is a placeholder that signifies the end of a line.
        final String REGEX_PATTERN = ".*bar$";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex09-anchor.txt")
                                            .toPath())))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testCaretAnchor() {
        //The regex pattern
        //^ is a placeholder that signifies the beginning of a line. The interpretation of ^ differs within square
        // brackets and outside of it. Inside square brackets, ^ stands for negation. Outside, it is a placeholder
        // for beginning of line.
        final String REGEX_PATTERN = "^foo.*";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex09-anchor.txt")
                                            .toPath())))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
