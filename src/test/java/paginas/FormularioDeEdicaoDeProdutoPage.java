package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeEdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeEdicaoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    //quando usar esse metodo ele vai retornar um texto que está na msg
    public String capturarMensagemApresentada(){
        return navegador.findElement(By.cssSelector(".toast.rounded")).getText();//identificar a mgs atraves da classe toast e class rounded
    }
}
