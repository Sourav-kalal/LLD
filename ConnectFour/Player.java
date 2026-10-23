import java.util.Objects;

public final class Player {
    private final String name;
    private final Color color;

    public Player(String name, Color color) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Player name cannot be blank.");
        }
        this.name = name;
        this.color = Objects.requireNonNull(color, "Player color cannot be null.");
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
