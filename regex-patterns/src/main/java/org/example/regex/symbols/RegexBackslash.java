package org.example.regex.symbols;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexBackslash {

    public static void main(String[] args){
        System.out.println("Testing escaping period with backslash - x*\\.y*");
        testEscapingPeriodWithBackslash();
        System.out.println("Period is treated as as literal inside character class - x[#:.]y");
        testPeriodInsideCharacterClass();
        System.out.println("Caret symbol has a special meaning inside the character class, so it should be escaped - " +
                "x[#:\\^]y");
        escapeCaretInsideCharacterClass();
        System.out.println("Backslash symbol has a special meaning inside the character class, so it should be " +
                "escaped - x[#\\\\^]y");
        escapeBackslashInsideCharacterClass();
    }

    private static void escapeCaretInsideCharacterClass() {
        //The regex pattern
        //Caret symbol has a special meaning inside character class, so it should be escaped - x[#:\^]y
        final String REGEX_PATTERN = "x[#:\\^]y";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex08-symbols.txt")
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

    private static void escapeBackslashInsideCharacterClass() {
        //The regex pattern
        //Caret and backslash symbols have special meaning inside character class, so they should be escaped - x[#\\\^]y
        final String REGEX_PATTERN = "x[#\\\\^]y";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex08-symbols.txt")
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

    private static void testPeriodInsideCharacterClass() {
        //The regex pattern
        //Period is treated as as literal inside character class - x[#:.]y
        //So, it need not be escaped if it's present inside the character class
        final String REGEX_PATTERN = "x[#:.]y";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex08-symbols.txt")
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

    private static void testEscapingPeriodWithBackslash() {
        //The regex pattern
        //Backslash is used to treat the following character as a literal. If the character immediately after
        // backslash has a special meaning in regex, it is escaped and treated as a normal literal
        final String REGEX_PATTERN = "x*\\.y*";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex07-backslash.txt")
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
