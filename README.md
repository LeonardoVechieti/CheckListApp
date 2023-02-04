# CheckListApp
O sistema desenvolvido tem como objetivo facilitar e aprimorar a organização de processos de controle de qualidade em empresas de produção e expedição de alimentos, transformando métodos manuais em digitais.
Armazenar os dados de forma eletrônica através de um banco de dados relacional, organizando as informações de modo a facilitar a criação um histórico de dados referente aos itens de checagem de conformidades e não conformidades, que em um futuro aprimoramento do software podendo ser gerado relatórios de dados de forma impressa.
Integrar os dados gerados por outros sistemas internos, como por exemplos sistemas ERP ao sistema de checagem mobile.  

A principal função do aplicativo mobile é gerar os dados referentes a checagem de itens essenciais para prosseguimento do carregamento. Toda a aplicação é protegida com autenticação de usuário e qualquer modificação dos dados o usuário é alertado automaticamente. 

O aplicativo mobile foi desenvolvido utilizando o android nativo, utilizando a linguagem Kotlin, XML e SQL. Para persistir os dados no aplicativo foi utilizado a função SecurityPreferences onde alguns dados do usuário e configuração são armazenados diretamente nas variáveis de ambiente do aplicativo, para persistir dados criados e modificados pelo usuário foi utilizado o banco de dados SqLite, que é nativo do android e salvo no próprio dispositivo. Para a escrita do código foi utilizado o ambiente de desenvolvimento e IDE Android Studio, e para testes o ambiente emulado de um dispositivo mobile android. 

Contato do desenvolvedor: leonardovechieti@outlook.com

![alt text](https://github.com/LeonardoVechieti/CheckListApp/blob/master/CheckListAppListLogin.png?raw=true)
![alt text](https://github.com/LeonardoVechieti/CheckListApp/blob/master/CheckListAppHome.png?raw=true)
![alt text](https://github.com/LeonardoVechieti/CheckListApp/blob/master/CheckListAppCreate.png?raw=true)
![alt text](https://github.com/LeonardoVechieti/CheckListApp/blob/master/CheckListAppListAll.png?raw=true)
![alt text](https://github.com/LeonardoVechieti/CheckListApp/blob/master/CheckListAppListCheck.png?raw=true)
![alt text](https://github.com/LeonardoVechieti/CheckListApp/blob/master/CheckListAppSearch.png?raw=true)
