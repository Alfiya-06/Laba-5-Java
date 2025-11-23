public class MeowCounter implements Meowable {
    private final Meowable meowable;
    private int count;

    public MeowCounter(Meowable meowable) {
        this.meowable = meowable;
    }

    @Override
    public void meow() {
        meowable.meow();
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Кот мяукнул " + count + " раза";
    }
}