package persistence;

import java.util.ArrayList;
import java.util.List;

import entity.Processo;

public class ProcessoDao extends Dao {

	public void inserirDadosProc(Processo p) throws Exception {
		open();
		stmt = con
				.prepareStatement("insert into tb_processo values(seqproc.nextval, ?, ?, ?, ?, ?)");
		stmt.setString(1, p.getNumero_pub());
		stmt.setString(2, p.getNumero_ped());
		stmt.setString(3, p.getdatapubli());
		stmt.setString(4, p.getRequerentes());
		stmt.setString(5, p.getTitulo());

		stmt.execute();
		stmt.close();

		close();
	}

	public List<Processo> consultaProcesso() throws Exception {

		open();
		stmt = con.prepareStatement("select * from tb_processo");
		rs = stmt.executeQuery();
		List<Processo> lista = new ArrayList<>();
		while (rs.next()) {
			Processo p = new Processo( 
					rs.getInt("idprocesso"), 
					rs.getString("numero_pub"),
					rs.getString("numero_ped"),
					rs.getString("datapubli"), 
					rs.getString("requerentes"), 
					rs.getString("titulo"));
		
			lista.add(p);
		}

		rs.close();
		stmt.close();
		close();
		return lista;
	}
	
}
