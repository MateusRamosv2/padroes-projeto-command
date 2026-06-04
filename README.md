# Padrões de Projeto - Command

---

## Estrutura do Projeto

- **Interface do Padrão (Command):** `Comando` → Define o contrato base que todas as ações do sistema devem seguir. O grande diferencial deste padrão é a presença obrigatória dos métodos `executar()` e `desfazer()`.
- **Comandos Concretos:** `ComandoAprovarPedido` e `ComandoFaturarPedido` → Classes que encapsulam uma solicitação como um objeto. Elas não executam a regra de negócio diretamente; em vez disso, sabem exatamente qual método do objeto de negócio (o Recebedor) devem chamar para avançar ou reverter uma ação.
- **Recebedor / Objeto de Negócio (Receiver):** `PedidoERP` → A entidade real que contém as regras de negócio, as validações e as mudanças de status (como "CRIADO", "APROVADO" e "FATURADO"). É este objeto que sofre as mutações de estado quando os comandos são executados.
- **Invocador / Gerenciador:** `GerenciadorDeComandos` → A classe responsável por solicitar que o comando seja executado. O seu papel arquitetural mais importante é manter um histórico (`List<Comando>`) de tudo o que foi feito no sistema, permitindo a funcionalidade de reverter ações ao acessar o último elemento da lista e acionar o seu método `desfazer()`.
- **Testes:** `GerenciadorDeComandosTest` → Valida, com o uso do JUnit, a correta transição de status do pedido durante o fluxo normal e garante a consistência e segurança dos dados quando uma ação precisa ser desfeita (estorno de faturamento).

---

## Diagrama de Classes

Abaixo está o diagrama de classes representando a estrutura da implementação. O foco deste diagrama é ilustrar o desacoplamento: o `GerenciadorDeComandos` apenas conhece a interface `Comando`, permitindo que novos comportamentos (como `ComandoEnviarPedido` ou `ComandoCancelarPedido`) sejam adicionados no futuro sem a necessidade de alterar a classe gerenciadora.

<img width="567" height="611" alt="Diagrama - Command" src="https://github.com/user-attachments/assets/9e680014-ae66-4aeb-8f04-0d1821425205" />
