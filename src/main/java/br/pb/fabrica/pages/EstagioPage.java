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

public class EstagioPage extends BasePage{

	/********** Formulário **********/ 

	public void clicarBotaoCadastro() {		
		clicarBotao(By.xpath("//*[@id='accordionSidebar']/li[4]/a/span"));
	}
	
	public void clicarBotaoAlterar() {		
		clicarBotao(By.xpath("//*[@id=\"content\"]/div[2]/a[1]"));
	}
	
	public void clicarEstagio(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}
	
	public void clicarBtnSubmit() {		
		clicarBotao("//button[@type='submit']");
	}	
	
	public void acessarTelaCadastro() {
		clicarLink("Cadastro");
	}
	
	public void acessarTelaEstagio() {
		clicarLink("Estágio");
	}
	
	public void acessarTelaListagem() {
		clicarLink("Listagem");
	}
	
	
	public void setConcedente(String concedente) {
		selecionarCombo(By.id("id_tipo_de_convenio"), concedente);
	}

	public void setCurso(String curso) {
		selecionarCombo(By.id("id_curso"), curso);
	}

	public void setDisciplina(String disciplina) {
		selecionarCombo(By.id("id_disciplina"), disciplina);
	}				

	public void setTurno(String turno) {
		selecionarCombo(By.id("id_turno"), turno);
	}
	
	public void setQuantidadeDeAlunos(String texto) {
		escrever(By.id("id_quantidade_de_alunos"), texto);
	}

	public void setCustoPorAluno(String texto) {
		escrever(By.id("id_custo_por_aluno"), texto);
	}

	public void setPreceptor(String preceptor) {
		selecionarCombo(By.id("id_preceptor"), preceptor);
	}
	
	public void setLocal(String local) {
		selecionarCombo(By.id("id_local"), local);
	}
	
	public void setTipoDeEstabelecimento(String tipo) {
		selecionarCombo(By.id("id_tipo_de_estabelecimento"), tipo);
	}
	
	public void setSetor(String setor) {
		escrever(By.id("id_setor"), setor);
	}

	public void setData(String data) {
		escrever(By.id("id_dates"), data);
	}
	
	public void clicarBotaoEnviar() {
		clicarBotao(By.xpath("//button[text()='Enviar']"));
	}
	
	public void ClicarBotao() {
		clicarBotao(By.xpath("//button"));
	}
	
	public void clicarBotaoDeletar(String xpath) {
		clicarBotao(By.xpath(xpath));
	}
	
	public String obterTexto(String xpath) {
		return obterTexto(By.xpath(xpath));
	}
	
	public String obterTextoCurso() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[1]/a"));
	}
	
	public String obterTextoDisciplina() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[2]"));
	}
	
	public String obterTextoTipoConvenio() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[3]"));
	}
	
	public String obterTextoPreceptor() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[4]"));
	}
	
	public String obterTextoTurno() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[5]"));
	}	
	
	public String obterTextoSetor() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[6]"));
	}
	
	public String obterTextoQuantidadeAlunos() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[7]"));
	}
	
	public String obterDiasDoEstagio() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[8]"));
	}
	
	public String obterDataDeInicio() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[9]"));
	}
	
	public String obterDataDeTermino() {
		return obterTexto(By.xpath("//*[@id=\"content\"]/div[2]/table/tbody/tr/td[10]"));
	}
	
	
	/********** Tabela **********/ 
	
	
	public WebElement buscarTabela(){
		return DriverFactory.getDriver().findElement(By.className("table")); 
	}
	
	public int buscarElementoTabela(String valor, int idColuna){
		
		return obterIndiceLinha(valor, buscarTabela(), idColuna);
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