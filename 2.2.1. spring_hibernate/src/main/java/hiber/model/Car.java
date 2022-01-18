package hiber.model;

import javax.persistence.*;


@Entity
public class Car {

    @Column(name = "model")
    String model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "series")
    int series;

    @Override
    public String toString() {
        return "Car{" + model +
                ", series=" + series +
                '}';
    }

    @OneToOne(mappedBy = "car")
    private User user;

    public Car(){
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car(String car) {
        this.model = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
