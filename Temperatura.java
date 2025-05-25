package modelos;

public record Temperatura(
        Main main,
        Weather[] weather,
        String name
) {
    public record Main(
            double temp
    ){}

    public record Weather(
            String description
    ) {}
}