# 🏢 Sistema de Gestão de Condomínio - Exemplo de Clean Architecture

Este projeto demonstra a implementação de um sistema de cadastro de taxas de condomínio utilizando **Arquitetura Hexagonal** (Ports and Adapters) e **Clean Code**.  
O foco principal é a robustez do domínio e a pirâmide de testes.

---

## 🏛️ Arquitetura

O projeto é dividido em três camadas principais para garantir o desacoplamento:

1. **Domain (Coração)** 🧠  
   Contém as entidades de negócio e as interfaces (portas).  
   É código Java puro, sem dependências de frameworks.

2. **Application (Casos de Uso)** ⚙️  
   Orquestra a lógica de negócio, conectando o domínio aos adaptadores externos.

3. **Infrastructure (Adaptadores)** 🌍  
   Implementa os detalhes técnicos, como persistência em banco de dados (JPA),  
   controladores REST e tratamento de erros.

---

## 🧪 Pirâmide de Testes

A qualidade do código é garantida por diferentes níveis de testes:

- **Testes Unitários (Domínio)**  
  Validam as regras de negócio e restrições da entidade `TaxaCondominio`  
  usando **JUnit 5** e **AssertJ**.

- **Testes de Serviço (Aplicação)**  
  Utilizam **Mockito** para isolar a lógica de orquestração  
  e verificar a interação com as portas de saída.

- **Testes de Integração (Infraestrutura)**  
  Utilizam **Testcontainers** para subir um container Docker real com  
  **PostgreSQL**, garantindo que o adaptador de banco de dados funcione perfeitamente.

---

## 🛠️ Tecnologias Utilizadas

- **Java 23**
- **Spring Boot 4.0.2**
- **Spring Data JPA**
- **PostgreSQL** (via Docker nos testes)
- **Testcontainers**
- **Lombok**
- **JUnit 5 & AssertJ**
- **Mockito**

---

## 🚀 Como Executar

### ✅ Pré-requisitos

- **Java 23** instalado
- **Docker** instalado (necessário para os testes de integração)

---

### ▶️ Rodar os testes

Para executar a pirâmide de testes completa, utilize o comando:

```bash
./mvnw test
````

---

### ▶️ Rodar a aplicação

```bash
./mvnw spring-boot:run
```

---

## 🔌 Endpoints Principais

### 📌 Cadastrar nova taxa

**POST** `/taxas`

#### Corpo da requisição

```json
{
  "valor": 350.00,
  "vencimento": "2026-03-10"
}
```

#### Respostas

* **201 Created**
  Sucesso no cadastro.

* **400 Bad Request**
  Erro de validação de regra de negócio
  (ex: valor negativo).