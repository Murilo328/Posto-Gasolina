package br.com.joaocarloslima.posto.model;

public class CortadorDeGrama extends Maquina implements Abastecivel {
    private double capacidadeTanque; 
    private double tanque;

    public CortadorDeGrama(Long id, String nome, int potencia, double capacidadeTanque, double tanque) {
        super(id, nome, potencia);
        this.capacidadeTanque = capacidadeTanque;
        this.tanque = tanque;
    }

    @Override
    public String getIcone() {
        return "🌱";
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
