package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //atribuito da classe privado que representa seu navegador
    private WebDriver navegador;


    //construtor da classe que recebe o estado atual do seu navegador e passa pra dentro dessa classe aqui
    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarOUsuario(String usuario){
        navegador.findElement(By.cssSelector("label[for='usuario']")).click(); //no navegador depois de clicar no campo usuario
        navegador.findElement(By.id("usuario")).sendKeys(usuario);//digite no campo com usuario de forma dinamica


        return this;//retornar a proxima pagina, nem que a proxima pagina seja a atual(nesse caso a pagina LoginPage)

    }

    public LoginPage informarASenha(String senha){
        navegador.findElement(By.cssSelector("label[for='senha']")).click();//clicar no campo da senha
        navegador.findElement(By.id("senha")).sendKeys(senha);//digite no campo a senha de forma dinamica tbm

        return this;//retornar a proxima pagina, nem que a proxima pagina seja a atual(nesse caso a pagina LoginPage)
    }


    public ListaDeProdutosPage submeterFormularioDeLogin(){
        navegador.findElement(By.cssSelector("button[type='submit']")).click();//clicar no botão entrar

        return new ListaDeProdutosPage(navegador);//informar o nome da nova pagina e o construtor que no caso é navegador

    }
}
