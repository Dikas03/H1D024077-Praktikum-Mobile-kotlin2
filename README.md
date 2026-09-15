# Praktikum Mobile Kotlin - Pertemuan 2 & 3

**Nama:** DIKAS SETIO PRAMUDO  
**NIM:** H1D024077  
**Shift KRS:** G  
**Shift Baru:** F  

---

## 📱 Deskripsi Aplikasi

Aplikasi **Jualan** adalah platform berbasis Jetpack Compose yang mewadahi produk-produk lokal UMKM di wilayah Kabupaten Purbalingga, Jawa Tengah.

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

## 📸 Tangkapan Layar (Screenshots)

### 1. Halaman Utama (Tentang Jualan)
| Light Mode | Dark Mode |
| :---: | :---: |
| <img src="screenshots/basic_info_light.png" width="300"/> | <img src="screenshots/basic_info_dark.png" width="300"/> |

### 2. Halaman Kontak (Hubungi Kami)
| Light Mode | Dark Mode |
| :---: | :---: |
| <img src="screenshots/form_light.png" width="300"/> | <img src="screenshots/form_dark.png" width="300"/> |

---

## 🛠️ Spesifikasi Teknis
- **UI Toolkit**: Jetpack Compose & Material3
- **Navigasi**: Jetpack Navigation Compose
- **Bahasa**: Kotlin
- **Tema**: Custom `JualanTheme` dengan dukungan Light & Dark Mode
