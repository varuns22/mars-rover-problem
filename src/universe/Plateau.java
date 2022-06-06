package universe;

public class Plateau {
    private final Coordinates topRightCoordinates;
    private final Coordinates bottomLeftCoordinates;

    public Plateau(Coordinates topRightCoordinates, Coordinates bottomLeftCoordinates) {
        this.topRightCoordinates = topRightCoordinates;
        this.bottomLeftCoordinates = bottomLeftCoordinates;
    }

    public boolean checkRoverInPlateau(Coordinates currentRoverCoordinates) {
        return topRightCoordinates.getXCoordinate() >= currentRoverCoordinates.getXCoordinate()
                && topRightCoordinates.getYCoordinate() >= currentRoverCoordinates.getYCoordinate()
                && bottomLeftCoordinates.getXCoordinate() <= currentRoverCoordinates.getXCoordinate()
                && bottomLeftCoordinates.getYCoordinate() <= currentRoverCoordinates.getYCoordinate();
    }
}
