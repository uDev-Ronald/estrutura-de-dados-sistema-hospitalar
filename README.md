# Gestão Hospitalar e Triagem

Trabalho da disciplina **Estrutura de Dados 2026.2** (Profa. Karina Leite).
Aplicação em Java que simula o cadastro de pacientes e a fila de espera da emergência de um hospital, usando as estruturas de dados.

- Tema 02: Sistema de Gestão Hospitalar e Triagem

- Integrantes

- Ronald
- Danilo

- Estruturas de dados utilizadas

| Estrutura | Para que serve no sistema | Arquivos |
|---|---|---|
| Árvore Binária de Busca (ABB) | Cadastro de pacientes, com busca pelo número do prontuário | `ArvorePacientes.java`, `NoArvore.java` |
| Fila | Fila de espera para atendimento na emergência | `FilaEmergencia.java`, `NoFila.java` |
| Lista Encadeada | Histórico de consultas de cada paciente | `ListaConsultas.java`, `NoLista.java` |

Outras classes:

- `Paciente.java`: dados do paciente (prontuário, nome e a lista com o histórico de consultas)
- `Consulta.java`: dados de uma consulta (data e descrição)
- `Main.java`: menu do sistema e regras que ligam as três estruturas

## Métodos implementados

**Árvore (ABB)**
- `inserirPaciente`: insere respeitando a regra da ABB (menor à esquerda, maior à direita)
- `buscarPaciente`: busca pelo prontuário
- `removerPaciente`: remove tratando nó folha, nó com 1 filho e nó com 2 filhos
- `emOrdem`, `preOrdem` e `posOrdem`: percursos da árvore

**Fila**
- `enfileirar`: coloca o paciente no fim da fila
- `desenfileirar`: tira o paciente do início da fila
- `buscar`: procura um paciente na fila pelo prontuário
- `listar`: mostra a fila de espera

**Lista encadeada**
- `adicionar`: adiciona uma consulta no fim do histórico
- `buscar`: procura uma consulta pela data
- `remover`: remove uma consulta pela data
- `listar`: mostra o histórico de consultas

Como o sistema funciona?

1. O paciente é **cadastrado** e entra na **árvore**.
2. Quando chega na emergência, ele é colocado na **fila** (só entra na fila quem já está cadastrado).
3. Ao **atender o próximo** paciente, o paciente sai da fila e a consulta é guardada na **lista encadeada** do histórico dele.

**Regra do sistema: um paciente que está na fila de espera não pode ser removido do cadastro.**

- Menu

```
1 - Cadastrar paciente
2 - Buscar paciente
3 - Remover paciente do cadastro
4 - Mostrar pacientes (3 percursos)
5 - Colocar paciente na fila
6 - Atender proximo da fila
7 - Listar fila de espera
8 - Ver historico de consultas
9 - Remover consulta do historico
0 - Sair
```
Como executar

É preciso ter o Java instalado. Na pasta do projeto, rode:

```
javac *.java
java Main
```

## Exemplo de uso

1. Cadastre alguns pacientes (opção 1), por exemplo os prontuários 50, 30, 70, 20, 40, 60 e 80.
2. Use a opção 4 para ver os três percursos da árvore.
3. Coloque pacientes na fila (opção 5) e liste a fila (opção 7).
4. Atenda o próximo (opção 6), informando a data e a descrição da consulta.
5. Veja o histórico do paciente atendido (opção 8).
