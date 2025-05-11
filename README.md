# Parking Lot

The design for the **Parking Lot System** is based on several key **Object-Oriented Design** principles and utilizes multiple **Design Patterns** to ensure scalability, flexibility, and maintainability. Below is a detailed explanation of the design patterns used and the overall architecture.

---

### **Low-Level Design (LLD) Explanation**

The **Parking Lot System** is built to manage parking spots, handle vehicle entries and exits, calculate parking charges, and ensure that the system is flexible to accommodate different types of vehicles and parking spots. Here's a breakdown of the design, including the patterns:

---

### **Key Classes and Components**

1. **ParkingSpot**
2. **Vehicle (abstract) and its subclasses (CompactVehicle, RegularVehicle, LargeVehicle)**
3. **SpotType enum**
4. **Gate (abstract) and its subclasses (EntryGate, ExitGate)**
5. **Floor**
6. **Ticket**
7. **VehicleFactory**
8. **ParkingLotApplication**
9. **Design Patterns Used**

---

### **Design Patterns Used**

1. **Factory Method Pattern**
2. **Strategy Pattern**
3. **Singleton Pattern**
4. **Composite Pattern**
5. **Template Method Pattern**

Let's explore these patterns in more detail:

---

### **1. Factory Method Pattern**

**Usage:**

* The `VehicleFactory` class is an example of the **Factory Method** pattern. It is used to create different types of vehicles based on the vehicle type selected by the user.

**Explanation:**

* Instead of directly instantiating vehicle classes like `CompactVehicle`, `RegularVehicle`, or `LargeVehicle`, the `VehicleFactory` provides a method (`getVehicle`) that takes the `SpotType` and other necessary details as input, and returns an appropriate vehicle object. This centralizes the creation of vehicle objects and decouples the client code from knowing the exact vehicle class to instantiate.

```java
public class VehicleFactory {

    public static Vehicle getVehicle(String licenseNumber, String ownerName, SpotType spotType) {
        switch (spotType) {
            case COMPACT:
                return new CompactVehicle(licenseNumber, ownerName);
            case REGULAR:
                return new RegularVehicle(licenseNumber, ownerName);
            case LARGE:
                return new LargeVehicle(licenseNumber, ownerName);
            default:
                throw new IllegalArgumentException("Invalid Spot Type");
        }
    }
}
```

**Benefits:**

* This pattern promotes **loose coupling** and **open/closed principle**. The system can easily be extended to support new vehicle types without modifying existing code, simply by adding a new vehicle class and updating the factory method.

---

### **2. Strategy Pattern**

**Usage:**

* The `calculateAmount` method in the `Vehicle` class is an example of the **Strategy** pattern.

**Explanation:**

* The base `Vehicle` class provides a `calculateAmount` method, which is abstract. Each subclass (`CompactVehicle`, `RegularVehicle`, `LargeVehicle`) provides its own implementation of `calculateAmount`. The strategy pattern is applied here because the calculation algorithm changes based on the vehicle type.

```java
public abstract class Vehicle {
    private String licenseNumber;
    private String ownerName;
    private SpotType spotType;

    // Abstract method for calculating amount
    public abstract double calculateAmount(LocalDateTime entryTime, LocalDateTime exitTime);
}
```

* The system can easily introduce new vehicle types or parking fee calculation strategies without changing the core logic.

**Benefits:**

* **Flexibility**: Different behaviors for different vehicle types can be encapsulated within individual classes, making it easier to introduce new strategies.
* **Extensibility**: New types of vehicles or new strategies for calculating amounts can be added without modifying the existing codebase.

---

### **3. Singleton Pattern**

**Usage:**

* The `ParkingLotApplication` class is an implementation of the **Singleton** pattern.

**Explanation:**

* The `ParkingLotApplication` class is designed to have only one instance throughout the system, which ensures that the parking lot system’s core logic and the state (such as the list of available parking spots and tickets) are managed centrally.

