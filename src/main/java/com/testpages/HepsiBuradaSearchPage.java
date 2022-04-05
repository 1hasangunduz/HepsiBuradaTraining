package com.testpages;

import com.basepages.SeleniumBasePage;
import com.driver.DriverManager;
import com.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HepsiBuradaSearchPage extends SeleniumBasePage {


    public HepsiBuradaSearchPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    //Sol menüden telefon secilmesi için gerekli path.
    @FindBy(xpath = "(//div[@data-test-id='tree-node-wrapper'])[1]")
    WebElement btnCategoryItem;

    //Sol menüden cep telefon secilmesi için gerekli path.
    @FindBy(xpath = "(//div[@data-test-id='tree-node-wrapper'])[1]")
    WebElement btnCategorySubItem;

    //5. ürün tercihi.
    @FindBy(xpath = "(//div[@data-test-id='carousel-container'])[5]")
    WebElement btnSelectProduct;

    //Begen kalp butonu.
    @FindBy(xpath = " //div[@class='customerAccount-Like-2tTNM']")
    WebElement btnFavorite;

    //Favorilere eklenen ürünün toast mesajı
    @FindBy(xpath = "//div[@class='hb-toast-content-holder']")
    WebElement modalToastMessage;

    //Giriş yap altındaki begendiklerim.
    @FindBy(xpath = "//a[@title='Beğendiklerim']")
    WebElement btnMyFavorites;

    //Homepage'teki; user ikonu bulunan giriş yap box butonu.
    @FindBy(xpath = "//div[@id= 'myAccount']")
    WebElement btnLoginHeader;


    public HepsiBuradaSearchPage selectCategoryItem() throws InterruptedException {

        btnCategoryItem.click();
        Log.pass(" Sol menüden; Telefon butonuna tıklandı.");
        Thread.sleep(2000);
        btnCategorySubItem.click();
        Log.pass("Cep telefonu butonuna tıklandı.");
        Thread.sleep(2000);
        return this;

    }

    public HepsiBuradaSearchPage selectProduct() {

        scrollToElement(btnSelectProduct);
        btnSelectProduct.click();
        switchToWindow(); //yeni açılan tabı aktif ettim.
        btnFavorite.click();
        Log.pass("Seçilen ürün detaylardan begen butonuna tıklandı.");
        modalToastMessage.getText().contains("Ürün listenize eklendi");
        return this;

    }

    public HepsiBuradaSearchPage goToMyFovites (){

        btnLoginHeader.click();
        Log.pass("Giriş yap header butonuna tıklandı.");
        scrollToElement(btnLoginHeader);
        btnMyFavorites.click();
        Log.pass("begendiklerime tıklandı.");

        return this;

    }

    public HepsiBuradaSearchPage checkMyFavoritesProduct(){

        getLinkContent("samsung");
        Log.pass("Sepette favorilere eklenen ürün var mı? kontrolü yapıldı.");
        //12.de kaldık.
        return this;
    }





}
