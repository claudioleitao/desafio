/************************************************************************************************************************\
/* README DO SISTEMA                                                                                                    *\
/* DESENVOLVEDOR: CLÁUDIO FERNANDO LEITÃO                                                                               *\
/* DATA DEV: 13/08/2018                                                                                                 *\
/* VERSÃO: 0.0.1 TESTE                                                                                                  *\
/************************************************************************************************************************\

* Para o uso desse sistema é necessário ter instalado o SGBD Mysql com usuário admin e a senha 123456789 para a comunicação
  entre o sistema com o SGBD.

* O usuário deverá importar o banco de dados no Mysql. Com isso tudo já funcionando vamos ao uso
  real do sistema.

* Para ativar o uso, deve-se ir na pasta: br.com.flexpag.postomedicoveterinario e executar o arquivo App.java e
  assim que ativar o servidor, deve-se ir no navegador e digitar: http://localhost:4567/retornarcadastro

* Com isso você irá para a página de retornar consulta.

* Para incluir um novo animal, primeiro se deve clicar no botão "Cadastro Animal". Você será direcionado para a tela de   inclusão do animal. Após incluir, o sistema irá comunicar a inclusão e depois você clica em Voltar e você voltará para a   tela inicial.

* Para incluir um novo veterinario, primeiro se deve clicar no botão "Cadastro Veterinario". Você será direcionado para a   tela de inclusão do veterinario. Após incluir, o sistema irá comunicar a inclusão e depois você clica em Voltar e você   voltará para a tela inicial.

* Para inserir uma nova consulta, primeiro se deve clicar no botão "Incluir Atendimento". Você será direcionado para a     tela de inclusão de atendimento. Após incluir, o sistema irá comunicar a inclusão e depois você clica em Voltar e você     voltará para a tela inicial.

* Agora em relação a tabela da consulta, é possível um cadastro, mas para atualizar a tela infelizmente temos que encerrar   o servidor da aplicação pois o sistema não atualiza automaticamente. Temos também as telas em JFrame caso queira usar. É   só ir na tela TelaPrincipal.java que fica em: br.com.flexpag.postomedicoveterinario.apresentacao.

Esqueleto do sistema:

* br.com.flexpag.postomedicoveterinario (Front-end Servidor Web)
  - App.java
* br.com.flexpag.postomedicoveterinario.apresentacao (janelas com JFrame)
  - TelaPrincipal.java
  - TelaInserirAnimal.java
  - TelaInserirNovoAtendimento.java
  - TelaInserirVeterinario.java
* br.com.flexpag.postomedicoveterinario.bancodados
  - BancoMysql.java
* br.com.flexpag.postomedicoveterinario.entidade
  - (A)Animal.java
  - Atendimento.java
  - Cachorro.java
  - Gato.java
  - Hamster.java
  - MedicoVeterinario.java
  - (A)Pessoa.java
* br.com.flexpag.postomedicoveterinario.excessao (Foi escrito mas Não utilizado no sistema)
  - CamposEmBrancoException.java
  - ConsultaNaoRealizadaException.java
  - EncontradoException.java
  - NaoEncontradoException.java
* br.com.flexpag.postomedicoveterinario.negocio
  - CadastroAnimal.java
  - CadastroAtendimento.java
  - CadastroMedicoVeterinario.java
  - FabricaRepositorio.java
  - Fachada.java (Comunicação entre o front-end com o back-end)
* br.com.flexpag.postomedicoveterinario.repositorio (DAO do sistema)
  - (I)IRepositorioAnimal.java
  - (I)IRepositorioAtendimento.java
  - (I)IRepositorioMedicoVeterinario.java
  - RepositorioAnimal.java
  - RepositorioAtendimento.java
  - RepositorioMedicoVeterinario.java