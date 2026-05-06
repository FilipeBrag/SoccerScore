# SoccerScore

Projeto de mobile que tem como objetivo criar um app para simular um placar de uma partida de futebol, permitindo ao usuario inserir dados de uma partida e visualizar o resultado final. Usando Jetpack Compose e Navigation

# Funcionalidades

O aplicativo é composto por três telas distintas, com passagem de parâmetros via rotas:

Configuração da Partida (Tela 1):

Coleta os nomes dos times e a quantidade de gols marcados.
Validação de campos obrigatórios e tratamento de entrada de dados numéricos.
Navegação para a tela de resumo com os dados informados.

Resumo da Partida (Tela 2):

Exibe de forma clara o placar e os nomes dos times configurados.
Permite a confirmação dos dados para prosseguir ou a edição imediata, retornando à tela de configuração.

Resultado Final (Tela 3):

Aplica a regra de negócio para definir o desfecho da partida (Vitória do Time A, Vitória do Time B ou Empate).
Interface intuitiva com botão para reiniciar o simulador ("Novo Jogo"), limpando o histórico de navegação.

# Tecnologias Utilizadas

Linguagem: Kotlin

UI Toolkit: Jetpack Compose

Navegação: Navigation Compose

Arquitetura: State Hoisting e navegação via rotas tipadas
