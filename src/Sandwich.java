public class Sandwich extends Food implements Nutritious {
    private String filling1;
    private String filling2;

    public Sandwich(String filling1, String filling2) {
        super("Сэндвич");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    @Override
    public void consume() {
        System.out.println("Сэндвич с " + filling1.toUpperCase() + " и " + filling2.toUpperCase() + " съеден");
    }

    @Override
    public int calcCalories() {
        int cal = 0;
        if (filling1.equalsIgnoreCase("сыр")) cal += 200;
        if (filling2.equalsIgnoreCase("ветчина")) cal += 250;
        if (filling2.equalsIgnoreCase("салями")) cal += 300;
        if (filling1.equalsIgnoreCase("чедр")) cal += 270;
        return cal;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Sandwich)) return false;
        Sandwich other = (Sandwich) obj;
        return this.filling1.equals(other.filling1) && other.filling2.equals(other.filling2);
    }

    @Override
    public String toString() {
        return super.toString() + " с " + filling1 + " и " + filling2;
    }

    @Override
    public String getName(){
        return super.toString();
    }

}
