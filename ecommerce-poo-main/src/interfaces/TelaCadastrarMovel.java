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
		return movel;
	}
}
