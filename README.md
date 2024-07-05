# Conversor de Moeda
Um simples conversor de moedas em Java, via console, que utiliza a ExchangeRate-API para obter as taxas de câmbio em tempo real.

## Funcionalidades

- Conversão entre diferentes moedas internacionais.
- Exibição do resultado da conversão com duas casas decimais.

## Requisitos

- Java 8 ou superior.
- Bibliotecas Apache HttpClient e Gson (já inclusas no projeto).

## Configuração

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/conversor-de-moedas.git
   cd conversor-de-moedas

## Execução

1. Compile o programa:
   javac -cp ".:lib/*" com/conversormoedas/br/Main.java
2. Execute o programa:
   java -cp ".:lib/*" com.conversormoedas.br.Main

## Como Usar

1. Ao iniciar o programa, escolha a moeda de origem e a moeda de destino digitando o número correspondente.
2. Insira o valor que deseja converter (por padrão, 100 USD).
3. O programa mostrará o resultado da conversão com duas casas decimais.
4. Você terá a opção de continuar fazendo conversões ou sair do programa.

## Exemplo de Uso
![Programa de Conversão de Moedas](https://github.com/souzarayane/conversorDeMoedaAPI/blob/main/ConversorDeMoedas.png)

