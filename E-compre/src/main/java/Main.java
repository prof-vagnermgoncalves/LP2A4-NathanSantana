import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.*;
import model.repositorio.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto p1 = new ProdutoDAO().recuperarProdutoPorId(1);
		
		
		System.out.println(p1.getId());
		
		CompraDAO c1 = new CompraDAO();
		Compra compra = new Compra();
		
		List<Produto> produtos= new ArrayList<Produto>();
		
		produtos.add(p1);
		
		System.out.println(produtos.get(0));
		
		compra.setProdutos(produtos);
		compra.setNumeroNF(8402);
		compra.setQuantidade(10);
		
		c1.registrarCompra(compra);

	}

}
