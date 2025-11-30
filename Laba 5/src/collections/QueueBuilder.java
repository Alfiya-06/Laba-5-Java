package collections;

import java.util.*;

public class QueueBuilder {
    public static <T> Queue<T> buildMirroredQueue(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null.");
        }

        Queue<T> queue = new LinkedList<>();
        // Прямой проход
        for (T item : list) {
            queue.offer(item);
        }
        // Обратный проход
        for (int i = list.size() - 1; i >= 0; i--) {
            queue.offer(list.get(i));
        }
        return queue;
    }
}