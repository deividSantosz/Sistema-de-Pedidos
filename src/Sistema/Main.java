package Sistema;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entitities.enums.OrderStatus;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		
		Locale.setDefault(Locale.US); 
		Scanner sc = new Scanner (System.in);	
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
		Date d2 = Date.from(Instant.parse("2023-01-25T18:12:13Z"));
		sdf.format(d2);
		System.out.println("Entre com as informações do cliente:");
		System.out.print("Nome:" );
		String nome = sc.next();
		System.out.print("Email:" );
		String email = sc.next();
		System.out.print("Data (DD/MM/YYYY): ");
		Date data = sdf.parse(sc.next());
		
		Cliente Cliente = new Cliente(nome, email, data);
		
		System.out.println("Entre com as informações do pedido");
		System.out.print("Status:");
		String Status = sc.next();
		System.out.print("Quantos itens tem no seu pedido?");
		Integer quant = sc.nextInt();
		
		Pedido Pedido = new Pedido(d2, OrderStatus.valueOf(Status), Cliente);
		
		for(int i =1; i<=quant; i++) {
			System.out.println("Digite as infos do item #" + i );
			
			System.out.print("Digite o nome do produto: ");
			String nome2 = sc.next();
			System.out.print("Digite o preco do produto:");
			Double preco = sc.nextDouble();
			System.out.print("Digite a quantidade do produto");
			Integer quantidade = sc.nextInt();
			Produto Produto = new Produto(nome2, preco);
			OrdemItem item = new OrdemItem(quantidade, preco, Produto);
			Pedido.addItem(item);
			
		}
		
		System.out.println("RESUMO DO PEDIDO:");
		System.out.println();
		System.out.print("Momento do pedido:" + sdf2.format(d2));
		System.out.println();
		System.out.print("Status:" + Pedido.getStatus());
		System.out.println();
		System.out.print("Cliente: " + Cliente.getNome() + " " + sdf.format(data) + " "+ Cliente.getEmail());
		System.out.println();
		System.out.println("Itens:" );
		
		System.out.print(Pedido);
		System.out.println();
		System.out.print("Total do Pedido: $" + Pedido.TotalPedido());
			sc.close();

	}

}
