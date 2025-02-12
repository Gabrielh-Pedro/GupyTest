import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe principal para executar todas as operações exigidas no teste.
 */
public class Main {
    public static void main(String[] args) {
        // Criando a lista de funcionários
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Maria", "18/10/2000", 2009.44, "Operador"));
        employees.add(new Employee("João", "12/05/1990", 2284.38, "Operador"));
        employees.add(new Employee("Caio", "02/05/1961", 9836.14, "Coordenador"));
        employees.add(new Employee("Miguel", "14/10/1988", 19119.88, "Diretor"));
        employees.add(new Employee("Alice", "05/01/1995", 2234.68, "Recepcionista"));
        employees.add(new Employee("Heitor", "19/11/1999", 1582.72, "Operador"));
        employees.add(new Employee("Arthur", "31/03/1993", 4071.84, "Contador"));
        employees.add(new Employee("Laura", "08/07/1994", 3017.45, "Gerente"));
        employees.add(new Employee("Heloísa", "24/05/2003", 1606.85, "Eletricista"));
        employees.add(new Employee("Helena", "02/09/1996", 2799.93, "Gerente"));

        // 3.2 – Remover "João" da lista
        employees.removeIf(e -> e.getName().equals("João"));

        // 3.3 – Imprimir todos os funcionários
        System.out.println("\nLista de Funcionários:");
        employees.forEach(e -> 
            System.out.println(e.getName() + " - " + e.getBirthDate().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
            + " - " + e.getFormattedSalary() + " - " + e.getRole())
        );

        // 3.4 – Aumentar salário em 10%
        employees.forEach(e -> e.increaseSalary(10));

        // 3.5 – Agrupar por função
        Map<String, List<Employee>> groupedByRole = employees.stream()
                .collect(Collectors.groupingBy(Employee::getRole));

        // 3.6 – Imprimir agrupados por função
        System.out.println("\nFuncionários Agrupados por Função:");
        groupedByRole.forEach((role, empList) -> {
            System.out.println("\nFunção: " + role);
            empList.forEach(e -> System.out.println(e.getName() + " - " + e.getFormattedSalary()));
        });

        // 3.8 – Funcionários que fazem aniversário em outubro (10) ou dezembro (12)
        System.out.println("\nFuncionários que fazem aniversário em Outubro ou Dezembro:");
        employees.stream()
                .filter(e -> e.getBirthDate().getMonthValue() == 10 || e.getBirthDate().getMonthValue() == 12)
                .forEach(e -> System.out.println(e.getName()));

        // 3.9 – Funcionário mais velho
        Employee oldestEmployee = Collections.min(employees, Comparator.comparing(Employee::getBirthDate));
        System.out.println("\nFuncionário Mais Velho: " + oldestEmployee.getName() + " - " + oldestEmployee.getAge() + " anos");

        // 3.10 – Ordenar alfabeticamente
        System.out.println("\nFuncionários Ordenados Alfabeticamente:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(e -> System.out.println(e.getName()));

        // 3.11 – Total dos salários
        BigDecimal totalSalary = employees.stream()
                .map(Employee::getSalary)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("\nTotal dos Salários: R$ " + df.format(totalSalary));

        // 3.12 – Quantidade de salários mínimos
        BigDecimal minimumWage = new BigDecimal("1212.00");
        System.out.println("\nSalário dos Funcionários em Termos de Salário Mínimo:");
        employees.forEach(e -> {
            BigDecimal wageCount = e.getSalary().divide(minimumWage, 2, RoundingMode.HALF_UP);
            System.out.println(e.getName() + " ganha " + wageCount + " salários mínimos");
        });
    }
}
