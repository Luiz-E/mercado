# MercadoApp

Uma aplicação de mercado para controle de cadastro de produtos e suas respectivas datas de validade. A aplicação está dividida em duas partes: **Back-end** e **Front-end**, cada uma localizada em uma branch separada no repositório.

## Estrutura do Repositório

- **Branch `backend`**: Contém a API responsável por gerenciar os produtos e datas de validade.
- **Branch `frontend`**: Contém a interface do usuário que interage com a API.

## Funcionalidades

### Back-end (Branch: `backend`)
O back-end foi desenvolvido utilizando **Spring Boot** e fornece uma API REST para gerenciar produtos e datas de validade. Ele possui duas rotas principais:

1. **Cadastro de Produtos**
   - `POST /produto/salvar`: Adiciona um novo produto.
   - `GET /produto/listar`: Lista todos os produtos.
   - `PUT /produto/atualizar/{id}`: Atualiza os detalhes de um produto.
   - `DELETE /produto/deletar/{id}`: Remove um produto.
   - `DELETE /produto/excluirDatas/{id}`: Remove um produto, junto das datas relacionadas à ele.

2. **Datas de Validade**
   - `POST /validade/criar`: Adiciona uma data de validade a um produto específico.
   - `GET /validade/listar`: Lista todas as datas de validade e seus produtos.
   - `PUT /validade/excluirProduto`: Remove um produto de uma data de validade.

### Front-end (Branch: `frontend`)
O front-end foi desenvolvido utilizando **Angular** e possui quatro telas principais que interagem com o back-end através de requisições HTTP:

1. **Tela de Listagem de Produtos**: Exibe a lista de todos os produtos cadastrados.
2. **Tela de Adicionar Produto**: Formulário para adicionar um novo produto.
3. **Tela de Atualizar Produto**: Permite a edição dos detalhes de um produto existente.
4. **Tela de Datas de Validade**: Lista e gerencia as datas de validade de cada produto.

## Tecnologias Utilizadas

### Back-end
- **Linguagem**: Java
- **Framework**: Spring Boot
- **Banco de Dados**: MySQL
- **Gerenciamento de dependências**: Maven

### Front-end
- **Linguagem**: TypeScript
- **Framework**: Angular
- **Estilo**: Bootstrap

## Como Executar

### Back-end

1. Clone o repositório e faça checkout na branch `backend`:

   ```bash
   git clone https://github.com/seuusuario/mercadoapp.git
   cd mercadoapp
   git checkout backend
   ```
2. Configure o banco de dados no arquivo `application.properties` e execute a aplicação:
 
    ```bash
   mvn spring-boot:run
   O servidor será iniciado em http://localhost:8080.
   ```

### Front-end
1. Faça checkout na branch `frontend`:

```bash
git checkout frontend
```
2. Instale as dependências do projeto:

```bash
npm install
```
3. Inicie o servidor de desenvolvimento `Angular`:
```bash
ng serve
```
4. Acesse a aplicação em http://localhost:4200.