```java
public class ParkingLotApplication {
    private static ParkingLotApplication instance;

    private ParkingLotApplication() {
        // Initialize parking lot system
    }

    public static ParkingLotApplication getInstance() {
        if (instance == null) {
            instance = new ParkingLotApplication();
        }
        return instance;
    }
}
```

**Benefits:**

* **Centralized Control**: The singleton pattern ensures that only one instance of `ParkingLotApplication` exists, providing centralized control over the parking lot system’s operations.
* **Global Access**: The singleton instance can be accessed globally across the system without needing to pass around the instance.

---

### **4. Composite Pattern**

**Usage:**

* The `Floor` class and its management of different types of `ParkingSpot` is an example of the **Composite** pattern.

**Explanation:**

* In the parking lot, a `Floor` consists of several parking spots of different types (`COMPACT`, `REGULAR`, and `LARGE`). The `Floor` class holds these parking spots in a `Map` where the key is the spot type and the value is a list of `ParkingSpot` objects.
* The `Composite` pattern allows you to treat individual objects (like a single parking spot) and composites (like a floor containing many parking spots) uniformly.

```java
public class Floor {
    private Map<SpotType, List<ParkingSpot>> parkingSpots;

    public Floor(int floorNumber) {
        this.parkingSpots = new HashMap<>();
        parkingSpots.put(SpotType.COMPACT, new ArrayList<>());
        parkingSpots.put(SpotType.REGULAR, new ArrayList<>());
        parkingSpots.put(SpotType.LARGE, new ArrayList<>());
    }
}
```

**Benefits:**

* **Uniformity**: Both individual parking spots and collections of parking spots (on a floor) can be treated uniformly.
* **Ease of Management**: Adding new parking spots to a floor and organizing them based on their spot type becomes easier.

---

### **5. Template Method Pattern**

**Usage:**

* The abstract class `Gate` and its subclasses `EntryGate` and `ExitGate` demonstrate the **Template Method** pattern.

**Explanation:**

* The `Gate` class defines the `run()` method as an abstract method and provides a common structure for how entry and exit gates should function. Each subclass (`EntryGate` and `ExitGate`) overrides this method to implement specific behaviors (such as handling vehicle entries or calculating parking fees upon exit).

```java
public abstract class Gate {
    protected ParkingLotApplication parkingLotApplication = ParkingLotApplication.getInstance();

    public abstract void run();
}
```

* The common steps of handling parking are defined in the `Gate` class, while the specific details are left to the subclasses.

**Benefits:**

* **Code Reuse**: Common steps for gate operations are defined in the base class, which helps to reduce redundancy.
* **Extensibility**: New types of gates can be introduced without modifying the existing logic in `EntryGate` or `ExitGate`.

---

### **Class Interactions and Workflow**

* **EntryGate**: When a vehicle enters, it collects the license number and owner name, selects the vehicle type, and assigns a parking spot. The parking ticket is generated, and the parking spot is marked as unavailable.

* **ExitGate**: When the vehicle exits, the ticket ID is entered, and the ticket is validated. The system calculates the amount based on the vehicle type and time spent in the parking lot.

* **Floor**: Each floor contains a collection of parking spots. Parking spots are categorized by their size (Compact, Regular, Large). Floors manage their own parking spots and can check for available spots.

* **Vehicle**: Each vehicle (Compact, Regular, Large) knows how to calculate its parking fee based on the time spent in the parking lot. The fee calculation is handled through polymorphism, where each vehicle type implements the `calculateAmount` method.

---

### **Conclusion**

This system leverages multiple **Design Patterns** to ensure that it is flexible, extensible, and easy to maintain. The **Factory Method** pattern handles object creation, **Strategy** pattern encapsulates the different pricing strategies for vehicles, **Singleton** pattern ensures that there is only one parking lot instance, **Composite** pattern helps to manage parking spots across floors, and **Template Method** pattern simplifies gate operations. Together, these patterns create a highly modular and scalable design that can easily adapt to future changes or new requirements.
