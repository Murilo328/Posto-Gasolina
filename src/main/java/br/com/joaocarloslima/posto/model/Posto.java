package br.com.joaocarloslima.posto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Posto {
    private static final Locale PT_BR = Locale.forLanguageTag("pt-BR");

    private List<Cliente> fila = new ArrayList<>();

    public Posto() {
        fila.add(new Carro(1L, "Gol 1.0", 50, 10));
        fila.add(new Bicicleta(2L, "Caloi Elite"));
        fila.add(new CarroEletrico(3L, "BYD Dolphin", 60, 15));
        fila.add(new Moto(4L, "Honda CG 160", 14, 3));
        fila.add(new Gerador(5L, "Gerador Toyama", 3000, 15, 2));
        fila.add(new CarroHibrido(6L, "Corolla Hybrid", 43, 8, 1.3, 0.2));
        fila.add(new PatineteEletrico(7L, "Patinete Xiaomi", 0.5, 0.1));
        fila.add(new CortadorDeGrama(8L, "Cortador Tramontina", 1500, 1.0, 0.1));
    }

    public String abastecer(Long id) {
        Cliente cliente = buscar(id);
        if (cliente instanceof Abastecivel abastecivel) {
            double litros = abastecivel.encherTanque();
            return String.format(PT_BR, "%s abastecido com %.1f litros", cliente.getNome(), litros);
        }
        return cliente.getNome() + " não usa a bomba de combustível";
    }

    public String recarregar(Long id) {
        Cliente cliente = buscar(id);
        if (cliente instanceof Recarregavel recarregavel) {
            double kwh = recarregavel.carregarBateria();
            return String.format(PT_BR, "%s recarregado com %.1f kWh", cliente.getNome(), kwh);
        }
        return cliente.getNome() + " não usa o carregador";
    }

    public Integer percentualTanque(Cliente cliente) {
        if (cliente instanceof Abastecivel abastecivel) {
            return abastecivel.getPercentualTanque();
        }
        return null;
    }

    public Integer percentualBateria(Cliente cliente) {
        if (cliente instanceof Recarregavel recarregavel) {
            return recarregavel.getPercentualBateria();
        }
        return null;
    }

    public List<Cliente> getFila() {
        return fila;
    }

    public Cliente buscar(Long id) {
        for (Cliente cliente : fila) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        throw new IllegalArgumentException("Cliente não encontrado: " + id);
    }
}
