package funcionarios;

public class Funcionario {

    private String cpf;
    private String nome;
    private TipoFuncionario tipo;
    private double salario;

    public Funcionario() {}

    public Funcionario(String cpf, String nome, TipoFuncionario tipo, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.tipo = tipo;
        this.salario = salario;
    }

    public String getCpf()                    { return cpf; }
    public void setCpf(String cpf)            { this.cpf = cpf; }

    public String getNome()                   { return nome; }
    public void setNome(String nome)          { this.nome = nome; }

    public TipoFuncionario getTipo()          { return tipo; }
    public void setTipo(TipoFuncionario tipo) { this.tipo = tipo; }

    public double getSalario()                { return salario; }
    public void setSalario(double salario)    { this.salario = salario; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario f = (Funcionario) o;
        return this.cpf.equals(f.cpf);
    }

    @Override
    public int hashCode() { return cpf.hashCode(); }

    @Override
    public String toString() {
        return "Funcionario{cpf='" + cpf + "', nome='" + nome +
                "', tipo=" + tipo + ", salario=" + salario + "}";
    }
}