package funcionarios;

public class FuncionarioInexistenteException extends Exception {
    public FuncionarioInexistenteException(String mensagem) {
        super(mensagem);
    }
}