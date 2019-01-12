package functional.programming.in.action.chapt1;

public class Orange extends Fruit {

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Orange(Integer weight) {
        this.weight = weight;
    }
}
