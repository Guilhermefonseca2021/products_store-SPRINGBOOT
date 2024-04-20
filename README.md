## Objetivo

Criar uma API Restfull para controle de proutos

- [x] Modelo:
    - Produto: id, name, quantity, value, description.

- [x] Repositorio:
    - Produto: obterTodos, obterPorId, adicionar, atualizar, deletar.
  
- [x] Servico:
    - Produtos: obterTodos, obterPorId, adicionar, atualizar, deletar.
    - (usa o repositorio para determinar se vai ter regra de negocio ou nao.)

- [x] Controller de produto:
    - Produto: obterTodos, obterPorId, adicionar, atualizar, deletar.

- [x] Mensagem de error:
  - Exception personalizada, objeto de error e um ouvinte para ativar em qual evento houver.

## MVC

- controller ( rotas )
- model ( modelos do banco )
- repository ( entidades de persistencia de dados )
- services ( onde gravamos, pastas de servicos, regras de negocios. )
