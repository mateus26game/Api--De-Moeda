# API de Conversão de Moedas em Java com Consulta de Cotações em Tempo Real

Este projeto implementa uma API de conversão de moedas usando Java e a biblioteca HttpClient para fazer requisições à API externa ExchangeRate-API. Com ele, o usuário consegue consultar as taxas de câmbio de moedas como USD, BRL e PHP e realizar conversões entre essas moedas com base nas cotações atuais.

 Funcionalidades Principais:
--
1 Consulta de Taxas de Câmbio:

* A aplicação faz uma chamada HTTP para a ExchangeRate-API para recuperar as taxas de câmbio da moeda base (USD, por exemplo).
  
* O JSON de resposta é processado usando a biblioteca Gson, que converte o JSON em um objeto Java, facilitando o acesso às taxas de câmbio.
  
2 Estrutura de Armazenamento das Moedas:

* A classe TiposMoedas armazena os valores de conversão para cada moeda.
  
* A aplicação popula este objeto com as taxas de câmbio retornadas, permitindo acessar as cotações atuais para BRL, USD e PHP.
  
3 Opções de Conversão:

* O programa permite ao usuário escolher entre várias opções de conversão:

    Converter de BRL para USD ou PHP.
  
    Converter de USD para BRL ou PHP.
 
    Converter de PHP para USD ou BRL.

* Com base na escolha, a aplicação solicita que o usuário informe o valor a ser convertido e calcula o valor convertido.
  
4 Processamento dos Dados de Conversão:

* O valor da moeda original é multiplicado pela taxa de conversão, fornecendo o valor final convertido.

* A aplicação exibe o resultado final ao usuário.

Principais Tecnologias Utilizadas
--
1 Java: Para desenvolvimento do back-end e lógica de conversão.
2 HttpClient: Biblioteca padrão do Java 11 para realizar requisições HTTP.
3 Gson: Biblioteca para trabalhar com JSON e facilitar a conversão dos dados da API externa para objetos Java.

Como Usar:
--
 Ao executar o programa, o usuário vê uma lista de moedas com suas respectivas cotações.

 O usuário escolhe uma moeda e um valor para realizar a conversão.

 O programa então calcula e exibe o valor convertido, com base nas taxas de câmbio atuais.
