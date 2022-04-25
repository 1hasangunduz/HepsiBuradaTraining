package com.Api;



public class Routes {

    public static String base_url ="https://petstore.swagger.io/v2";

    public static String post_url ="/user";

    public static String get_put_delete_url ="/user/{username}";

}


//REST API --> JSON, SOAP ---> XML

//Endpoint: API üzerinde belirli bir amaç için oluşturulmuş metodunuza verilen isim.


//GET: Veri çekmek için kullanılır.
//
//POST:Yeni bir kayıt oluşturmak için kullanılır.
//
//PUT: Varolan bir kayıtı güncellemek için kullanılır.
//
//PATCH: Varolan bir kayıtta belirli bir parça üzerinde güncelleme yapılacaksa kullanılabilir. Bu işlem istek yerine tüm güncellemeler için PUT kullanımı da yaygındır.
//
//DELETE: Varolan bir kayıtı silmek için kullanılır.


//Status alanında çıkabilen diğer sonuç kodları ve anlamları:
//
//201 — Başarılı istek ve veriler için.
//204 — Boş cevaplar için.
//400 — Kötü cevap için. İstek anlaşılamadı veya gerekli parametreler eksikti.
//401 — Yetkisiz erişim için. Kimlik doğrulama başarısız oldu veya kullanıcının istenen işlem için izinleri yok.
//403 — Yasak için. Erişim reddedildi.
//404 — Bilgi bulunamadığı için.
//405 — İstek desteklenmediği veya metoda izin verilmediği için.
//500 — Dahili Sunucu Hatası için.
//503 — Kullanılamayan Servis İçin.

