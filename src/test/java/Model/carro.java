package Model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;

import com.google.common.cache.Weigher;
import com.itextpdf.text.DocumentException;

import PageObject.BaseSFPage;
import PageObject.carrosPO;
import PageObject.Enums.AnoMinimo;
import PageObject.Enums.Marca;
import PageObject.Enums.Modelo;
import utils.Evidencia;
import utils.GerarArquivoExcel;

@SuppressWarnings("unused")
public class carro extends BaseSFPage {

	private carrosPO carro;
	

	public carro(WebDriver webDriver) {
		super(webDriver);
		carro = new carrosPO(webDriver);
	}

	public boolean isDisplayed() {
		return false;
	}
	
	/**
	 * selecionar  o campo Marca 
	 * @param marca
	 * @throws Exception
	 */
	public void selecionarMarca(Marca marca) throws Exception {
		Evidencia.evidencia();
		command.click(carro.selecionarMarca()); 
		command.click(carro.preencherMarca(marca));
		
	}
	/**
	 * Selecionar o campo Modelo
	 * @param modelo
	 * @throws Exception
	 */
	public void selecionarModelo(Modelo modelo) throws Exception {
		command.click(carro.selecionarMarca());
		command.click(carro.selecionarModelo()); 
		command.click(carro.preencherModelo(modelo));
		
	}
	/**
	 * Selecionar o campo Ano Minimo
	 * @param anoMinimo
	 * @throws Exception
	 */
	public void selecionarAnoMinimo(AnoMinimo anoMinimo) throws Exception {
		command.click(carro.selecionarAnoMinimo()); 
		command.click(carro.preencherAnoMinimo(anoMinimo));
		
	}
	
	/**
	 * Selecionar Buscar
	 * @throws Exception
	 */
	public void selecionarBuscar() throws Exception {
		Evidencia.evidencia();
		command.click(carro.selecionarBuscar());
		
	}
	
	/**
	 * validar as lista da busca
	 * @param titulo
	 * @throws Exception
	 */
	public void listaCarros(String titulo) throws Exception {

		List<WebElement> listaPreco= carro.listaPreco();
		List<WebElement> nomeCarro= carro.nomeCarro();
		GerarArquivoExcel.excel(titulo,listaPreco,nomeCarro);
		
	}
	
	/**
	 * Validar toda a lista da pagina
	 * @param titulo
	 * @throws Exception
	 */
	public void listaCarrosTodos(String titulo) throws Exception {
		List<WebElement> listaInfo= carro.listaInfo(); 
		List<WebElement> listaPreco= carro.listaPreco();
		List<WebElement> nomeCarro= carro.nomeCarro();
		GerarArquivoExcel.excel2(titulo, listaPreco, nomeCarro, listaInfo);
		
	}
	/**
	 * Validar o teste2
	 * @throws DocumentException
	 * @throws Exception
	 */
	public void validarValor() throws DocumentException, Exception {
		Evidencia.evidencia();
		
		Evidencia.gravar("Busca feita com sucesso", "Teste Web 2");
		listaCarros("Teste Web 2");
	}
	
	
	/**
	 * Validar o teste3
	 * @throws DocumentException
	 * @throws Exception
	 */
	public void validarRetornoPag() throws DocumentException, Exception {
		Evidencia.evidencia();
		Evidencia.gravar("Busca feita com sucesso", "Teste Web 3");
		listaCarrosTodos("Teste Web 3");
	}
	
	/**
	 * validar teste 3
	 * @throws DocumentException
	 * @throws Exception
	 */
	public void validarConsultar() throws DocumentException, Exception {
		Evidencia.evidencia();
		Evidencia.gravar("Busca feita com sucesso", "Teste web 1");
	
	}
}