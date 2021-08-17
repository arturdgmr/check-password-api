# Check Password API 
http://localhost:8080/swagger-ui.html#/

adicionar link swagger aws aqui
## Rodando localmente via Docker


> Starting Spring-Boot Application
```shell
docker build -f Dockerfile -t check-password-api .
docker run -p 8080:8080 check-password-api
```
## Acessando API via AWS

Em caso de problema ao rodar aplicação localmente, considere acessar via aws: link_aws



## Arquitetura de Codigo

```
|--- password.api
           |--- config
           |--- controller          
                      |--- vo
           |--- exceptions
           |--- facade
```                                                       

## Separar as validação em classes isoladas usando  `Chain Responsibility`
>  A ideia é que a aplicação tenha validações desacopladas, totalmente independentes uma da outra.
>  Se a regra pra quantidade de caracteres especiais mudar, posso altera-la sem interferir nas demais regras.
>  Se surgirem novas regras, novas classes de validações serão adicionadas ao código, 
>  sem a necessidade de alterar as que já existem.
> 
>  Com as validações sendo tratadas por classes separadas, estamos respeitando alguns dos principios SOLID, 
>  como o princípio da responsabilidade única e o princípio aberto-fechado.
>  Ou seja cada classe de validação tem uma única responsabilidade e 
>  quando novos comportamentos e recursos precisarem ser adicionados no software, devemos estender 
>  e não alterar o código fonte original.




