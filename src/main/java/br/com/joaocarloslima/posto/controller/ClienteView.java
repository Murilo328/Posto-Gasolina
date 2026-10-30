package br.com.joaocarloslima.posto.controller;

import br.com.joaocarloslima.posto.model.Cliente;
import br.com.joaocarloslima.posto.model.Posto;

public record ClienteView(Long id, String nome, String tipo, String icone, Integer tanque, Integer bateria) {

    public static ClienteView de(Cliente cliente, Posto posto) {
        return new ClienteView(
                cliente.getId(),
                cliente.getNome(),
                cliente.getTipo(),
                cliente.getIcone(),
                posto.percentualTanque(cliente),
                posto.percentualBateria(cliente));
    }
}
