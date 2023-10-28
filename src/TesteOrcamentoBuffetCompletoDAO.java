import java.util.ArrayList;

import bancoDeDados.ConexaoBanco;
import bancoDeDados.OrcamentoBuffetCompletoDAO;
import classes.Bolo;
import classes.Data;
import classes.Doce;
import classes.OrcamentoBuffetCompleto;
import classes.Pagamento;
import classes.Salgado;

public class TesteOrcamentoBuffetCompletoDAO {

	public static void main(String[] args) {
		System.out.println(ConexaoBanco.getConexao());
		System.out.println(ConexaoBanco.status);
		
		OrcamentoBuffetCompletoDAO orcDAO = new OrcamentoBuffetCompletoDAO();		
		Data data = new Data(13,11,2023);
		Pagamento pagamento = new Pagamento(100.23,"debito",1);
		
		Salgado a = new Salgado(1,"quibe",2.2);
		Salgado b = new Salgado(2,"coxinha",2.4);
		
		ArrayList<Salgado> salgadoList = new ArrayList<Salgado>();
		salgadoList.add(a);
		salgadoList.add(b);
		
		Doce x = new Doce(1,"brigadeiro",2.4);
		Doce y = new Doce(2, "bala", 3.4);
		
		ArrayList<Doce> doceList = new ArrayList<Doce>();
		doceList.add(x);
		doceList.add(y);
		
		Bolo bolo = new Bolo(1,"Prestigio",100);
		bolo.setPeso(2.0);
		
		OrcamentoBuffetCompleto orc = new OrcamentoBuffetCompleto(10,"10:30",data,pagamento,false,salgadoList,doceList,bolo);
		
		orcDAO.criar(orc);
		
	}

}
