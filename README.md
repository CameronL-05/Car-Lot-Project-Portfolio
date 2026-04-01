# Car Lot Project Portfolio

A small Java application that simulates a car lot inventory system. This project is a portfolio piece to demonstrate object-oriented programming fundamentals and clean separation between data models and business logic.

## Project Structure (Major Classes)

- **`Car`**  
  Represents a single vehicle (ex: make, model, year, price). Typically includes constructors, getters/setters, and a `toString()` for readable output.

- **`CarLot`**  
  Manages the inventory (a collection of `Car` objects) and contains the core business logic for adding, removing, listing, and searching cars.

- **`Main` / `App` (Driver)**  
  Runs the program and handles user interaction (menu / input / output). Calls `CarLot` methods to perform actions while keeping logic out of the UI layer.

## Key Behaviors (Common Methods)

- **Add inventory:** `CarLot.addCar(...)` adds a new `Car` to the lot  
- **Remove inventory:** `CarLot.removeCar(...)` removes a car (by id/index or matching criteria)  
- **View inventory:** `CarLot.listCars()` / `getInventory()` shows what’s available  
- **Search/filter:** methods like `search(...)` or `filterByMake/Model/Year(...)` return matching cars

## Tech Stack

- Java
