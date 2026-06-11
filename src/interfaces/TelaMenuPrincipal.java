package interfaces;

import util.Input;

public class TelaMenuPrincipal {
	public int menuPrincipal() {
		System.out.println("menu principal");
		System.out.println("1. cadastrar produto.");
		System.out.println("2. buscar produto.");
		System.out.println("3. cadastrar fornecedor.");
		System.out.println("4. buscar fornecedor..");
		System.out.println("11. comprar Produto.");
		System.out.println("0. sair");
		
		return Integer.parseInt(Input.get());
	}
}
