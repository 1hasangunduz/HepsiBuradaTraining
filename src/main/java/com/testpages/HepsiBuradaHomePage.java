package com.testpages;


import com.basepages.SeleniumBasePage;
import com.driver.DriverManager;
import com.utility.Log;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HepsiBuradaHomePage extends SeleniumBasePage {

    //Burada constructor oluşturduk ; Web element FindyBy ile oluşturulan webelementleri initialize(başlatmak) oluyor.(eşittir yapmamak gibi.)
    public HepsiBuradaHomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //Homepage'teki; user ikonu bulunan giriş yap box butonu.
    @FindBy(xpath = "//div[@id= 'myAccount']")
    WebElement btnLoginHeader;

    //Giriş yap dedikten sonraki detailsın açıldığı listeki giriş yap butonu.
    @FindBy(xpath = "//a[@id= 'login']")
    WebElement btnLoginDetails;

    //email bilgileri girmek için.
    @FindBy(xpath = "//input[@id='txtUserName']")
    WebElement inputEmail;
    @FindBy(xpath = "//button[@id='btnLogin']")
    WebElement btnLoginEmailArea;

    //password bilgileri girmek için.
    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement inputPassword;
    @FindBy(xpath = " //button[@id='btnEmailSelect']")
    WebElement btnLoginPasswordArea;

    //search arama çubugu.
    @FindBy(xpath = "//div[@class='SearchBoxOld-root']")
    WebElement inputSearchBox;

    //Ara butonu
    @FindBy(xpath = "//div[@class='SearchBoxOld-buttonContainer']")
    WebElement btnSearch;


    /**
     * @param addUrlPlugin : /payment, /account  gibi sayfalara direkt gitmek için kullanılabilir.
     * @return
     */
    public HepsiBuradaHomePage navigateToUrl(String addUrlPlugin) {

        DriverManager.getDriver().get("http://www.hepsiburada.com/" + addUrlPlugin);
        Log.pass("HepsiBurada Web sitesi açıldı.");
        Response response = RestAssured.get("http://www.hepsiburada.com/");
        Log.pass(response.getStatusCode());
        return this;
    }

    public HepsiBuradaHomePage btnLogin() throws InterruptedException {

        btnLoginHeader.click();
        Log.pass("Header kısmındaki ; Giriş yap butonuna tıklandı.");
        Thread.sleep(2000);
        btnLoginDetails.click();
        Thread.sleep(2000);
        Log.pass("Giriş yap alanına tıkladıktan sonra; Liste içerisinde giriş yap butonuna tıklandı.");

        return this;

    }

    public HepsiBuradaHomePage inputLoginData(String email, String password) throws InterruptedException {

        inputEmail.sendKeys(email);
        Log.pass("Email adresi girildi: " + email);

        btnLoginEmailArea.click();
        Log.pass("Giriş yap butonuna email text giriş sayfasında tıklandı.");

        Thread.sleep(2000);

        inputPassword.sendKeys(password);
        Log.pass("Kullanıcı şifresi girildi.");

        btnLoginPasswordArea.click();
        Log.pass("Giriş yap butonuna password sayfasında tıklandı.");

        return this;

    }


}
