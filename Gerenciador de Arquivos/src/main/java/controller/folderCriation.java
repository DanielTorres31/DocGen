package controller;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import entities.Regra;
import entities.TipoRegra;
import repository.RegraRepository;
import repository.TipoRegrasRepository;

public class folderCriation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findAllTipoRegra();
		criarPasta(args[0],findAllTipoRegra());
		// TipoRegra tp = null;
		// for (TipoRegra tipo : tiposRegra) {
		// System.out.println(tipo);
		// if(tipo.getId() == 3) {
		// tp = tipo;
		// }
		// }
		//
		//
		// for(Regra regra : regrasPorId) {
		// System.out.println(regra.getNome());
		// }

	}

	public static List<TipoRegra> findAllTipoRegra() {
		TipoRegrasRepository tipoRegraRepository = new TipoRegrasRepository();
		List<TipoRegra> tiposRegra = tipoRegraRepository.findAll();
		return tiposRegra;
	}

	public static List<Regra> findRegrasByIdTipoRegra(TipoRegra tipoRegra) {
		RegraRepository regraRepository = new RegraRepository();
		List<Regra> regrasPorId = regraRepository.findByTipoRegra(tipoRegra);
		return regrasPorId;
	}

	public static void criarPasta(String path, List<TipoRegra> tiposRegra) {

		File pastas = new File(path);


		for (TipoRegra tipo : tiposRegra) {
			pastas =  new File(path + File.separator + tipo.getId() +" - " +   tipo.getNometiporegra());
			
			for (int i = 0; i < tiposRegra.size();) {
				if (!pastas.exists()) {
					pastas.mkdirs();
				}
				i++;
			}

		}

	}

	public static void criacaoDosArquivos() {
		File arquivo = new

	}
}
