import java.util.*;

public class QueueBuilder {
    private final List<Integer> originalList;

    public QueueBuilder(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не может быть null.");
        }
        this.originalList = new ArrayList<>(list);
    }

    public Queue<Integer> buildMirroredQueue() {
        Queue<Integer> queue = new LinkedList<>();
        int n = originalList.size();

        for (int i = 0; i < n; i++) {
            queue.offer(originalList.get(i));
        }
        for (int i = n - 1; i >= 0; i--) {
            queue.offer(originalList.get(i));
        }

        return queue;
    }

    @Override
    public String toString() {
        return "Очередь = " + originalList;
    }
}

