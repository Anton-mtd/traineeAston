public class Car implements Comparable <Car> {
    private String model;
    private Integer speed;

    public Car(String model, Integer speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public int compareTo(Car o) {
        if (this.speed == o.speed)
            return 0;
        return this.speed > o.speed? 1:-1;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
