
# Desafio Sicredi

Uma api para criação de pautas e sessões de votos.



## Stack utilizada

**Back-end:** Java, Oracle, Spring Web, Spring JPA

**Documentação:** Swagger
## Funcionalidades
### Associado
*GET/associado: busca todos os associados.

*POST/associado: cria um associado.

*PUT/associado/{idAssociado}: atualiza um associado pelo id.

*DELETE/associado/{idAssociado}: deleta um associado pelo id.

### Pauta
*GET/pauta: busca todas as pautas.

*POST/pauta: cria uma pauta.

### Sessao
*GET/sessao: busca todas as sessões.

*POST/sessao: cria uma sessão.

### Voto
POST/voto/{cpf}/{idSessao}: cria um voto validando associado pelo cpf e sessao pelo id.
