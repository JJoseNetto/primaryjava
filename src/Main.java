import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Carro carro1 = new Carro("Mercedez", "JGA-2025");
        Cliente cliente1 = new Cliente("Jose Neto", "123.123.123-00");

        Locacao Locacao = new Locacao(carro1, cliente1);
        Locacao.exibirResumo();


        try{
            Cliente cliente2 = new Cliente("Gabi", "000.000.000-12");
            Locacao outraLocacao = new Locacao(carro1, cliente2);
        } catch( Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

}

class Carro {
        private String modelo;
        private String placa;
        private boolean disponivel = true;

    public Carro(String modelo, String placa){
        this.modelo = modelo;
        this.placa = placa;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel){
            this.disponivel = disponivel;
    }

    public String getDescricao(){
            return modelo + " - Placa: " + placa;
    }
}

class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }
}

class Locacao {
    private Carro carro;
    private Cliente cliente;
    private Date datalocacao;

    public Locacao(Carro carro, Cliente cliente){
        if(!carro.isDisponivel()){
            throw new IllegalStateException("Carro indisponivel para locação");
        }
        this.carro = carro;
        this.cliente = cliente;
        this.datalocacao = new Date();
        carro.setDisponivel(false);
    }

    public void exibirResumo() {
        System.out.println("Carro alugado por: " + cliente.getNome());
        System.out.println("Carro: " + carro.getDescricao());
        System.out.println("Data da locação: " + datalocacao);
    }
}