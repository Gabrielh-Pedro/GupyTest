import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe base que representa uma pessoa.
 */
public class Person {
    private String name;
    private LocalDate birthDate;

    // Construtor
    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    
    // Método para calcular a idade
    public int getAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
