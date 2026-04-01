# Car Lot Project Portfolio

A Java project that models a simple car lot management system. This repository is intended as a portfolio piece demonstrating object-oriented programming concepts such as encapsulation, data management, and a menu-driven console application.

## Features

- Add cars to the lot's inventory
- Sell cars and track profit
- View inventory in order of acquisition or sorted by fuel efficiency
- Find the car with the best MPG or highest mileage
- Calculate average MPG and total profit across the lot

## Tech Stack

- Java

---

## Project Structure

All classes are in the `com` package.

| File | Class | Role |
|---|---|---|
| `Car.java` | `Car` | Represents a single car with its attributes and behaviors |
| `CarLot.java` | `CarLot` | Manages a collection of `Car` objects (the inventory) |
| `CarLotMain.java` | `CarLotMain` | Entry point — interactive menu-driven CLI |
| `CarTester.java` | `CarTester` | Manual test runner that exercises `Car` methods |

---

## Class Documentation

### `Car`

Represents an individual car on the lot. Each `Car` stores information about its identity, condition, pricing, and sale status.

**Fields**

| Field | Type | Description |
|---|---|---|
| `id` | `String` | Unique identifier for the car (e.g. `"2010 Kia Soul"`) |
| `mileage` | `int` | Odometer reading in miles |
| `mpg` | `int` | Fuel efficiency in miles per gallon |
| `cost` | `double` | Amount the lot paid to acquire the car |
| `salesPrice` | `double` | Asking price listed for the car |
| `isSold` | `boolean` | Whether the car has been sold (`false` by default) |
| `priceSold` | `double` | The actual price the car was sold for (`0.0` until sold) |
| `profit` | `double` | `priceSold - cost`, calculated at the time of sale |

**Constructors**

- `Car()` — Default constructor; creates a car with empty/zero values.
- `Car(String id, int mileage, int mpg, double cost, double salesPrice)` — Parameterized constructor; initializes all primary fields and sets `isSold` to `false`, `priceSold` and `profit` to `0.0`.

**Getters** (return the corresponding field value)

- `getId()` → `String`
- `getMileage()` → `int`
- `getMpg()` → `int`
- `getCost()` → `double`
- `getSalesPrice()` → `double`
- `getIsSold()` → `boolean`
- `getPriceSold()` → `double`
- `getProfit()` → `double`

**Setters** (update the corresponding field value)

- `setId(String newId)`
- `setMileage(int newMileage)`
- `setMpg(int newMpg)`
- `setCost(double newCost)`
- `setSalesPrice(double newSalesPrice)`

**Other Methods**

- `sellCar(double priceSold)` — Marks the car as sold by setting `isSold` to `true`, recording the sale price, and calculating `profit = priceSold - cost`.
- `compareMPG(Car otherCar)` → `int` — Compares this car's MPG to `otherCar`'s MPG. Returns `-1` if lower, `1` if higher, `0` if equal.
- `compareMiles(Car otherCar)` → `int` — Compares this car's mileage to `otherCar`'s mileage. Returns `-1` if lower, `1` if higher, `0` if equal.
- `comparePrice(Car otherCar)` → `int` — Compares this car's cost to `otherCar`'s cost. Returns `-1` if lower, `1` if higher, `0` if equal.
- `toString()` → `String` — Returns a multi-line formatted string showing all fields (ID, mileage, MPG, cost, sales price, sold status, price sold, and profit).

---

### `CarLot`

Manages the car lot's full inventory. Internally it stores a list of `Car` objects and provides methods to add, sell, find, sort, and analyse them.

**Fields**

| Field | Type | Description |
|---|---|---|
| `inventory` | `ArrayList<Car>` | The list of all cars currently tracked by the lot |

**Constructor**

- `CarLot()` — Creates a new, empty inventory list.

**Inventory Management**

- `addCar(String id, int mileage, int mpg, double cost, double salesPrice)` — Creates a new `Car` with the given details and appends it to `inventory`.
- `sellCar(String identifier, double priceSold)` — Finds the car with the matching `id` and calls `car.sellCar(priceSold)` on it. Does nothing if no matching car is found.
- `getInventory()` → `ArrayList<Car>` — Returns the raw inventory list.
- `setInventory(ArrayList<Car> inventory)` — Replaces the entire inventory list with the provided one.

**Search & Retrieval**

- `findCarByIdentifier(String identifier)` → `Car` — Iterates through inventory and returns the first `Car` whose `id` equals `identifier`. Returns `null` if not found.
- `getCarsInOrderOfEntry()` → `ArrayList<Car>` — Returns a copy of the inventory in the order cars were added.
- `getCarsSortedByMPG()` → `ArrayList<Car>` — Returns a copy of the inventory sorted from highest to lowest MPG (selection sort).
- `getCarWithBestMPG()` → `Car` — Scans inventory and returns the `Car` with the highest MPG. Returns `null` if inventory is empty.
- `getCarWithHighestMileage()` → `Car` — Scans inventory and returns the `Car` with the highest mileage. Returns `null` if inventory is empty.

**Aggregate Statistics**

- `getAverageMpg()` → `double` — Calculates and returns the mean MPG across all cars in inventory. Returns `0.0` if inventory is empty.
- `getTotalProfit()` → `double` — Sums and returns the `profit` field of every car in inventory (unsold cars contribute `0.0`).

**Persistence (Stub)**

- `saveToDisk()` — Placeholder method intended for saving inventory to a file. Currently does nothing.
- `loadFromDisk()` → `ArrayList<Car>` — Placeholder method intended for loading inventory from a file. Currently returns an empty list.

---

### `CarLotMain`

The entry point for the application. Creates a `CarLot` instance and runs an interactive console menu that lets a user manage the lot during a session.

**Execution Flow**

1. A `CarLot` object is created.
2. A `Scanner` reads user input from `System.in`.
3. A numbered menu is printed repeatedly in a `do-while` loop until the user selects option `0` (Exit).
4. Each menu option maps to a `CarLot` or display action:

| Option | Action |
|---|---|
| `0` | Exit the program |
| `1` | Prompt for car details and call `lot.addCar(...)` |
| `2` | Prompt for car ID and sale price, then call `lot.sellCar(...)` |
| `3` | Call `lot.saveToDisk()` |
| `4` | Call `lot.loadFromDisk()` |
| `5` | Print all cars via `lot.getCarsInOrderOfEntry()` |
| `6` | Print all cars via `lot.getCarsSortedByMPG()` |
| `7` | Print the result of `lot.getCarWithBestMPG()` |
| `8` | Print the result of `lot.getCarWithHighestMileage()` |
| `9` | Print the result of `lot.getAverageMpg()` |
| `10` | Print the result of `lot.getTotalProfit()` |

---

### `CarTester`

A standalone manual test class used to verify the behavior of the `Car` class. It does not use a testing framework; it prints results to the console for visual inspection.

**What it tests**

1. **Default constructor** — Creates a `Car` with no arguments and prints it via `toString()`.
2. **Parameterized constructor** — Creates two `Car` objects with known values and prints them.
3. **`sellCar` method** — Sells both test cars at specified prices and prints the updated state (including calculated profit).
4. **Comparison methods** — Tests `compareMiles`, `compareMPG`, and `comparePrice` for negative (`-1`), equal (`0`), and positive (`1`) return values by adjusting field values with setters between assertions.

Errors are caught by a top-level `try/catch` that prints to `System.err`.
