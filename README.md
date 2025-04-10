# Microserviço de envio de e-mail

![Java](https://img.shields.io/badge/Java-21-blue?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green?style=for-the-badge&logo=springboot)

API de envio de e-mail utilizando Java, Spring e AWS Simple Email Service. 


## 🚀 Tecnologias Utilizadas
- **Java 21**
- **Spring Boot**
- Amazon Simple Email Service (SES)
- (Opcionalmente integrável com: SendGrid, Mailgun, SparkPost)

## 🛠️ Instalação
**1. Clone o repositório:**
```bash
git clone https://github.com/mariaeac/email-service.git
```

**2. Configure o arquivo application.properties com as credenciais da AWS:**
```bash
aws.accessKeyId=1111111
aws.secretKey=111111
aws.region=region
```

## 🔗 Endpoints
### 📌 Enviar um e-mail
- **Método:** `POST`
- **Endpoint:** `/api/email`
- **Corpo da requisição:**

  ```json
  {
  "to": "email@gmail.com",
  "subject": "teste",
  "body": "teste"
  }
  ```
