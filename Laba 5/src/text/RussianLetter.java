package text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class RussianLetter {

    public static int countUniqueRussianLetters(String fileName) throws IOException {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым.");
        }

        Path path = Path.of(fileName);
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + path);
        }

        String text = Files.readString(path);
        Set<Character> uniqueLetters = new HashSet<>();

        for (char c : text.toCharArray()) {
            if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я')) {
                uniqueLetters.add(Character.toLowerCase(c));
            }
        }

        return uniqueLetters.size();
    }
}