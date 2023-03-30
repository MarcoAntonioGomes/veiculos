package br.edu.infnet.veiculos.model.domain;


import br.edu.infnet.veiculos.exceptions.CapacidadeTransporteInvalidaException;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TCaminhao")
public class Caminhao  extends Veiculo{

    private float capacidadeDeTransporte;
    private String tipoCarroceria;
    private float torque;


    @Override
    public void impressao() {
        System.out.println("#Caminhão");
        System.out.println(this);
    }

    @Override
    public float calcularVenda() throws CapacidadeTransporteInvalidaException {

        if(capacidadeDeTransporte < 1000){
            throw new CapacidadeTransporteInvalidaException("A capacidade de transporte do caminhão não pode ser menor que 1000");
        }

        float valorPorCapacidadeDeTransporte = capacidadeDeTransporte*0.005f;
        return getValor() + valorPorCapacidadeDeTransporte;
    }

    public float getCapacidadeDeTransporte() {
        return capacidadeDeTransporte;
    }

    public void setCapacidadeDeTransporte(float capacidadeDeTransporte) {
        this.capacidadeDeTransporte = capacidadeDeTransporte;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public float getTorque() {
        return torque;
    }

    public void setTorque(float torque) {
        this.torque = torque;
    }

    @Override
    public String toString() {
        return  capacidadeDeTransporte+ ";" + tipoCarroceria + ";" + torque + ';' + super.toString();
    }


}
