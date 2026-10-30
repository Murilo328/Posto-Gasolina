package br.com.joaocarloslima.posto.model;

public class Carro extends Veiculo implements Abastecivel {
    private double capacidadeTanque; 
    private double tanque;

    public Carro(Long id, String nome, double capacidadeTanque, double tanque) {
        super(id, nome, 4);
        this.capacidadeTanque = capacidadeTanque;
        this.tanque = tanque;
    }

    @Override
    public String getIcone() {
        return "🚗";
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
}
