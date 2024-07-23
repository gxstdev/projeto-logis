package application;

import entity.TbEstado;
import entity.TbProprietario;
import entity.TbVeiculo;
import service.VeiculoBean;

public class Main {

	public static void main(String[] args) {
		VeiculoBean bean = new VeiculoBean();
		
		TbProprietario tbProprietario = new TbProprietario(1, "Volks Cars");
		TbEstado tbEstado = new TbEstado("SP", "São Paulo");
		
		TbVeiculo tbVeiculo = new TbVeiculo(1, "eas89", tbEstado, tbProprietario);
		
		int rowsAffected = bean.inserir(tbVeiculo);
		
		if(rowsAffected > 0) {
			System.out.println("Inserido com sucesso!");
		}
	}

}
