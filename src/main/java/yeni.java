//import dev.failsafe.internal.util.Assert;
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class yeni {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.network.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();


        String firstUrl = driver.getCurrentUrl();
        System.out.println("Başlangıç sayfam: " + firstUrl);


        WebElement aramakutusu = driver.findElement(By.id("search"));

        //Arama kutusu Ceket
        aramakutusu.sendKeys("ceket");
        aramakutusu.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //sayfa linki


        driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']")).click();

        Thread.sleep(3000);
        //scroll


        Thread.sleep(3000);
        //indirimli ürünlerde ilkine tıklama
        //System.out.println("deger = " + driver.findElements(By.className(".product__discountPercent")).get(0));

        driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div/div[47]/div/div[2]/a/h3")).click();
        String beden = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div/div[5]/div[3]/div[3]/label")).getText();
        System.out.println("deger= " + beden);
        String fiyat = driver.findElement(By.cssSelector(".product__price.-actual")).getText();
        System.out.println("fiyat= " + fiyat);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div/div[5]/div[3]/div[3]/label")).click();
        driver.findElement(By.cssSelector(".product__button.-addToCart.btn.-black")).click();

        //ürün beden bilgisi



        Thread.sleep(3000);
        String beden1 = driver.findElement(By.cssSelector("div[class=\"header__basketProductDesc\"]>div:nth-of-type(2)>div")).getText();
        System.out.println("deger1= " + beden1);
        String fiyat1 = driver.findElement(By.cssSelector(".a-product__price.-salePrice")).getText();
        System.out.println("fiyat1= " + fiyat1);


        Assert.assertEquals(beden,beden1);
        Assert.assertEquals(fiyat,fiyat1);
        System.out.println("beden ve fiyat değerleri kontrol edildi.");

        //eski fiyat
        //String eskiFiyat = driver.findElement(By.cssSelector(".product__price.-label.-old")).getText();
        //System.out.println("Eskifiyat= " + eskiFiyat);
        //String r = eskiFiyat.replace("3.549,00 TL","3.549");
        //Double eskiFiyat1 = Double.parseDouble(r);
        // System.out.println(eskiFiyat1);

        // String yeniFiyat = driver.findElement(By.xpath("//*[@id=\"header__desktopBasket\"]/div/div[2]/div/div[2]/span[1]")).getText();
        //System.out.println("fiyat1= " + yeniFiyat);
        //String r1 = yeniFiyat.replace("1.299,00 TL","1.299");
        //Double yeniFiyat1 = Double.parseDouble(r1);
        //System.out.println(yeniFiyat1);

        //if (eskiFiyat1 > yeniFiyat1) {
        //     System.out.println("eski fiyatın yeni fiyattan büyük olduğu kontrol edildi.");
        //}

        //sepete devam et
        driver.findElement(By.cssSelector(".button.-primary.header__basket--checkout.header__basketModal.-checkout")).click();

        //devam et
        driver.findElement(By.cssSelector(".continueButton.n-button.large.block.text-center.-primary")).click();

        //button'un getText'ini alıp assert edicek kendi Giriş Yap textinle.

        //email sendkeys

        driver.findElement(By.cssSelector("#n-input-email")).sendKeys("irfan.isler2@gmail.com");

        //password sendkeys
        driver.findElement(By.cssSelector("#n-input-password")).sendKeys("irfan1221.");

        //giriş yap
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();








        //en son kontrol sepet boş mu?
        String bosSepet = driver.findElement(By.cssSelector(".header__emptyBasketText")).getText();
        Assert.assertEquals(bosSepet,"Sepetiniz Henüz Boş");
        System.out.println("sepetin boş olduğu kontrol edildi.");
    }
}
