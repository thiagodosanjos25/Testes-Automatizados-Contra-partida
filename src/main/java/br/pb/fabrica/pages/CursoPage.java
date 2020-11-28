package br.pb.fabrica.pages;

import static br.pb.fabrica.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import br.pb.fabrica.core.BasePage;
import br.pb.fabrica.core.DriverFactory;

/*
 *  Analista de Testes: Thiago dos Anjos Bezerra
 *  Data: 28/11/2020
 *  
 */

public class CursoPage extends BasePage {
		
		
	public void acessarTelaCadastro() {
		clicarLink("Criar Curso");
	}
	
	public void acessarTelaCurso() {
		clicarLink("Curso");
	}
	
	public void clicarAlterar() {
		clicarLink("Alterar Informações");
	}
	
	public void acessarTelaListagem() {
		clicarLink("Lista de Cursos");
	}
	
	public void setCurso (String nomeCurso) {
		
		escreverPorXpath("//*[@id='id_nome']", nomeCurso);		
	}
	
	public void clickBtnEnviar() {
		
		clicarBotao("//button[@type='submit']");
	}
	
	public void clickBtnDeletar() {
		
		clicarBotao("//button[@type='submit']");
	}
	
	public void clickCurso() {
		
		clicarBotao("//*[@id=\"content\"]/div[2]/div[2]/table/tbody/tr[4]/td[1]/a");		
	}
	
	public void clickDeleteCurso() {
		
		clicarBotao("//*[@id=\"content\"]/div[2]/div[2]/table/tbody/tr[4]/td[2]/a");		
	}	
	
	public void clickBtnAlterarCurso() {
		
		clicarBotao("//*[@id=\"content\"]/div[2]/a[1]");		
	}
	
	public void clicarCurso(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void clicarBotaoDeletar(String xpath) {
		clicarBotao(By.xpath(xpath));
	}
	
	public void clicarBtnSubmit() {		
		clicarBotao("//button[@type='submit']");
	}	
	
	public WebElement buscarTabela(){
		return DriverFactory.getDriver().findElement(By.className("table")); 
	}
	
	public int buscarElementoTabela(String valor, int idColuna){
		
		return obterIndiceLinha(valor, buscarTabela(), idColuna);
	}
	
	public String obterTexto(String xpath) {
		return obterTexto(By.xpath(xpath));
	}
	
	
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		
		WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
		celula.findElement(By.xpath(".//input")).click();
		
	}

	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		return idLinha;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		return idColuna;
	}	

}
