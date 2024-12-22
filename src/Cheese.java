public class Cheese extends Food implements Nutritious {

    public Cheese(String name) {
        super("Сыр");
    }

    @Override
    public void consume() {
        System.out.println(this + " съеден");
    }

    @Override
    public int calcCalories() {
        return 300;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        return obj instanceof Cheese;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String getName() {
        return super.toString();
    }
}