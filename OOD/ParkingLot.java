/*
Design a parking lot using OOD.

Questions: 
What vehicles supported? Bus, Car, Motorcycle
Whether the parking lot has multiple levels? Small spot, Medium spot, Large spot

Motorcycle can park in all spots, small, medium and large spots.
Car can park in medium and large spots.
Bus can only part 5 consecutive large spot in the same row.


Who will use the parkinglot?
How will they use it?
Where is it used?
When is it used?


*/
public enum VehicleSize{Small, Medium, Large}

public abstract class Vehicle{
    private int id;
    private String licensePlate;

    // as one vehicle may park in >= 1 parking spots
    protected List<ParkingSpot> spots = new ArrayList<ParkingSpot>();
    
    protected int spotsNeeded;
    protected VehicleSize size;

    public int getSpotsNeeded(){return spotsNeeded;}
    public VehicleSize getSize(){return size;}

    public void parkInSpot(ParkingSpot spot){...}   // park in spot
    public void removeFromSpots(){...}  // remove from current spot
    public abstract boolean canFit(ParkingSpot spot){...}   // check if curr spot can fit
}

public class Bus extends Vehicle{
    public Bus(){
        // Bus needs 5 large spots
        spotsNeeded = 5;
        size = VehicleSize.Large;
    }
}

public class Car extends Vehicle{
    public Car(){
        spotsNeeded = 1;
        size = VehicleSize.Medium;
    }
}

public class Motorcycle extends Vehicle{
    public Motorcycle(){
        spotsNeeded = 1;
        size = VehicleSize.Small;
    }
}

//Parking Spot 停车位
public class ParkingSpot{
    private int id;

    private Level level;
    private int row;

    private Vehicle vehicle;    //which vehicle in this spot

    public ParkingSpot(Level level, int row){
        this.level = level;
        this.row = row;
    }

    public boolean isAvailable(){
        return this.vehicle == null;
    }

    public boolean canFit(Vehicle vehicle){...}

    // park
    public setVehicle(Vehicle vehicle){
        if(isAvailable() && canFit(vehicle)){
            this.vehicle = vehicle;
        }
    }

    public removeVehicle(){
        if(!isAvailable()){
            this.vehicle = null;
        }
    }

    public Level getLevel(){ return level; }
    public int getRow(){ return row; }
    public int getSpotNumber(){ return id; }
}

// Parking Lot 停车场
// Parking Lot are array of Level.
public class ParkingLot {
    private int id;
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot(){...}

    //park
    public boolean setVehicle(Vehicle vehicle){...}
}

// Leve is array of Parking Spot
public class Level{
    private int id;

    private ParkingSpot[] spots;
    private int availableSpots; //num of spots available
    private static final int SPOTS_PER_ROW = 10;

    public Level(){...}

    // park
    public boolean setVehicle(Vehicle vehicle){...}
    // parking in specific spot
    public boolean setVehicle(Vehicle vehicle, ParkingSpot spot){...}
    // remove vehicle
    public void removeVehicle(){...}
    // find available spot
    public ParkingSpot getAvailableSpot(){...}

}