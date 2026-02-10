# 🏢 Sistema de Gestão de Condomínio - Exemplo de Clean Architecture

Este projeto demonstra a implementação de um sistema de cadastro de taxas de condomínio utilizando **Arquitetura Hexagonal** (Ports and Adapters) e princípios de **Clean Code**.  
O foco principal é a **robustez do domínio**, **baixo acoplamento** e uma **pirâmide de testes bem definida**, priorizando testes de alto valor.

---

## 🏛️ Arquitetura

O projeto é dividido em três camadas principais para garantir desacoplamento, testabilidade e evolução sustentável:

1. **Domain (Coração)** 🧠  
   Contém as entidades de negócio e as interfaces (portas).  
   É código Java puro, sem dependências de frameworks ou infraestrutura.

2. **Application (Casos de Uso)** ⚙️  
   Orquestra a lógica de negócio, coordenando o domínio e as portas de saída.  
   Não conhece detalhes técnicos como banco de dados ou web.

3. **Infrastructure (Adaptadores)** 🌍  
   Implementa os detalhes técnicos, como persistência (JPA),  
   controladores REST, configurações e integração com frameworks.

---

## 🧪 Pirâmide de Testes

A qualidade do código é garantida seguindo a **pirâmide de testes clássica**, priorizando testes rápidos, confiáveis e com alto retorno de valor.

- **Testes Unitários (Domínio)**  
  Validam regras de negócio e invariantes da entidade `TaxaCondominio`  
  utilizando **JUnit 5** e **AssertJ**.  
  São rápidos, determinísticos e independentes de infraestrutura.

- **Testes de Serviço (Aplicação)**  
  Utilizam **Mockito** para isolar dependências externas,  
  garantindo que os casos de uso orquestrem corretamente o domínio  
  e interajam com as portas de saída.

- **Testes de Integração (Infraestrutura)**  
  Utilizam **Testcontainers** para subir um container Docker real com  
  **PostgreSQL**, validando a integração real com o banco de dados.

> ⚠️ **Observação Importante**  
> O tradicional teste `contextLoads()` com `@SpringBootTest` foi **intencionalmente removido**,  
> pois não agrega valor significativo à estratégia de testes e pode causar  
> instabilidade em ambientes de CI/CD.  
> A confiabilidade do sistema é garantida por testes de domínio, serviço e integração.

---

## 🛠️ Tecnologias Utilizadas

- **Java 23**
- **Spring Boot 4.0.2**
- **Spring Data JPA**
- **PostgreSQL** (via Docker nos testes de integração)
- **Testcontainers**
- **Lombok**
- **JUnit 5 & AssertJ**
- **Mockito**

---

## 🚀 Como Executar

### ✅ Pré-requisitos

- **Java 23** instalado
- **Docker** instalado (necessário apenas para os testes de integração)

---

### ▶️ Rodar os testes

Para executar toda a pirâmide de testes, utilize:

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

### 📌 Cadastrar nova taxa de condomínio

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
  Taxa cadastrada com sucesso.

* **400 Bad Request**
  Erro de validação de regra de negócio
  (ex: valor negativo ou vencimento inválido).