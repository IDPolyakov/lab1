public abstract class Food implements Consumable {

    protected String name = null;

    public Food(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Food)) return false;
        Food other = (Food) obj;
        return this.name != null && this.name.equals(other.name);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }


    @Override
    public void consume() {
    }
}
