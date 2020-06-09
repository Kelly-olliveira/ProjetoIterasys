package PageObject;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObject.BaseSFPage;
import PageObject.Enums.AnoMinimo;
import PageObject.Enums.Marca;
import PageObject.Enums.Modelo;


public class carrosPO extends BaseSFPage{
	
	
	private static By CHK_MARCA = By.xpath("//*[@id='sltMake']/..");
	private static By CHK_MODELO = By.xpath("//*[@id='sltModel']/..");
	private static By CHK_ANOMINIMO = By.xpath("//*[@id='sltYearMin']/..");
	private static By BTN_Buscar = By.xpath("//*[@id='buscaForm']//button[text()='Buscar']");




	public carrosPO(WebDriver webDriver) {
		super(webDriver);
	}

	public boolean isDisplayed() {
		return true;
	}


	public WebElement selecionarMarca() throws Exception {	
		return searchElement.findElementBy(CHK_MARCA, "Combo Marca");
	}
	
	public WebElement preencherMarca(Marca marca) throws Exception {
		return searchElement.findElementBy(marca.getBy(), marca.getTexto());
	}
	
	
	
	public WebElement selecionarModelo() throws Exception {	
		return searchElement.findElementBy(CHK_MODELO, "Combo Modelo");
	}
	
	public WebElement preencherModelo(Modelo modelo) throws Exception {
		return searchElement.findElementBy(modelo.getBy(), modelo.getTexto());
	}
	
	public WebElement selecionarAnoMinimo() throws Exception {	
		return searchElement.findElementBy(CHK_ANOMINIMO, "Combo Ano minimo");
	}
	
	
	public WebElement preencherAnoMinimo(AnoMinimo anoMinimo) throws Exception {
		return searchElement.findElementBy(anoMinimo.getBy(), anoMinimo.getTexto());
	}
	
	public WebElement selecionarBuscar() throws Exception {	
		return searchElement.findElementBy(BTN_Buscar, "Botão Buscar");
	}
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> listaInfo() throws Exception {
		return webDriver.findElements(By.xpath("//*[@id='anunciosForm']//div//a//li"));
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> listaPreco() throws Exception {
		return webDriver.findElements(By.xpath("//*[@id='anunciosForm']//div//a//h3"));
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<WebElement> nomeCarro() throws Exception {
		return webDriver.findElements(By.xpath("//*[@id='anunciosForm']//div//a//h2"));
	}
	
	
}
