import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 25),
                new Persona("María", 30),
                new Persona("Pedro", 40),
                new Persona("Lucía", 35),
                new Persona("Ana", 28)
        );

        // Filtrar personas menores de 30 años y ordenarlas por edad
        List<Persona> personasMenoresDe30 = personas.stream()
                .filter(persona -> persona.getEdad() < 30)
                .sorted((p1, p2) -> Integer.compare(p1.getEdad(), p2.getEdad()))
                .collect(Collectors.toList());
        System.out.println("Personas menores de 30 años: " + personasMenoresDe30);

        // Obtener el promedio de edad de todas las personas
        double promedioEdad = personas.stream()
                .mapToInt(Persona::getEdad)
                .average()
                .orElse(0.0);
        System.out.println("Promedio de edad: " + promedioEdad);

        // Agrupar personas por rango de edad
        var personasPorRangoEdad = personas.stream()
                .collect(Collectors.groupingBy(
                        persona -> {
                            int edad = persona.getEdad();
                            if (edad < 20) return "Menores de 20";
                            else if (edad < 30) return "20-29";
                            else if (edad < 40) return "30-39";
                            else return "Mayores de 40";
                        }
                ));
        System.out.println("Personas por rango de edad: " + personasPorRangoEdad);
    }
    }

