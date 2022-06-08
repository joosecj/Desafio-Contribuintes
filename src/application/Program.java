package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<TaxPayer> registration = new ArrayList<>();
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		
		for (int i=0; i < n; i++) {
			System.out.printf("\nDigite os dados do %dº. contribuinte: \n", i+1);
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			
			TaxPayer userData = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending); 
			
			registration.add(userData);
		}
		int i = 1;
		for (TaxPayer userData  : registration) {
			System.out.printf("\nResumo do %dº. contribuinte:\n", i++);
			System.out.printf("Imposto Bruto Total: %.2f\n", userData.grossTax());
			System.out.printf("Abatimento: %.2f\n", userData.taxRebate());
			System.out.printf("Imposto devido: %.2f\n", userData.netTax());			
		}
		
		sc.close();

	}

}
