package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
		criarArquivos(args[0], findAllRegras());
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
	public static List<Regra> findAllRegras() {
		RegraRepository regraRepository = new RegraRepository();
		List<Regra> regras = regraRepository.findAll();
		return regras;
	}
	public static void criarPasta(String path, List<TipoRegra> tiposRegra) {

		File pastas = new File(path);

		for (TipoRegra tipo : tiposRegra) {
			pastas =  new File(path + File.separator + tipo.getPath());
			for (int i = 0; i < tiposRegra.size();) {
				if (!pastas.exists()) {
					pastas.mkdirs();
				}
				
				i++;
			}
		}
	}

	public static void criarArquivos(String path,List<Regra> regras) {
		for (Regra regra : regras) {
			String nomeArquivo = path + File.separator + regra.getTipoRegra().getPath() + File.separator + regra.getNome() + ".rst";
			try {
				FileWriter arquivo= new FileWriter(nomeArquivo,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
