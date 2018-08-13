/************************************************************************************************************************\
/* README DO SISTEMA                                                                                                    *\
/* DESENVOLVEDOR: CL�UDIO FERNANDO LEIT�O                                                                               *\
/* DATA DEV: 13/08/2018                                                                                                 *\
/* VERS�O: 0.0.1 TESTE                                                                                                  *\
/************************************************************************************************************************\

* Para o uso desse sistema � necess�rio ter instalado o SGBD Mysql com usu�rio admin e a senha 123456789 para a comunica��o
  entre o sistema com o SGBD.

* O usu�rio dever� importar o banco de dados no Mysql. Com isso tudo j� funcionando vamos ao uso
  real do sistema.

* Para ativar o uso, deve-se ir na pasta: br.com.flexpag.postomedicoveterinario e executar o arquivo App.java e
  assim que ativar o servidor, deve-se ir no navegador e digitar: http://localhost:4567/retornarcadastro

* Com isso voc� ir� para a p�gina de retornar consulta.

* Para incluir um novo animal, primeiro se deve clicar no bot�o "Cadastro Animal". Voc� ser� direcionado para a tela de   inclus�o do animal. Ap�s incluir, o sistema ir� comunicar a inclus�o e depois voc� clica em Voltar e voc� voltar� para a   tela inicial.

* Para incluir um novo veterinario, primeiro se deve clicar no bot�o "Cadastro Veterinario". Voc� ser� direcionado para a   tela de inclus�o do veterinario. Ap�s incluir, o sistema ir� comunicar a inclus�o e depois voc� clica em Voltar e voc�   voltar� para a tela inicial.

* Para inserir uma nova consulta, primeiro se deve clicar no bot�o "Incluir Atendimento". Voc� ser� direcionado para a     tela de inclus�o de atendimento. Ap�s incluir, o sistema ir� comunicar a inclus�o e depois voc� clica em Voltar e voc�     voltar� para a tela inicial.

* Agora em rela��o a tabela da consulta, � poss�vel um cadastro, mas para atualizar a tela infelizmente temos que encerrar   o servidor da aplica��o pois o sistema n�o atualiza automaticamente. Temos tamb�m as telas em JFrame caso queira usar. �   s� ir na tela TelaPrincipal.java que fica em: br.com.flexpag.postomedicoveterinario.apresentacao.

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
* br.com.flexpag.postomedicoveterinario.excessao (Foi escrito mas N�o utilizado no sistema)
  - CamposEmBrancoException.java
  - ConsultaNaoRealizadaException.java
  - EncontradoException.java
  - NaoEncontradoException.java
* br.com.flexpag.postomedicoveterinario.negocio
  - CadastroAnimal.java
  - CadastroAtendimento.java
  - CadastroMedicoVeterinario.java
  - FabricaRepositorio.java
  - Fachada.java (Comunica��o entre o front-end com o back-end)
* br.com.flexpag.postomedicoveterinario.repositorio (DAO do sistema)
  - (I)IRepositorioAnimal.java
  - (I)IRepositorioAtendimento.java
  - (I)IRepositorioMedicoVeterinario.java
  - RepositorioAnimal.java
  - RepositorioAtendimento.java
  - RepositorioMedicoVeterinario.java