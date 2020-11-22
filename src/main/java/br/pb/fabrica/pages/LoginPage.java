package br.pb.fabrica.pages;



import org.openqa.selenium.By;


import br.pb.fabrica.core.BasePage;
import br.pb.fabrica.core.DriverFactory;
/*
 *  Analista de Testes: Pedro Carvalho 
 *  Data: 13/10/2020
 *  
 */
public class LoginPage extends BasePage {

	public void AcessarTelaInicial() {
		DriverFactory.getDriver().get("https://contra-partida.herokuapp.com/");
	}
	
	
	public void InserirUsuario(String usuario) {
		escrever(By.name("username"), usuario);
	}
	
	public void InserirSenha(String senha) {
		escrever(By.id("id_password"), senha);
	}

	public void ClicarBotao() {
		clicarBotao(By.xpath("//button"));
	}
	
}
