package modulos.produtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@DisplayName("Testes Web do Modulo de Produtos")
public class ProdutosTest {
    @Test
    @DisplayName("Nao e permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){
       //Abrir o navegador(setar uma propriedade para falar que é o chromedriver que vai ser intermediario entre nosso script e o brower)
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        //Vou maximar a tela
        navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrão de até 5 segundos
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       //Navegar para a pagina da Lojinha Web
        navegador.get("http://165.227.93.41/lojinha-web-bugada/v2/");

       //Fazer login
        navegador.findElement(By.cssSelector("label[for='usuario']")).click(); //no navegador depois de clicar no campo usuario
        navegador.findElement(By.id("usuario")).sendKeys("admin");//digite no campo com id:usuario admin

        navegador.findElement(By.cssSelector("label[for='senha']")).click();//clicar no campo da senha
        navegador.findElement(By.id("senha")).sendKeys("admin");//digite no campo a senha

        navegador.findElement(By.cssSelector("button[type='submit']")).click();//clicar no botão entrar


       //Vou preencher dados do produto e o valor sera igual a zero
        navegador.findElement(By.cssSelector("a[href='http://165.227.93.41/lojinha-web/v2/produto/novo']")).click();//clicar no link add produto

        navegador.findElement(By.cssSelector("label[for='produtonome']")).click();//clicar no campo nome do produto
        navegador.findElement(By.id("produtonome")).sendKeys("Iphone 14 Pro");//digitar no campo o nome do produto a ser add

        navegador.findElement(By.cssSelector("label[for='produtovalor']")).click();//clicar no campo valor do produto
        navegador.findElement(By.id("produtovalor")).sendKeys("0");//digitar o valor 0 no campo valor do produto

        navegador.findElement(By.cssSelector("label[for='produtocores']")).click();//clicar no campo cores do produto
        navegador.findElement(By.id("produtocores")).sendKeys("black, red");//digitar as cores dos produtos no campo


        //outra forma de preencher o formulario sem o clicar exatamente no campo, fazendo assim o seu teste mais rapido
        //navegador.findElement(By.id("produtonome")).sendKeys("Iphone 13");//digitar no campo o nome do produto a ser add
        //navegador.findElement(By.name("produtovalor")).sendKeys("0");//digitar o valor 0 no campo valor do produto
        //navegador.findElement(By.id("produtocores")).sendKeys("black, red");//digitar as cores dos produtos no campo


        //Vou submeter o formulario
        navegador.findElement(By.cssSelector("button[type='submit']")).click();//clicar no botão de enviar o formulario


       //Vou validar que a mgs de erro foi apresentada(então vai aparecer um toast, quando isso ocorrer eu vou pegar esse texto[getText] e
        // jogar na variavel [String mensagemToast] e eu quero validar a mgs será igual ao texto que eu esperava[assertions.assertEquals] )
        // <div class="toast rounded" style="top: 0px; opacity: 1;">O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00</div>

        String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();//identificar a mgs atraves da classe toast e class rounded
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);

        //Vou fechar o navegador
        navegador.quit();
    }

}
