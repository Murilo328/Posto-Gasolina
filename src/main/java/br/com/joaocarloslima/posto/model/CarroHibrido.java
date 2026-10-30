package br.com.joaocarloslima.posto.model;

public class CarroHibrido extends Veiculo implements Abastecivel, Recarregavel {
    private double capacidadeTanque; 
    private double tanque;
    private double capacidadeBateria; 
    private double bateria;

    public CarroHibrido(Long id, String nome, double capacidadeTanque, double tanque, double capacidadeBateria, double bateria) {
        super(id, nome, 4);
        this.capacidadeTanque = capacidadeTanque;
        this.tanque = tanque;
        this.capacidadeBateria = capacidadeBateria;
        this.bateria = bateria;
    }

    @Override
    public String getIcone() {
        return "🚕";
    }

    @Override
    public double encherTanque() {
        double litros = capacidadeTanque - tanque;
        tanque = capacidadeTanque;
        return litros;
    }

    @Override
    public int getPercentualTanque() {
        return (int) Math.round(tanque / capacidadeTanque * 100);
    }

    @Override
    public double carregarBateria() {
        double kwh = capacidadeBateria - bateria;
        bateria = capacidadeBateria;
        return kwh;
    }

    @Override
    public int getPercentualBateria() {
        return (int) Math.round(bateria / capacidadeBateria * 100);
    }
}
