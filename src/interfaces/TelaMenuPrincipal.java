package interfaces;

import util.Input;

public class TelaMenuPrincipal {
	public int menuPrincipal() {
		System.out.println("menu principal");
		System.out.println();
		System.out.println("1. cadastrar produto.");
		System.out.println("2. buscar produto.");
		System.out.println();
		System.out.println("3. cadastrar comprador.");
		System.out.println("4. listar compradores.");
		System.out.println("5. buscar comprador.");
		System.out.println();
		System.out.println("6. cadastrar cliente.");
		System.out.println("7. buscar cliente.");
		System.out.println();
		System.out.println("0. sair.");
		
		
		return Integer.parseInt(Input.get());
	}
}
