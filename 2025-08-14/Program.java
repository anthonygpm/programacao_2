import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Pessoa> pessoas = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data:");

            System.out.print("Individual or Company (i/c)? ");
            char type = sc.nextLine().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double rendaAnual = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Health expendures: ");
                double healthExpendures = sc.nextDouble();
                pessoas.add(new PessoaFisica(name, rendaAnual, healthExpendures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                pessoas.add(new PessoaJuridica(name, rendaAnual, numberOfEmployees));
            }

            sc.nextLine();
        }

        System.out.println();
        System.out.println("TAXES PAID:");
        double totalTaxesPaid = 0;
        for (Pessoa p : pessoas) {
            System.out.println(p.getName() + ": $" + String.format("%.2f", p.taxPaid()));
            totalTaxesPaid += p.taxPaid();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $" + String.format("%.2f", totalTaxesPaid));

        sc.close();
    }
}
