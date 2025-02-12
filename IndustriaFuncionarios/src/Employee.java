import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Classe Employee que herda de Person e representa um funcionário.
 */
public class Employee extends Person {
    private BigDecimal salary;
    private String role;
    
    // Construtor
    public Employee(String name, String birthDate, double salary, String role) {
        super(name, birthDate);
        this.salary = BigDecimal.valueOf(salary);
        this.role = role;
    }

    // Getters e Setters
    public BigDecimal getSalary() {
        return salary;
    }

    public void increaseSalary(double percentage) {
        BigDecimal increase = salary.multiply(BigDecimal.valueOf(percentage / 100));
        this.salary = this.salary.add(increase);
    }

    public String getRole() {
        return role;
    }

    // Método para formatar salário no padrão brasileiro
    public String getFormattedSalary() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "R$ " + df.format(salary);
    }
}
