package universe;

public class Plateau {
    private final Coordinates topRightCoordinates;
    private final Coordinates bottomLeftCoordinates;

    public Plateau(Coordinates topRightCoordinates, Coordinates bottomLeftCoordinates) {
        this.topRightCoordinates = topRightCoordinates;
        this.bottomLeftCoordinates = bottomLeftCoordinates;
    }
}
