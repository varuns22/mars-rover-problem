import universe.Coordinates;
import universe.Directions;
import universe.Plateau;

import java.util.List;

public class MarsRover {
    Directions currentDirection;

    Coordinates currentPosition;

    Plateau plateau;

    public MarsRover(Coordinates coordinates, Directions currentDirection, Plateau plateau) {
        this.currentPosition = coordinates;
        this.currentDirection = currentDirection;
        this.plateau = plateau;
    }

    /**
     * This method converts the string of commands to a list of characters and executes the command in iteration
     * for the Mars rover.
     *
     * @param commands A string of commands
     */
    public void runRover(String commands) {
        List<Character> commandList = commands.chars()
                .mapToObj((value) -> (char) value)
                .toList();

        for (Character command : commandList) {
            this.executeCommand(command);
        }
    }

    /**
     * This method executes the command received for the cases M (move), L (turn left), R (turn right)
     * and sets the position and facing direction of the Mars Rover.
     *
     * @param command The command for rover
     */
    public void executeCommand(Character command) {

        switch (command) {
            case 'L' -> this.turnLeft();
            case 'M' -> this.moveInSameDirection();
            case 'R' -> this.turnRight();
            default -> throw new RuntimeException("Invalid Command");
        }
        if (!plateau.checkRoverInPlateau(this.currentPosition)) {
            throw new RuntimeException("Rover Cannot be in outside the plateau");
        }
    }

    /**
     * This method moves the rover to the new position based on the direction the rover is facing.
     */
    private void moveInSameDirection() {
        int currentXCoordinate = this.currentPosition.getXCoordinate();
        int currentYCoordinate = this.currentPosition.getYCoordinate();
        switch (this.currentDirection) {
            case N -> this.currentPosition.setYCoordinate(currentYCoordinate + 1);
            case S -> this.currentPosition.setYCoordinate(currentYCoordinate - 1);
            case E -> this.currentPosition.setXCoordinate(currentXCoordinate + 1);
            case W -> this.currentPosition.setXCoordinate(currentXCoordinate - 1);
            default -> throw new RuntimeException("Invalid Direction");
        }

    }

    /**
     * This method turns the rover right by 90 degree from the current facing direction.
     */
    private void turnRight() {
        switch (this.currentDirection) {
            case N -> this.currentDirection = Directions.E;
            case S -> this.currentDirection = Directions.W;
            case E -> this.currentDirection = Directions.S;
            case W -> this.currentDirection = Directions.N;
            default -> throw new RuntimeException("Invalid Direction");
        }
    }

    /**
     * This method turns the rover left by 90 degree from the current facing direction.
     */
    private void turnLeft() {
        switch (this.currentDirection) {
            case N -> this.currentDirection = Directions.W;
            case S -> this.currentDirection = Directions.E;
            case E -> this.currentDirection = Directions.N;
            case W -> this.currentDirection = Directions.S;
            default -> throw new RuntimeException("Invalid Direction");
        }
    }
}
