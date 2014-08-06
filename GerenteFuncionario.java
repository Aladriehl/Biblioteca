import java.util.*;


public class GerenteFuncionario {

    private List<Funcionario> funcionariosList = new ArrayList<Funcionario>();
        
    public boolean CadastrarFuncionario(Funcionario funcionario) {

    	if (VerificaDadosPessoal(funcionario) == true){
    		throw new BibliotecaException("Campo Obrigatorio nulo");
    	}
    	
    	for (Funcionario f : funcionariosList) {
            if (f.getDados().toString().equals(funcionario.getDados().toString())) {
                funcionariosList.remove(f);
                throw new BibliotecaException("Funcionario Existe");
            }
        }
    	
        funcionariosList.add(funcionario);
        return true;
    }
    
    public boolean VerificaDadosPessoal(Funcionario funcionario){
    	
    	DadosPessoal dados = funcionario.getDados();
    	
    	if(dados.getCpf() == null || dados.getIdentidade() == null || dados.getNome() == null){
    		return true;
    		
    	}
    	return false;
    }

    public boolean DeleteFuncionario(String cpf) {
        
        for (Funcionario f : funcionariosList) {
            if (f.getDados().getCpf().equals(cpf)) {
                funcionariosList.remove(f);
                return true;
            }
        }
        throw new BibliotecaException("Funcionario não existente");
    }


    public boolean ConsultarFuncionario(String cpfFuncionario) {
        for (Funcionario funcionario : funcionariosList) {
            if (funcionario.getDados().getCpf().equals(cpfFuncionario))
            	return true;
        }
        throw new BibliotecaException("Não existe funcionario com este cpf");
    }

    public Funcionario alterarDadosFuncionario(Funcionario funcionario) {
        for (Funcionario func : funcionariosList) {
            if (funcionario.getDados().getCpf().equals(func.getDados().getCpf())) {
                func = funcionario;
                
                return func;
            }
        }
        throw new BibliotecaException("Não existe funcionairo com este cpf");
    }

    public List<Funcionario> getListFuncionario(){
        return funcionariosList;
    }

}
