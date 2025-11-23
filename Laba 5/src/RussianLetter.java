import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;

public class RussianLetter {

    private final Path filePath;
    private final Set<Character> letters;

    public RussianLetter(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя файла не может быть пустым.");
        }
        this.filePath = Path.of(fileName);
        this.letters = new LinkedHashSet<>(); // ✅ Вот тут изменение
    }

    public void countLetters() throws IOException {

        if (!Files.exists(filePath)) {
            throw new IOException("Файл не найден: " + filePath);
        }

        String text = Files.readString(filePath);

        for (char c : text.toCharArray()) {
            if ((c >= 'А' && c <= 'Я') || (c >= 'а' && c <= 'я')) {
                letters.add(Character.toLowerCase(c));
            }
        }
    }

    public int getUniqueCount() {
        return letters.size();
    }

    public Set<Character> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        return "Уникальные русские буквы: " + letters +
                "\nКоличество: " + letters.size();
    }
}