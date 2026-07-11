package funcionarios;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.util.List;

public class SistemaFuncionariosBomPratoTest {

    @Test
    public void testaCadastroEPesquisa() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try {
            sistema.cadastrarFuncionario(new Funcionario("333.333.333-33", "Ayla Rebouças",
                    TipoFuncionario.GERENTE, 3000));
            assertTrue(sistema.funcionarioJaExiste("333.333.333-33"));
            Funcionario f1 = sistema.pesquisarFuncionario("333.333.333-33");

            // a) Cadastra João Paulo Silva, cozinheiro, R$ 5000
            sistema.cadastrarFuncionario(new Funcionario("222.222.222-22", "João Paulo Silva",
                    TipoFuncionario.COZINHEIRO, 5000));

            // b) Lista funcionários com salário maior que R$ 2000 — deve ter tamanho 2
            List<Funcionario> maisDe2000 = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000);
            assertEquals(2, maisDe2000.size());

            // c) Conta cozinheiros — deve retornar 1
            int cozinheiros = sistema.contarFuncionariosDoTipo(TipoFuncionario.COZINHEIRO);
            assertEquals(1, cozinheiros);

        } catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    public void testaAlterarSalarioEPesquisarPorTipo() {
        SistemaFuncionariosBomPrato sistema = new SistemaFuncionariosBomPrato();
        try {
            sistema.cadastrarFuncionario(new Funcionario("111.111.111-11", "Carlos Silva",
                    TipoFuncionario.GARCON, 1500));
            sistema.cadastrarFuncionario(new Funcionario("444.444.444-44", "Ana Lima",
                    TipoFuncionario.GARCON, 1800));

            // Verifica que há 2 garçons
            assertEquals(2, sistema.contarFuncionariosDoTipo(TipoFuncionario.GARCON));

            // Altera o salário de Carlos para R$ 3000
            sistema.alterarSalarioDeFuncionario("111.111.111-11", 3000);

            // Verifica se o salário foi alterado
            Funcionario carlos = sistema.pesquisarFuncionario("111.111.111-11");
            assertEquals(3000.0, carlos.getSalario(), 0.01);

            // Pesquisa funcionários com salário maior que R$ 2000 — deve retornar só Carlos
            List<Funcionario> resultado = sistema.pesquisarFuncionariosComSalarioMaiorQue(2000);
            assertEquals(1, resultado.size());

        } catch (FuncionarioJaExisteException | FuncionarioInexistenteException e) {
            fail("Não deveria lançar exceção: " + e.getMessage());
        }
    }
}