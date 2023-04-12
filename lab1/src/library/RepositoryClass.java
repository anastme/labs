import java.util.Scanner;
import java.util.ArrayList;


public class RepositoryClass {
    private ArrayList<Car> cars = new ArrayList<Car>();
    public Car[] getCars(){
        Car[] ncars = new Car[cars.size()];
        ncars = cars.toArray(ncars);
        return ncars;
    }
    public void addNewCar(String brand, String model, int w){
        cars.add(new Car(brand, model,w));
    }

    public void updateCar(int c_ID, String brand, String model, int w) {
        cars.set(c_ID, new Car(brand, model, w));
    }

    public void removeCar(int id){
        cars.remove(id-1);
    }
}
