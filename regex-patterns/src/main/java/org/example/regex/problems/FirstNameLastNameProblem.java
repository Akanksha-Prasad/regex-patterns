package org.example.regex.problems;

import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstNameLastNameProblem {

    public static void main(String[] args){
        //The regex pattern
        //Asterisk represents zero or more occurrences of that character that precedes it
        final String REGEX_PATTERN = "([a-zA-Z]+)\\s([a-zA-Z]+)";
        String fileName = "classpath:regex/problems/" + "regex16-firstname-lastname.txt";

        //Create a Pattern object
        Pattern pattern = Pattern.compile(REGEX_PATTERN);

        //Read the input file line by line
        try(BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(
                            Files.newInputStream(ResourceUtils.getFile(fileName).toPath())))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(matcher.group(2) + ", " + matcher.group(1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
