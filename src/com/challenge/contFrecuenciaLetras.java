package com.challenge;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class contFrecuenciaLetras {

    public static void main(String[] args) {

        String content = readFile("texto.txt");

        if (content != null) {
            printStatistics(content);
        }

    }

    private static String readFile(String path) {

        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }

    }

    private static void printStatistics(String content) {

        int characterCount = content
                .replace("\n", "")
                .replace("\r", "")
                .length();

        String[] words = content
                .toLowerCase()
                .split("\\s+");

        long wordCount = Arrays.stream(words)
                .filter(word -> !word.isBlank())
                .count();

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {

            if (!word.isBlank()) {

                frequencyMap.put(
                        word,
                        frequencyMap.getOrDefault(word, 0) + 1
                );

            }

        }

        System.out.println(wordCount + " words");
        System.out.println(characterCount + " characters");
        System.out.println();

        frequencyMap.entrySet()
                .stream()
                .sorted(
                        Comparator
                                .<Map.Entry<String, Integer>>comparingInt(Map.Entry::getValue)
                                .reversed()
                                .thenComparing(Map.Entry::getKey)
                )
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + ": " + entry.getValue()
                        )
                );
    }
}