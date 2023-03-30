package br.edu.infnet.veiculos.model.domain;


import br.edu.infnet.veiculos.exceptions.NumeroCilindradasInvalidaException;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TMotocicleta")
public class Motocicleta extends Veiculo{

    private int cilindrada;
    private boolean possuiCarenagem;
    private int numeroDeMarchas;

    @Override
    public void impressao() {
        System.out.println("#Motocicleta");
        System.out.println(this);
    }

    @Override
    public float calcularVenda() throws NumeroCilindradasInvalidaException {
        System.out.println("Calcular venda motocicleta");

        if(cilindrada < 50){
            throw new NumeroCilindradasInvalidaException("O número de cilindradas não pode ser menor que 50");
        }

        float valorCarenagem = possuiCarenagem ? 500 : 100;
        float valorCilindrada = cilindrada * 0.045f;
        return getValor() * 2 + valorCarenagem + valorCilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public boolean isPossuiCarenagem() {
        return possuiCarenagem;
    }

    public void setPossuiCarenagem(boolean possuiCarenagem) {
        this.possuiCarenagem = possuiCarenagem;
    }

    public int getNumeroDeMarchas() {
        return numeroDeMarchas;
    }

    public void setNumeroDeMarchas(int numeroDeMarchas) {
        this.numeroDeMarchas = numeroDeMarchas;
    }

    @Override
    public String toString() {
        return  cilindrada + ";" +  possuiCarenagem + ";" + numeroDeMarchas + ';' + super.toString();
    }

}
