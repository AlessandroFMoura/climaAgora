package src.classes;

public record Clima(String name, Main main) {
    public record Main(
            Double temp,
            Double temp_min,
            Double temp_max
    ) {

    }
}