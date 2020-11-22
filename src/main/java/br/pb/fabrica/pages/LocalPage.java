package br.pb.fabrica.pages;

import static br.pb.fabrica.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.pb.fabrica.core.BasePage;
import br.pb.fabrica.core.DriverFactory;

public class LocalPage extends BasePage {
	
	public void AcessarTelaCadastro() {
		DriverFactory.getDriver().get("https://contra-partida.herokuapp.com/gestao/createlocal/");
	}

    public void setNome(String texto){
        escrever("id_nome", texto);
    }
    
    public void clicarLocal(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}


    /* BotÃµes */

    public void clicarBotaoEnviar(){
        clicarBotao("//button[text()='Enviar']");
    }
    
    public void clicarBotaoDeletar(String xpath) {
		clicarBotao(By.xpath(xpath));
	}
    
    public void clicarBotaoAlterar(){
        clicarBotao("//button[text()='Alterar']");
    }
    
    public void clicarBtnSubmit() {		
		clicarBotao("//button[@type='submit']");
	}	

    public void acessarCadastro() {
		clicarLink("Cadastrar Local");
	}
	
	public void acessarConvenio() {
		clicarLink("Convênio");
	}
	
	public void acessarListagem() {
		clicarLink("Lista de Locais");
	}
	
	public WebElement buscarTabela(){
		return DriverFactory.getDriver().findElement(By.className("table")); 
	}
	
	public int buscarElementoTabela(String valor, int idColuna){
		
		return obterIndiceLinha(valor, buscarTabela(), idColuna);
	}
	
    
    
}
