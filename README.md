# Kubernets e Spring Boot

## Sobre o projeto

Microserviços para estudo de Spring Boot com Kubernets.

## Requisitos

### Instalar Docker no Linux

- Atualizar os pacotes do apt:
```
~$ sudo apt update
```

- Remover pacotes antigos do Docker:
```
~$ sudo apt remove docker docker-engine docker.io
```

- Instalar o Docker no SO:
```
~$ sudo apt install docker.io
```

- Adicionar o Docker como um serviço do SO
```
~$ sudo systemctl start docker
~$ sudo systemctl enable docker
```

- Verificar se o Docker foi instalado corretamente:
```
~$ docker --version
```

- O resultado deve ser algo como:
```
Docker version 20.10.21, build 20.10.21-0ubuntu1~22.04.3
```

### Executar o PostgreSQL no Docker

- Criar um contêiner para executar o PostgreSQL:
```
~$ sudo docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
```


## Autor

### Ewerton Carreira

- email: ewertoncarreira@gmail.com
- linkedin: https://www.linkedin.com/in/ewerton-carreira-dev/

