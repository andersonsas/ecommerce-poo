package interfaces;

import entidade.Movel;
import util.Input;

public class TelaCadastrarMovel {
	public Movel cadastrarNovoMovel() {
		Movel movel = new Movel();
		
		System.out.println("CADASTRO DE MOVEL");
		
		System.out.print("Informe a Altura do Móvel: ");
		movel.setAltura(Float.parseFloat(Input.get()));
		
		System.out.print("Informe a Profundidade do Movel: ");
		movel.setProfundidade(Float.parseFloat(Input.get()));
		
		System.out.print("Informe a Largura do Movel: ");
		movel.setLargura(Float.parseFloat(Input.get()));
		
		System.out.print("Informe a Cor do Movel: ");
		movel.setCor(Input.get());
		
		System.out.print("Informe o Material do Movel: ");
		movel.setMaterial(Input.get());
		
		System.out.print("Informe o codigo do Movel: ");
		movel.setCodigo(Integer.parseInt(Input.get()));
		
		System.out.print("Informe a descricao do Movel: ");
		movel.setDescricao(Input.get());
		
		System.out.print("Informe a unidade que possui o Movel: ");
		movel.setUnidade(Input.get());
		
		System.out.print("Informe a quantidade em estoque do Movel: ");
		movel.adicionarEstoque(Integer.parseInt(Input.get()));
		
		System.out.print("Informe o preco do Movel: ");
		movel.setPreco(Float.parseFloat(Input.get()));
	
		return movel;
	}
}
