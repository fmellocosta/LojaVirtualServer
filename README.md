# Loja Virtual Server

## Requisitos:
* MySQL 5.6 
* JDK 1.8
* Tomcat 7

## Instalação
* Rodar o script para criação das tabelas MySQL:
```sh
CREATE DATABASE lojavirtual;

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_produto` int(11) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `nome` varchar(500) NOT NULL,
  `cartao` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `produto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(1000) NOT NULL,
  `preco` float NOT NULL,
  `imagem` varchar(5000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
```

* Inserir a configuração abaixo no arquivo WEB.XML do Tomcat:
```sh
	<filter>
		<filter-name>CorsFilter</filter-name>
		<filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
		<init-param>
			<param-name>cors.allowed.headers</param-name>
			<param-value>Accept,Accept-Encoding,Accept-Language,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization,Connection,Content-Type,Host,Origin,Referer,Token-Id,User-Agent, X-Requested-With</param-value>
		</init-param>
		
		<init-param>
			<param-name>cors.allowed.origins</param-name>
			<param-value>*</param-value>
		</init-param>
		
		<init-param>
			<param-name>cors.allowed.methods</param-name>
			<param-value>GET, POST, PUT, DELETE, OPTIONS, HEAD</param-value>
		</init-param> 		
	</filter>
	
	<filter-mapping>
		<filter-name>CorsFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

## Pontos de Melhoria

- Implementar mensageria para tratar as requisições vindas do Client e conforme a fila for caminhando no serviço de mensageria, os pedidos serem processados;

- Melhorar lógica de pedido, como informar quantidades, multiplos produtos, etc;

- Tratar o processamento do cartão, por exemplo: inserir o pedido com um status e um job rodar processando os pedidos com o status AGUARDANDO_PROCESSAMENTO no BD para saber se o cartão foi aceito ou recusado