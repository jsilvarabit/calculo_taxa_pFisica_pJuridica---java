package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Contribuinte;
import entidades.PessoaFisica;
import entidades.PessoaJuridica;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Contribuinte> list = new ArrayList<>();
		
		System.out.println("Quantas taxas serão calculadas? ");
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			System.out.println("Dados do pagante #"+(i+1)+":");
			System.out.print("Pessoa física ou jurídica? ");
			char ch = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Renda anual: ");
			Double rendaAnual = sc.nextDouble();
			if(ch=='f') {
				System.out.print("Gastos com saúde: ");
				Double gastoSaude = sc.nextDouble();
				list.add(new PessoaFisica(nome,rendaAnual,gastoSaude));
			}else {
				System.out.print("Número de funcionários: ");
				Integer funcionarios = sc.nextInt();
				list.add(new PessoaJuridica(nome,rendaAnual,funcionarios));
			}
		}
		
		System.out.println();
		System.out.println("Taxas pagas: ");
		
		for(Contribuinte contribuinte : list) {
			System.out.println(contribuinte.getNome() +", R$"+ String.format("%.2f",contribuinte.calculaImposto()));
		}
		
		double soma = 0.0;
		for(Contribuinte contribuinte : list) {
			soma += contribuinte.calculaImposto();
		}
		System.out.println();
		System.out.printf("Total das taxas: R$%.2f " ,soma);
		
		sc.close();

	}

}
