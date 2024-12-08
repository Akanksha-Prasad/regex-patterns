package org.example.regex.symbols;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexCharacterClass {

    public static void main(String[] args){
        System.out.println("Testing inclusion list - [fcl]oo");
        testCharacterClassForInclusionList();
        System.out.println("Testing exclusion list - [^mh]oo");
        testCharacterClassForExclusionList();
        System.out.println("Testing range - [b-d]oo");
        testCharacterClassForRange();
        System.out.println("Testing range + character combo - [b-dp]oo");
        testCharacterClassRangeCharacterCombo();
        System.out.println("Testing multiple range + character combo - [j-mJ-Mz]oo");
        testCharacterClassMultipleRangeCharacterCombo();
    }

    private static void testCharacterClassForInclusionList() {
        //The regex pattern
        //[abc] - character class represents any one of the characters inside the square brackets, in a single position
        final String REGEX_PATTERN = "[fcl]oo";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex05-character-class.txt")
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

    private static void testCharacterClassForExclusionList() {
        //The regex pattern
        //[^abc] - character class represents any one character except the ones inside the square brackets, in a single
        // position
        final String REGEX_PATTERN = "[^mh]oo";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex05-character-class.txt")
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

    private static void testCharacterClassForRange() {
        //The regex pattern
        //[abc] - character class represents any one of the characters in the range given inside the square brackets,
        // in a single position
        final String REGEX_PATTERN = "[b-d]oo";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex05-character-class.txt")
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

    private static void testCharacterClassRangeCharacterCombo() {
        //The regex pattern
        //[abc] - character class represents any one of the characters in the range given inside the square brackets,
        // in a single position
        final String REGEX_PATTERN = "[b-dp]oo";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(
                                    ResourceUtils.getFile("classpath:regex/symbols/regex05-character-class.txt")
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

    private static void testCharacterClassMultipleRangeCharacterCombo() {
        //The regex pattern
        //[a-cA-cx] - character class represents any one of the characters in any of the ranges given inside the square
        // brackets or, the characters following the ranges in a single position
        final String REGEX_PATTERN = "[j-mJ-Mz]oo";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(Files.newInputStream(
                            ResourceUtils.getFile(
                                    "classpath:regex/symbols/regex06-character-class-range-character-combo.txt")
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
