import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParkingSlotServiceImpl implements ParkingSlotService{


    @Override
    public void parkCar(Car car , Map<Integer , Car> bookedSlots , Map<String, Set<String>> carWithColour){

        for (int key : bookedSlots.keySet()){
            if(bookedSlots.get(key) == null){
                bookedSlots.put(key , car);
                System.out.println("Allocated slot number: "+key);
                String colour = car.getColour();
                if(!carWithColour.containsKey(colour)){
                    Set<String> set = new HashSet<>();
                    carWithColour.put(colour , set);
                }
                carWithColour.get(colour).add(car.getCarNumber());
                return;
            }
        }
        System.out.println("Error is system No slots available");
    }

    public void getStatus(Map<Integer , Car> bookedSlots){
        System.out.println("Slot no.  Registration Number   Colour");
        for(int key : bookedSlots.keySet()){
            if(bookedSlots.get(key)!= null){
                System.out.println(key + "     " + bookedSlots.get(key).getCarNumber() +
                        "     " + bookedSlots.get(key).getColour());
            }
        }
        return ;
    }

    public void getCarsByColour(String colour , Map<String, Set<String>> carWithColour){
        if(!carWithColour.containsKey(colour)){
            System.out.println("No car with this colour");
            return;
        }
        Set<String> carsOfColour =  carWithColour.get(colour);

        for (String car : carsOfColour){
            System.out.print(car+" ");
        }
        System.out.println();
    }

    public void leaveCar(int slotNumber , Map<Integer , Car> bookedSlots , Map<String, Set<String>> carWithColour){
        Car car = bookedSlots.get(slotNumber);
        bookedSlots.put(slotNumber , null);
        if(car == null){
            System.out.println("No car parked at slot " + slotNumber);
            return;
        }
        else{
            System.out.println("Slot number "+ slotNumber +" is free");
        }
        carWithColour.get(car.getColour()).remove(car.getCarNumber());
    }
}
