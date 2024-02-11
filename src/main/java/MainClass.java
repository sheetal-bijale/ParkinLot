public class MainClass {
    public static void main(String[] args) {
        ParkingSlotService parkingSlotService = new ParkingSlotServiceImpl();
        ParkCar parkCar = new ParkCar(parkingSlotService);
        parkCar.parkingLot();
    }
}
