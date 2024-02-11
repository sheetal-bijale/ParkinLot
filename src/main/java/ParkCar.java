import java.util.*;

public class ParkCar {

    ParkingSlotService parkingSlotService ;

    public ParkCar(ParkingSlotService parkingSlotService) {
        this.parkingSlotService = parkingSlotService;
    }


    //This method wil decide which method to call based on
    public void parkingLot(){
        Scanner scanner = new Scanner(System.in);

        int freeSlots = 0;

        Map<Integer , Car> bookedSlots = new HashMap<>();

        Map<String, Set<String>> carWithColour = new HashMap<>();

        while (true) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            if (!command[0].equals("exit")) {
                if (command[0].startsWith("create")) {

                    try {
                        freeSlots = Integer.parseInt(command[1]);
                        System.out.println("Created a parking lot with " + freeSlots + " slots");

                        for(int i=1;i<=freeSlots;i++){
                            bookedSlots.put(i , null);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please provide valid input");
                        System.out.println("Your current input is " + input);
                        System.out.println("Expected input is     create_parking_lot 6");
                    }

                }
                else if(command[0].equals("park")){
                    if(freeSlots==0){
                        System.out.println("Sorry, parking lot is full");
                    }
                    else{
                        freeSlots--;
                        Car car = new Car(command[1] , command[2]);
                        parkingSlotService.parkCar(car , bookedSlots , carWithColour);
                    }
                }
                else if(command[0].equals("leave")){
                    try {
                        int slot = Integer.parseInt(command[1] );
                        parkingSlotService.leaveCar(slot,bookedSlots , carWithColour);
                    }
                    catch (NumberFormatException e){
                        System.out.println("Please provide valid input");
                        System.out.println("Your current input is " + input);
                        System.out.println("Expected input is     create_parking_lot 6");
                    }

                }
                else if(command[0].equals("status")){
                    parkingSlotService.getStatus(bookedSlots);
                }
                else if(command[0].equals("registration_numbers_for_cars_with_colour")){
                    parkingSlotService.getCarsByColour(command[1] , carWithColour);
                }
                else{
                    System.out.println("Input is wrong, please enter valid input");
                }

            }
            else{
                System.out.println("Thank You!!");
                break;
            }
        }
    }
}
