
import org.junit.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class yeni {

    @Test
    public void test01() throws InterruptedException {


        //Chrome açıp Url'e gitme
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.network.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Çerezi Geçme
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        //İlk Sayfa Url
        String firstUrl = driver.getCurrentUrl();
        System.out.println("Başlangıç sayfam: " + firstUrl);

        //Google'a Gitme
        WebElement aramakutusu = driver.findElement(By.id("search"));

        //Arama kutusuna Ceket Yazma
        aramakutusu.sendKeys("ceket");
        aramakutusu.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        Thread.sleep(5000);



        //Daha Fazla Göster Butonu
        driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']")).click();



        Thread.sleep(5000);
        //indirimli ürünlerde ilkine tıklama

        driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div[1]/div[51]/div/div[2]/a/h3")).click();
        Thread.sleep(5000);

        //Beden seçme Yazdırma
        String beden = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div/div[5]/div[3]/div[3]/label")).getText();
        System.out.println("1.beden= " + beden);

        //Fiyat Kontrol
        String fiyat = driver.findElement(By.cssSelector(".product__price.-actual")).getText();
        System.out.println("1.fiyat= " + fiyat);
        Thread.sleep(2000);

        //Sepete Ekleme
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[1]/div[2]/div[2]/div/div[5]/div[3]/div[3]/label")).click();
        driver.findElement(By.cssSelector(".product__button.-addToCart.btn.-black")).click();

        //ürün beden ve fiyat bilgisi karşılaştırma


        Thread.sleep(3000);
        String beden1 = driver.findElement(By.cssSelector("div[class=\"header__basketProductDesc\"]>div:nth-of-type(2)>div")).getText();
        System.out.println("2.beden= " + beden1);
        String fiyat1 = driver.findElement(By.cssSelector(".a-product__price.-salePrice")).getText();
        System.out.println("2.fiyat= " + fiyat1);

        Assert.assertEquals(beden,beden1);
        Assert.assertEquals(fiyat,fiyat1);
        System.out.println("Beden ve fiyat değerleri kontrol edildi. değerler eşit");


        //sepete devam et
        driver.findElement(By.cssSelector(".button.-primary.header__basket--checkout.header__basketModal.-checkout")).click();

        //devam et
        driver.findElement(By.cssSelector(".continueButton.n-button.large.block.text-center.-primary")).click();

        Thread.sleep(2000);
        //email sendkeys

        driver.findElement(By.cssSelector("#n-input-email")).sendKeys("irfan.isler2@gmail.com");
        Thread.sleep(2000);

        //password sendkeys
        driver.findElement(By.cssSelector("#n-input-password")).sendKeys("irfan1221.");
        Thread.sleep(2000);

        //Sign in
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(2000);

        //Logo tıklama
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".img-fluid")).click();

        //sepet kontrol
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".header__icon.-shoppingBag")).click();
        Thread.sleep(2000);

        //sepeten çıkarma
        driver.findElement(By.cssSelector(".header__basketProductRemove")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btn.-black.o-removeCartModal__button")).click();




        //En son kontrol sepet boş mu?
        String bosSepet = driver.findElement(By.cssSelector(".header__emptyBasketText")).getText();
        Thread.sleep(2000);
        String bosSepet2 = driver.findElement(By.cssSelector(".header__emptyBasketText")).getText();
        Assert.assertEquals(bosSepet,bosSepet2);
        System.out.println("Sepetin boş olduğu kontrol edildi.");
        System.out.println("Test Başarıyla Gerçekleşmiştir");
        driver.quit();
    }
}
