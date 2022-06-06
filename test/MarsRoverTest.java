import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import universe.Coordinates;
import universe.Directions;
import universe.Plateau;

class MarsRoverTest {

    Coordinates topRightCoordinates;

    Coordinates bottomLeftCoordinates;

    Coordinates currentRoverPosition;

    Directions currentRoverDirections;

    Plateau plateauLayout;

    MarsRover marsRover;

    @BeforeEach
    void setup() {
        this.topRightCoordinates = new Coordinates(5, 5);
        this.bottomLeftCoordinates = new Coordinates(0, 0);
        this.currentRoverPosition = new Coordinates(1, 2);
        this.currentRoverDirections = Directions.N;
        this.plateauLayout = new Plateau(this.topRightCoordinates, this.bottomLeftCoordinates);
        initialise();
    }

    @Test
    void givenPositionAndDirection_thenSetCurrentPositionAndDirectionOfRover() {
        Assertions.assertEquals("1 2 N", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenAMoveCommand_whenRoverFacingNorth_thenSetTheNewRoverPosition() {
        this.marsRover.runRover("M");
        Assertions.assertEquals("1 3 N", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenAMoveCommand_whenRoverFacingSouth_thenSetTheNewRoverPosition() {
        this.marsRover.currentDirection = Directions.S;
        this.marsRover.runRover("M");
        Assertions.assertEquals("1 1 S", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenAMoveCommand_whenRoverFacingEast_thenSetTheNewRoverPosition() {
        this.marsRover.currentDirection = Directions.E;
        this.marsRover.runRover("M");
        Assertions.assertEquals("2 2 E", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenAMoveCommand_whenRoverFacingWest_thenSetTheNewRoverPosition() {
        this.marsRover.currentDirection = Directions.W;
        this.marsRover.runRover("M");
        Assertions.assertEquals("0 2 W", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenMultipleMoveCommand_thenSetNewRoverPosition() {
        this.marsRover.runRover("MM");
        Assertions.assertEquals("1 4 N", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenALeftTurnCommand_whenRoverFacingNorth_thenSetRoverDirectionToWest() {
        this.marsRover.runRover("L");
        Assertions.assertEquals("1 2 W", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenALeftTurnCommand_whenRoverFacingSouth_thenSetRoverDirectionToEast() {
        this.marsRover.currentDirection = Directions.S;
        this.marsRover.runRover("L");
        Assertions.assertEquals("1 2 E", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenALeftTurnCommand_whenRoverFacingWest_thenSetRoverDirectionToSouth() {
        this.marsRover.currentDirection = Directions.W;
        this.marsRover.runRover("L");
        Assertions.assertEquals("1 2 S", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenALeftTurnCommand_whenRoverFacingEast_thenSetRoverDirectionToNorth() {
        this.marsRover.currentDirection = Directions.E;
        this.marsRover.runRover("L");
        Assertions.assertEquals("1 2 N", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenARightTurnCommand_whenRoverFacingNorth_thenSetRoverDirectionToEast() {
        this.marsRover.runRover("R");
        Assertions.assertEquals("1 2 E", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenARightTurnCommand_whenRoverFacingSouth_thenSetRoverDirectionToWest() {
        this.marsRover.currentDirection = Directions.S;
        this.marsRover.runRover("R");
        Assertions.assertEquals("1 2 W", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenARightTurnCommand_whenRoverFacingEast_thenSetRoverDirectionToSouth() {
        this.marsRover.currentDirection = Directions.E;
        this.marsRover.runRover("R");
        Assertions.assertEquals("1 2 S", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenARightTurnCommand_whenRoverFacingWest_thenSetRoverDirectionToNorth() {
        this.marsRover.currentDirection = Directions.W;
        this.marsRover.runRover("R");
        Assertions.assertEquals("1 2 N", this.getRoverPosition(this.marsRover));
    }

    @Test
    void givenAInvalidCommand_thenReturnInvalidCommandError() {
        Assertions.assertThrows(RuntimeException.class, () -> this.marsRover.runRover("S"));
    }

    @Test
    void givenAStringOfCommand_whenRoverGoesOutsidePlateau_thenReturnError() {
        Assertions.assertThrows(RuntimeException.class, () -> this.marsRover.runRover("MMMMMM"));
    }

    private void initialise() {
        this.marsRover = new MarsRover(this.currentRoverPosition, this.currentRoverDirections, this.plateauLayout);
    }

    private String getRoverPosition(MarsRover marsRover) {
        return marsRover.currentPosition.getXCoordinate() + " " +
                marsRover.currentPosition.getYCoordinate() + " " +
                marsRover.currentDirection.name();
    }

}