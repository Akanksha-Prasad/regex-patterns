package org.example.regex.symbols;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCurlyBracesRepeater {

    public static void main(String[] args){
        System.out.println("a{m} represents that a should be repeated m times");
        System.out.println("Testing ^[0-9]{3}$ -");
        testCurlyBracesRepeater();
        System.out.println("a{m,n} represents that a should be repeated at least m times and at most n times");
        System.out.println("Testing ^[0-9]{2,4}$ -");
        testCurlyBracesRepeaterRange();
    }

    private static void testCurlyBracesRepeater() {
        //The regex pattern
        //{m} represents that the character preceding it should be repeated m times
        final String REGEX_PATTERN = "^[0-9]{3}$";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils
                                            .getFile("classpath:regex/symbols/regex10-curly-braces-repeater.txt")
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

    private static void testCurlyBracesRepeaterRange() {
        //The regex pattern
        //a{m,n} represents that a should be repeated at least m times and at most n times
        final String REGEX_PATTERN = "^[0-9]{2,4}$";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils
                                            .getFile("classpath:regex/symbols/regex10-curly-braces-repeater.txt")
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
