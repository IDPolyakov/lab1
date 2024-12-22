public class Apple extends Food implements Nutritious {
    private String size;

    public Apple(String size) {
        super("Яблоко");
        this.size = size;
    }

    @Override
    public void consume() {
        System.out.println(this + " съедено.");
    }

    @Override
    public int calcCalories() {
        if (size.equalsIgnoreCase("маленькое")) {
            return 80;
        } else if (size.equalsIgnoreCase("среднее")) {
            return 100;
        } else if (size.equalsIgnoreCase("большое")) {
            return 120;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if(!super.equals(obj)) return false;
        if(!(obj instanceof Apple)) return false;
        Apple other = (Apple) obj;
        return this.size.equals(other.size);
    }

    @Override
    public String toString()
    {
        return super.toString() + "(" + size + ")";
    }

    @Override
    public String getName() {
        return super.toString();
    }

}
