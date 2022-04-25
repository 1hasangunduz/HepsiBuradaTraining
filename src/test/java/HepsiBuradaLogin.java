import com.basepages.BaseTest;
import com.data.GetData;
import com.testpages.HepsiBuradaHomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HepsiBuradaLogin extends BaseTest {


    @Epic("HepsiBurada'da; Kayıtlı kullanıcı ile login olma.")
    @Story("Kullanıcının 'Giriş yap' butonuna tıklayıp, Login işlemlerini gerçekleştirmesi beklenir.")
    @Description("Navigate olunur, Giriş yap tabına gidilir ve Email, Password alanları doldurulup login olunur.")
    @Test
    @Parameters({"addUrlPlugin", "textProductName"})
    public void HepsiBuradaTestCase(@Optional("") String addUrlPlugin,
                                    @Optional("samsung") String textProductName) throws InterruptedException {

        new HepsiBuradaHomePage()
                .navigateToUrl(addUrlPlugin)
                .btnLogin()
                .inputLoginData(GetData.LOGIN_DATA.EMAIL.value, GetData.LOGIN_DATA.PASSWORD.value);

    }
}

