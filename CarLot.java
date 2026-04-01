package com;

import java.util.ArrayList;

public class CarLot {

    private ArrayList<Car> inventory;

    public CarLot() {
        inventory = new ArrayList<>();
    }

    public ArrayList<Car> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Car> inventory) {
        this.inventory = inventory;
    }

    public Car findCarByIdentifier(String identifier) {
        for (Car c : inventory) {
            if (c.getId().equals(identifier)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Car> getCarsInOrderOfEntry() {
        return new ArrayList<>(inventory);
    }

    public ArrayList<Car> getCarsSortedByMPG() {
        ArrayList<Car> sortedList = new ArrayList<>(inventory);
        int n = sortedList.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (sortedList.get(j).getMpg() > sortedList.get(maxIndex).getMpg()) {
                    maxIndex = j;
                }
            }

            Car temp = sortedList.get(i);
            sortedList.set(i, sortedList.get(maxIndex));
            sortedList.set(maxIndex, temp);
        }

        return sortedList;
    }

    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
        Car newCar = new Car(id, mileage, mpg, cost, salesPrice);
        inventory.add(newCar);
    }

    public void sellCar(String identifier, double priceSold) {
        Car car = findCarByIdentifier(identifier);
        if (car != null) {
            car.sellCar(priceSold);
        }
    }

    public Car getCarWithBestMPG() {
        if (inventory.isEmpty()) return null;
        Car best = inventory.get(0);
        for (Car c : inventory) {
            if (c.getMpg() > best.getMpg()) {
                best = c;
            }
        }
        return best;
    }

    public Car getCarWithHighestMileage() {
        if (inventory.isEmpty()) return null;
        Car highest = inventory.get(0);
        for (Car c : inventory) {
            if (c.getMileage() > highest.getMileage()) {
                highest = c;
            }
        }
        return highest;
    }

    public double getAverageMpg() {
        if (inventory.isEmpty()) return 0.0;
        double sum = 0;
        for (Car c : inventory) {
            sum += c.getMpg();
        }
        return sum / inventory.size();
    }

    public double getTotalProfit() {
        double total = 0;
        for (Car c : inventory) {
            total += c.getProfit();
        }
        return total;
    }

    public void saveToDisk() {
    }

    public ArrayList<Car> loadFromDisk() {
        return new ArrayList<>();
    }
}
