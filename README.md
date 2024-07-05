# teste_ekan

Teste empresa Ekan
Passo a passo do desenvolvimento:

Primeiro, comecei criando um projeto Spring Boot. Adicionei as dependências necessárias no pom.xml para poder trabalhar com Spring Data JPA, Spring Web, um banco de dados H2 para testes e SpringDoc para integrar o Swagger.

Depois, configurei o Swagger para documentar a API. Adicionei as dependências do SpringDoc e criar uma classe de configuração para definir como a documentação seria gerada e onde ela poderia ser acessada.

Em seguida, modelei minhas entidades: Beneficiário e Documento. Beneficiário representa os beneficiários do plano de saúde, e Documento representa os documentos associados a esses beneficiários. Também defini o relacionamento entre elas.

Para poder fazer operações de CRUD, criei repositórios que estendem JpaRepository.

Depois, desenvolvi controladores REST para expor endpoints que permitissem a interação com as entidades. Fiz um controlador para Documento, configurando endpoints para criar documentos, atualizar, listar e deletar os documentos existentes.

Usei o Postman para testar os endpoints da API. Configurei uma requisição POST para criar um documento, incluindo todos os dados necessários e a associação com um beneficiário existente.

Rodei a aplicação e acessei a documentação gerada pelo Swagger para verificar se estava tudo certo. Fiz testes no Postman para garantir que os dados estavam sendo salvos corretamente no banco de dados.

Passo a Passo para Rodar o Projeto:

Clone o Repositório do GitHub:
Primeiro, clone o repositório do projeto para a sua máquina. Abra o terminal e execute o comando:
https://github.com/{usuario}/teste_ekan.git - master

Navegue até o Diretório do Projeto:
Vá até o diretório onde o projeto foi clonado:
cd teste_ekan
Verifique as Dependências:
Precisa de ter o Maven e o JDK 17 instalados na sua máquina. Você pode verificar as versões instaladas com os comandos:
mvn -v
java -version
Instale as Dependências do Projeto:
No diretório raiz do projeto, execute o comando para baixar e instalar todas as dependências do projeto definidas no pom.xml:
mvn clean install
Configure o Banco de Dados:
O projeto está configurado para usar um banco de dados H2 em memória para testes.

Execute a Aplicação:
Para rodar a aplicação, use o comando:
mvn spring-boot:run
Acesse a Documentação da API:
Depois que a aplicação estiver rodando, você pode acessar a documentação gerada pelo Swagger no seu navegador, usando a URL:
http://localhost:8080/swagger-ui.html

http://localhost:8080/beneficiarios/
http://localhost:8080/beneficiarios/{id}
http://localhost:8080/documentos
http://localhost:8080/documentos/beneficiario/{id}
