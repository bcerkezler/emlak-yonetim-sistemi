# 🏠 Emlak Otomasyonu Projesi

Bu proje, Fonet Bilgi Teknolojileri A.Ş.'nin Java Geliştirici aday değerlendirme projesi kapsamında geliştirilmiştir. Bir emlak işletmesine ait müşteri, emlak ve arama işlemlerini yöneten bir web uygulamasıdır.

## 🚀 Kullanılan Teknolojiler

- Java 17
- Spring Boot 3.x
- Spring Data JPA (Hibernate)
- Thymeleaf
- Bootstrap 5
- H2 / PostgreSQL
- Maven

## 📦 Özellikler

- İşyeri kaydı (tek kayıt)
- Müşteri kaydı ve listesi
- Emlak ekleme (müşteriyle ilişkili)
- Dinamik filtreleme ile emlak arama (oda sayısı, metrekare, ısınma vs.)
- Bootstrap ile responsive arayüz

## 🧪 Kurulum

1. Bu repoyu klonlayın:
 ```bash

git clone https://github.com/bcerkezler/emlak-yonetim-sistemi.git
cd emlak-yonetim-sistemi

```
2. IDE ile açın (IntelliJ / Eclipse)
3. application.properties dosyasını ayarlayın (H2 ya da PostgreSQL)
4. Projeyi çalıştırın:
```bash

mvn spring-boot:run

```
5. Uygulama arayüzü:
```bash

http://localhost:8080/

```
