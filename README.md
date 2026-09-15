# Praktikum Mobile Kotlin - Pertemuan 2 & 3

**Nama:** DIKAS SETIO PRAMUDO  
**NIM:** H1D024077  
**Shift KRS:** G  
**Shift Baru:** F  

---

## 📱 Deskripsi Aplikasi

Aplikasi **Jualan** adalah platform berbasis Jetpack Compose yang mewadahi produk-produk lokal UMKM di wilayah Kabupaten Purbalingga, Jawa Tengah. Aplikasi ini dibangun dengan fitur-fitur sebagai berikut:

- **Halaman Utama (`BasicInfoScreen`)**:
  - Menampilkan logo aplikasi **Jualan**.
  - Informasi deskripsi aplikasi dan kartu Misi Kami.
  - Tombol navigasi untuk menuju ke halaman kontak.
  - Sakelar (*Switch*) di TopAppBar untuk mengganti antara **Light Mode** dan **Dark Mode**.

- **Halaman Kontak (`HubungiKamiScreen`)**:
  - Form input Email dan Pesan.
  - Tombol kirim pesan dengan konfirmasi `Snackbar` ("Pesan Terkirim").
  - Tombol navigasi kembali (*Back*) ke halaman utama.
  - Sakelar (*Switch*) di TopAppBar untuk mode terang/gelap.

---

## 🎨 Fitur & Fitur UI (Light & Dark Mode)

1. **Tentang Jualan (BasicInfoScreen)**
   - **Light Mode**: Latar belakang terang dengan aksen hijau (*Primary*).
   - **Dark Mode**: Latar belakang gelap (`#121212`) dengan teks dan komponen kontras tinggi.
   - **Logo**: Logo resmi berupa lingkaran hijau dengan tas belanja dan tunas tanaman.

2. **Hubungi Kami (HubungiKamiScreen)**
   - Input `OutlinedTextField` untuk email dan pesan.
   - Tombol kirim pesan dengan ikon.

---

## 🛠️ Spesifikasi Teknis
- **UI Toolkit**: Jetpack Compose & Material3
- **Navigasi**: Jetpack Navigation Compose
- **Bahasa**: Kotlin
- **Tema**: Custom `JualanTheme` dengan dukungan Light & Dark Mode
