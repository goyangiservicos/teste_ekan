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
