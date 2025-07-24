# Java Kutuphane Sistemi

Bu proje, Java Swing kütüphanesini kullanarak geliştirilmiş bir masaüstü Kütüphane Otomasyonu uygulamasıdır. Kullanıcılar üzerinden öğrenci kaydı, kitap iadesi, personel girişi gibi işlemler yönetilmektedir.

---

## 🚀 Kullanılan Teknolojiler

* **Java** (JDK 8+)
* **Swing** (Kullanıcı Arayüzü için)
* **JDBC** (Veritabanı bağlantıları için)
* **MySQL / SQLite** (veritabanı desteği)

---

## 🔧 Özellikler

* Kullanıcı girişi (LoginGUI)
* Öğrenci kaydı ve listeleme (KaytOgrncGUI, OgrnGUI)
* Kitap iade ekranı (iadeGuI.java)
* Personel işlem ekranı (PersonelGUI)
* Arka plan görsel desteği (arkaplan.gif, kitap2.png.jpg)
* Bağlantı sınıfları (baglanti.java vb.) ile modüler ayrılmıştır

---

## 📁 Dosya Yapısı

```
JAVAPROJE/
├── Kutuphanesistemi/
│   ├── LoginGUI.java            # Kullanıcı girişi
│   ├── KaytOgrncGUI.java       # Öğrenci kayıt ekranı
│   ├── OGrsistmGUI.java        # Sistem ekranı
│   ├── iadeGuI.java            # Kitap iade ekranı
│   ├── PersonelGUI.java        # Personel işlem ekranı
│   ├── baglanti.java           # Veritabanı bağlantı sınıfı
│   ├── *.png / *.jpg / *.gif   # Arayüz görselleri
```

---

## 📆 Kurulum ve Çalıştırma

1. Java JDK 8 veya üzeri kurulu olmalıdır.
2. Projeyi IDE (IntelliJ IDEA, NetBeans, Eclipse) ile aç.
3. `baglanti.java` içindeki veritabanı bilgilerini kendi yapına göre düzenle.
4. `LoginGUI.java` ana sınıfını çalıştır.

```bash
javac *.java
java LoginGUI
```

---

## 😍 Geliştirici Notları

* Proje Swing tabanlı olduğu için herhangi bir sunucuya gerek yoktur.
* Veritabanı dosyası ayrı olarak eklenmeli veya oluşturulmalıdır.
* GUI yapısı sade ve öğrenci dostudur.

---

## 👤 Geliştirici

Bu Swing tabanlı Java projesi, kütüphane otomasyonu deneyimi kazanmak amacıyla **Melikenur Kaya** tarafından geliştirilmiştir.
