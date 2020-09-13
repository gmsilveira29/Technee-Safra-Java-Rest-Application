# Technee-Safra-Java-Rest-Application
 Aplicação java desenvolvida no framework Spring para facilitar a comunicação REST entre a API de Chatbot e a API do banco safra.


Pensando em uma maneira de oferecer escalabilidade para a aplicação, optei por desenvolver um microserviço rest que faria o intermediário entre a API do Safra e nossa API de chatbot.

Esta aplicação roda em uma máquina virtual na AWS, e numa próxima sprint a ideia é executar na máquina virtual através de um conteiner (docker).
Também está no radar adicionar um gateway para este microserviço (Gateway da AWS ou Google ApiGee) para tornar as requisições mais seguras e também dar mais controle aos desenvolvedores e arquitetos.
