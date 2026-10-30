package br.com.joaocarloslima.posto.model;

public class PatineteEletrico extends Veiculo implements Recarregavel {
    private double capacidadeBateria; 
    private double bateria;

    public PatineteEletrico(Long id, String nome, double capacidadeBateria, double bateria) {
        super(id, nome, 2);
        this.capacidadeBateria = capacidadeBateria;
        this.bateria = bateria;
    }

    @Override
    public String getIcone() {
        return "🛴";
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
