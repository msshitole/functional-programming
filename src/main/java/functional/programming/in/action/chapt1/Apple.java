package functional.programming.in.action.chapt1;

public class Apple  extends  Fruit{

    private String color;
    private Integer weight;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Apple() {

    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple) {
        return  apple.getColor().equalsIgnoreCase("green");
    }

    public static boolean isHeavyApple(Apple apple) {
        return  apple.getWeight() >= 150;
    }

    @Override
    public String toString() {
        return "\nApple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }
}
