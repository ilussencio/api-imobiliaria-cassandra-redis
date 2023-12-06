# API REST para Gerenciamento de Imóveis

Este projeto consiste em uma API RESTful desenvolvida em Java utilizando o framework Spring Boot para gerenciar dados relacionados a imóveis em uma imobiliária. O sistema oferece operações CRUD (Criar, Ler, Atualizar e Deletar) para a entidade "imóvel" e utiliza o banco de dados MongoDB para persistência, além de implementar um sistema de cache com Redis para otimizar o desempenho das consultas.

# Tecnologias Utilizadas
- Java
- Spring Boot
- Cassandra
- Redis
- Docker

### Configuração do Redis usando Docker
Comando para criar o contêiner do Redis
```
docker run -d -p 6379:6379 --name redis-cache redis
```
O Redis será utilizado como cache para aprimorar o desempenho das consultas. Execute o seguinte comando para configurar o Redis em um contêiner Docker.

### Configuração do Cassandra usando Docker
Comando para criar o contêiner do Cassandra
```
docker run -d --name cassandra-db -p 9042:9042 -p 9160:9160 -p 7199:7199 cassandra:latest
```
Comando para acesso ao terminal do Cassandra
```
docker exec -it meu-cassandra cqlsh
```
Comando para criar o keyspace
```
CREATE KEYSPACE IF NOT EXISTS myKeyspace WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
```

O Banco de dados cassandra será utilizado como banco de dadados principal.
### Endpoints da API
1. Cadastrar um novo imóvel
- URL: http://localhost:8080/api/v1/imoveis
- Method: POST
```json
{
    "id": "58251980-93c9-11ee-8fd0-676d1f054639",
    "endereco": "Rua A, 123",
    "tipo_imovel": "CASA",
    "area": 150.5,
    "preco": 500000.00
}
```
2. Obter detalhes de um imóvel
- URL: http://localhost:8080/api/v1/imoveis/{id}
- Method: GET
```json
{
    "id": "58251980-93c9-11ee-8fd0-676d1f054639",
    "endereco": "Rua A, 123",
    "tipo_imovel": "CASA",
    "area": 150.5,
    "preco": 500000.00
}
```
3. Atualizar os detalhes de um imóvel
- URL: http://localhost:8080/api/v1/imoveis
- Method: PUT
```json
{
    "id": "58251980-93c9-11ee-8fd0-676d1f054639",
    "endereco": "Rua A, 123",
    "tipo_imovel": "CASA",
    "area": 150.5,
    "preco": 500000.00
}
```
4. Listar todos os imóveis
- URL: http://localhost:8080/api/v1/imoveis/{id}
- Method: GET
```json
[
	{
      "id": "b4eaae80-9380-11ee-a3ee-070ff3da0974",
      "endereco": "Rua das gaivotas",
      "tipo_imovel": "CASA",
      "area": 1000.0,
      "preco": 2000000.0
    },
    {
        "id": "b4bac4e0-9380-11ee-a3ee-070ff3da0974",
        "endereco": "Rua das flores",
        "tipo_imovel": "APARTAMENTO",
        "area": 45.0,
        "preco": 140000.0
    }
]
```
5. Excluir um imóvel
- URL: http://localhost:8080/api/v1/imoveis/{id}
- Method: DELETE