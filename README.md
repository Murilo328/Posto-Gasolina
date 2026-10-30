# ⛽ Posto de Combustível e Recarga

Projeto de POO em Java + Spring Boot. Um posto atende uma fila de clientes bem diferentes entre si (carro, moto, bicicleta, carro elétrico, híbrido, patinete elétrico, gerador e cortador de grama). Cada um usa a bomba, o carregador, os dois ou nenhum.

A interface visual é um pequeno jogo em 3D: clique em um cliente, escolha **Abastecer** ou **Recarregar** e veja o resultado (✔ atendido, ✖ não usa).

## ▶️ Como rodar

**Requisitos:** Java 17 ou superior e conexão com a internet (a tela carrega o three.js online).

**Pela IDE (VS Code, IntelliJ, Eclipse):** abra a pasta do projeto e execute a classe `PostoApplication`.

**Pelo terminal:**

| Sistema | Comando |
| --- | --- |
| Windows (Git Bash ou PowerShell) | `./mvnw.cmd spring-boot:run` |
| Linux / macOS | `./mvnw spring-boot:run` |

Depois abra no navegador: **http://localhost:8080**

Se a porta 8080 estiver ocupada, troque em `src/main/resources/application.properties` com `server.port=8081`.

## 🧩 Como funciona

O `Posto` não sabe quem é o cliente. Ele só pergunta **o que o cliente sabe fazer**, por meio de duas interfaces:

| Interface | Métodos |
| --- | --- |
| `Abastecivel` | `double encherTanque()` e `int getPercentualTanque()` |
| `Recarregavel` | `double carregarBateria()` e `int getPercentualBateria()` |

| Cliente | Abastecivel | Recarregavel |
| --- | :---: | :---: |
| Carro | ✅ | |
| Moto | ✅ | |
| Gerador | ✅ | |
| Cortador de grama | ✅ | |
| Carro elétrico | | ✅ |
| Patinete elétrico | | ✅ |
| Carro híbrido | ✅ | ✅ |
| Bicicleta | | |

Na classe `Posto`, os métodos `abastecer`, `recarregar`, `percentualTanque` e `percentualBateria` usam `instanceof Abastecivel` ou `instanceof Recarregavel`, nunca uma classe concreta. Por isso uma classe nova (uma `Van` a diesel, por exemplo) é atendida sem alterar o `Posto`.

## ✅ Resultado esperado

- Gol 1.0: `Gol 1.0 abastecido com 40,0 litros` e barra em 100%.
- BYD Dolphin: `BYD Dolphin recarregado com 45,0 kWh` e barra em 100%.
- Corolla Hybrid: atendido na bomba **e** no carregador.
- Caloi Elite: ✖ nos dois lados (`não usa a bomba de combustível` / `não usa o carregador`).

## 💭 Para pensar

**Por que não colocar `encherTanque()` em `Veiculo`?**
Nem todo veículo tem tanque (bicicleta, patinete). Ter tanque é uma capacidade, não uma categoria.

**O Gerador não é `Veiculo`. Uma classe abstrata resolveria?**
Não bem. Java permite herdar de uma só classe, e o híbrido precisaria de tanque e bateria ao mesmo tempo. Interfaces não têm esse limite.

**O código de `encherTanque()` ficou repetido. Isso incomodou?**
Sim: a mesma lógica está em 5 classes (e a da bateria em 3). Uma melhoria seria usar composição, com uma classe `Tanque` e uma `Bateria` que cada cliente usa por delegação.

## 📁 Estrutura

```
src/main/java/br/com/joaocarloslima/posto/
├── model/        # clientes, interfaces e a classe Posto
├── controller/   # API usada pela tela (não alterado)
└── PostoApplication.java
src/main/resources/
├── templates/    # tela (não alterado)
└── static/js/    # jogo 3D (não alterado)
```
1. Por que não colocar `encherTanque()` direto em `Veiculo`?
2. O `Gerador` não é um `Veiculo`, mas usa a bomba. Uma classe abstrata resolveria isso?
3. O código de `encherTanque()` ficou igual em várias classes. Isso te incomodou?
