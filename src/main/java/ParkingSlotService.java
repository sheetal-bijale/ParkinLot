import java.util.Map;
import java.util.Set;

public interface ParkingSlotService {

    void parkCar(Car car , Map<Integer , Car> bookedSlots , Map<String, Set<String>> carWithColour);

    void getStatus(Map<Integer , Car> bookedSlots);

    void getCarsByColour(String colour , Map<String, Set<String>> carWithColour);

    void leaveCar(int slotNumber , Map<Integer , Car> bookedSlots , Map<String, Set<String>> carWithColour);

}
