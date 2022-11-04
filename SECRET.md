## Java Spring Boot Secret Key

<p>Java Spring Boot için secret key oluşturup kullanmayı bu örnekte veritabanı bağlantısında göstereceğim adımları tek tek uygulayınız.</p>

1. resources klasörünün altına **.env** adında bir dosya
   oluşturuyoruz. <br> ![Screenshot_1](https://user-images.githubusercontent.com/61664693/200038897-9fb685a1-f440-4e60-928a-76ec42324fc0.png)
   <br><br>
2. **.env** dosyasının içine *key=value* olacak şekilde değişkenlerimizi oluşturup değerlerini veriyoruz. Resimde ben
   veritabanı adımı ve şifremi verdim bunları application.properties dosyasında
   kullanacağım. <br> ![Screenshot_2](https://user-images.githubusercontent.com/61664693/200038901-73f490ec-cc82-40bd-99f7-43d8f789d965.png)
   <br><br>

```java
spring.config.import=optional:classpath:.env[.properties]
```

3. Yukarıdaki kodu kopyalayıp application.properties dosyamıza yapıştırıyoruz. Bu yapıştırdığımız kod .env dosyasını
   import edip kullanmamıza olanak sağlıyor. Ardından resimdeki gibi değişkenleri başında '$' işareti olacak şekilde
   süslü parantez içerisine alarak yazıyoruz.Büyük küçük harf duyarlı o yüzden bire bir .env dosyanızın içinde
   kullandığınız gibi
   yazınız. <br> ![Screenshot_3](https://user-images.githubusercontent.com/61664693/200038902-faad3b86-2e0a-4001-9ad7-3b819bc2adea.png)
   <br><br>

4. Son işlem olarak .gitignore dosyamızın içine **.env** yazarak githuba bu dosyanın yüklenmemesini
   sağlıyoruz. <br> ![Screenshot_4](https://user-images.githubusercontent.com/61664693/200038905-7bd92781-e5fd-416e-aca1-9fa5530d0588.png)
   <br><br>

<center>
<img src="https://media.tenor.com/kCSyr3RpH48AAAAC/kid-goku-kid-goku-clapping.gif">
</center>  