package model;

import model.repositorio.ItemDAO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item i1 = new Item();
		i1.setTitulo("Logotipo Simples 2D");
		i1.setDescricao("Logotipo simples disponibilizado nos formatos PNG e SVG.");
		i1.setEstado(true);
		
		ItemDAO itemDAO = new ItemDAO();
		
		int id = itemDAO.criarItem(i1);
		
		i1.setId(id);
		
		System.out.println("Id do item cadastrado: " + i1.getId());
	}

}
