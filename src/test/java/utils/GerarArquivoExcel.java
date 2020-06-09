package utils;

import java.awt.List;
import java.io.FileOutputStream;
import java.nio.file.Paths;

import org.openqa.selenium.WebElement;

import Model.carro;
import jxl.Workbook;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


public class GerarArquivoExcel {

	public static void excel(String titulo, java.util.List<WebElement> listaPreco,java.util.List<WebElement> nomeCarro) throws Exception {
		//Preenchendo os valores no XLS
		
		List Preco= new List();
		List Carro= new List();
		for (WebElement Orc2xls : listaPreco) {
			Preco.add(Orc2xls.getText());	
		}
		for (WebElement Carroxls : nomeCarro) {
			Carro.add(Carroxls.getText());	
		}
		
		String arquivo=Paths.get("").toAbsolutePath().toString() + "\\data\\Massa\\"+titulo+"\\";;

		FileOutputStream src = new FileOutputStream(arquivo+"teste web 2"+".xls");
		WritableWorkbook escreverXls = Workbook.createWorkbook(src);
		WritableSheet ws=escreverXls.createSheet("Validar", 0);
		
		WritableFont w = new WritableFont(WritableFont.ARIAL, 
		        10, WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(w);
		cf.setAlignment(jxl.format.Alignment.CENTRE);
        WritableFont w1 = new WritableFont(WritableFont.ARIAL,10,WritableFont.BOLD);
        w1.setColour(jxl.format.Colour.BLUE);
		WritableCellFormat cf1 = new WritableCellFormat(w1);
        WritableFont w2 = new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD);
        w2.setColour(jxl.format.Colour.RED);
		WritableCellFormat cf2 = new WritableCellFormat(w2);
		
		cf2.setAlignment(jxl.format.Alignment.CENTRE);
		cf2.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
        WritableFont w3 = new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD);
        w3.setColour(jxl.format.Colour.GREEN);
		WritableCellFormat cf3 = new WritableCellFormat(w3);
		
		cf3.setAlignment(jxl.format.Alignment.CENTRE);
		
		cf3.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
		ws.addCell(new jxl.write.Label(0, 0, "Modelo"));
		ws.addCell(new jxl.write.Label(1, 0, "Valor"));
		
		int i=0;
		int coluna=0;
		int linha=1;
		
		for (i=0;i<2;i++) {
			ws.addCell(new jxl.write.Label(coluna, linha, Carro.getItem(i)));
			ws.addCell(new jxl.write.Label(coluna+1, linha, Preco.getItem(i),cf1));
			linha=linha+1;
		}

		escreverXls.write();
		escreverXls.close();
		System.out.print("criei o excel");
		}
	/**
	 * Validando o teste3
	 * @param titulo
	 * @param listaPreco
	 * @param nomeCarro
	 * @param listaInfo
	 * @throws Exception
	 */
	public static void excel2(String titulo, java.util.List<WebElement> listaPreco,java.util.List<WebElement> nomeCarro, java.util.List<WebElement> listaInfo) throws Exception {
		//Preenchendo os valores no XLS
		
		List Preco= new List();
		List Carro= new List();
		List Info=new List();
		for (WebElement Orc2xls : listaPreco) {
			Preco.add(Orc2xls.getText());	
		}
		for (WebElement Carroxls : nomeCarro) {
			Carro.add(Carroxls.getText());	
		}
		for (WebElement Infoxls : listaInfo) {
			Info.add(Infoxls.getText());
		}
		System.out.print(Info.getItemCount());
		String arquivo=Paths.get("").toAbsolutePath().toString() + "\\data\\Massa\\"+titulo+"\\";;
		FileOutputStream src = new FileOutputStream(arquivo+"teste web 3"+".xls");
		WritableWorkbook escreverXls = Workbook.createWorkbook(src);
		WritableSheet ws=escreverXls.createSheet("Validar", 0);
		WritableFont w = new WritableFont(WritableFont.ARIAL, 
		        10, WritableFont.BOLD);
		WritableCellFormat cf = new WritableCellFormat(w);
		cf.setAlignment(jxl.format.Alignment.CENTRE);
        WritableFont w2 = new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD);
        w2.setColour(jxl.format.Colour.RED);
		WritableCellFormat cf2 = new WritableCellFormat(w2);
		cf2.setAlignment(jxl.format.Alignment.CENTRE);
		cf2.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
        WritableFont w3 = new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD);
        w3.setColour(jxl.format.Colour.GREEN);
		WritableCellFormat cf3 = new WritableCellFormat(w3);
		cf3.setAlignment(jxl.format.Alignment.CENTRE);
		cf3.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
		//colunia linha
		ws.addCell(new jxl.write.Label(0, 0, "Modelo"));
		ws.addCell(new jxl.write.Label(1, 0, "Valor"));
		ws.addCell(new jxl.write.Label(2, 0, "Ano"));
		ws.addCell(new jxl.write.Label(3, 0, "KM"));
		ws.addCell(new jxl.write.Label(4, 0, "Cor"));
		ws.addCell(new jxl.write.Label(5, 0, "Cambio"));
		
		int i=0;
		int coluna=0;
		int linha=1;
		int teste=0;
		for (i=0;i<Carro.getItemCount();i++) {
			ws.addCell(new jxl.write.Label(coluna, linha, Carro.getItem(i)));
			ws.addCell(new jxl.write.Label(coluna+1, linha, Preco.getItem(i)));	
			linha=linha+1;
			coluna=0;
		}
		linha=1;
		coluna=2;
		int contador=0;
		for (int j = 0; j < Info.getItemCount(); j++) {
			ws.addCell(new jxl.write.Label(coluna, linha, Info.getItem(j)));
			coluna++;
			if (coluna>5) {
				linha=linha+1;
				coluna=2;
			}	
		}
		escreverXls.write();
		escreverXls.close();
		System.out.print("criei o excel");
		}
	
}
