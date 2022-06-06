import universe.Coordinates;
import universe.Directions;
import universe.Plateau;

public class MarsRoverApp {

    public static void main(String[] args) {

        Coordinates topRightCoordinates = new Coordinates(5, 5);
        Coordinates bottomLeftCoordinates = new Coordinates(0, 0);

        Coordinates currentRoverPosition = new Coordinates(1, 2);
        Directions currentRoverDirections = Directions.N;

        Plateau plateauLayout = new Plateau(topRightCoordinates, bottomLeftCoordinates);

        MarsRover marsRover = new MarsRover(currentRoverPosition, currentRoverDirections, plateauLayout);

        String commandsString = "LMLMLMLMM";

        marsRover.runRover(commandsString);

        System.out.println(marsRover.currentPosition.getXCoordinate() + " " +
                marsRover.currentPosition.getYCoordinate() + " " +
                marsRover.currentDirection.name());
    }
}
