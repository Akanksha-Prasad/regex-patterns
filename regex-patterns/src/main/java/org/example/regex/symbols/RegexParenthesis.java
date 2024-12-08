package org.example.regex.symbols;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParenthesis {
    public static void main(String[] args){
        System.out.println("Contains at least 4 occurrences - (ha){4,}");
        testLeastOccurrences();
        System.out.println("Contains at max 2 occurrences - ^(ha){,2}$");
        testMaxOccurrences();
    }

    private static void testMaxOccurrences() {
        //The regex pattern
        //Parenthesis () is used to group and treat as a single entity.
        //{,m} represents at max 'm' repetitions of whatever immediately precedes this.
        final String REGEX_PATTERN = "^(ha){0,2}$";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex11-parenthesis.txt")
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

    private static void testLeastOccurrences() {
        //The regex pattern
        //Parenthesis () is used to group and treat as a single entity.
        //{m,} represents at least 'm' repetitions of whatever immediately precedes this.
        final String REGEX_PATTERN = "(ha){4,}";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex11-parenthesis.txt")
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
