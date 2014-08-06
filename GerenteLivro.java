
import java.util.*;


public class GerenteLivro {

	private  Map <String, Livro> livros = new HashMap<>();

	//CADASTRAR LIVRO
	public  void CadastraLivros( String numeroDeRegistro, Livro livro){  
		
		if(livros.containsKey(numeroDeRegistro)){
			lancarExcecao("Numero de registro ja existe");
		}
		if(numeroDeRegistro == null){
			lancarExcecao("Numero de registro nulo");
		}
		livros.put(numeroDeRegistro, livro);
		//entradaDeLivro(); 
	}
	
	//CONSULTAR LIVRO
	public boolean ConsultarLivro(String numeroDeRegistro){
		if(!livros.containsKey(numeroDeRegistro)){
			lancarExcecao("Livro não encontrado");
		}
		return livros.containsKey(numeroDeRegistro);
	}
	//REMOVER LIVRO
	public  boolean RemoverLivro(String numeroDeRegistro){
		
		if(livros.containsKey(numeroDeRegistro)){
			livros.remove(numeroDeRegistro);
			return true;
		}else
			lancarExcecao("Livro não foi removido");
		return false;	
	}
	
	private static void lancarExcecao(String msg) {
		throw new BibliotecaException(msg);
	}
}
