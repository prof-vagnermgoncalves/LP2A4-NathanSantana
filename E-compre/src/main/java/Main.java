import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.*;
import model.repositorio.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto p1 = new ProdutoDAO().recuperarProdutoPorId(1);
		
		
		CompraDAO c1 = new CompraDAO();
		Compra compra = new Compra();
		
		List<Produto> produtos= new ArrayList<Produto>();
		
		produtos.add(p1);
		
		compra.setProdutos(produtos);
		compra.setNumeroNF(124788);
		compra.setQuantidade(30);
		
		c1.registrarCompra(compra);
		
	}

}
