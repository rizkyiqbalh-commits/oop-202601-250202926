# Penerapan Prinsip SOLID pada Aset-Pinjam

Berikut adalah tiga prinsip SOLID yang diterapkan secara nyata dalam struktur kode proyek Aset-Pinjam:

## 1. Open/Closed Principle (OCP)
* **Kelas/Interface terkait:** `AturanDenda`, `DendaFlat`, `DendaProgresif`
* **Alasan:** 
  Entitas perangkat lunak harus terbuka untuk perluasan (*open for extension*), tetapi tertutup untuk modifikasi (*closed for modification*). Pada proyek ini, logika perhitungan denda dipisahkan ke dalam kontrak interface `AturanDenda`. Ketika dibutuhkan variasi aturan perhitungan denda baru (seperti penambahan `DendaProgresif` di samping `DendaFlat`), kita cukup membuat kelas baru yang mengimplementasikan `AturanDenda` tanpa perlu mengubah kode pada kelas model `Aset` maupun modul peminjaman utama.

## 2. Liskov Substitution Principle (LSP)
* **Kelas terkait:** `Aset` (superclass abstrak) dan `Ruang`, `Laptop`, `AlatLab` (subclass)
* **Alasan:** 
  Objek dari kelas turunan harus dapat menggantikan objek dari kelas induknya tanpa merusak kebenaran program. Seluruh kelas turunan (`Ruang`, `Laptop`, dan `AlatLab`) mengimplementasikan kontrak metode `getJenis()` dan `hitungDenda(int)` dengan tipe kembalian `long` serta validasi input hari negatif yang konsisten dengan kontrak kelas induk `Aset`. Dengan demikian, kelas `KatalogAset` maupun `AturanDenda` dapat memproses berbagai jenis objek `Aset` tanpa perlu melakukan pengecekan tipe kelas secara manual (`instanceof`).

## 3. Dependency Inversion Principle (DIP)
* **Interface & Kelas terkait:** `AturanDenda` (abstraksi), `Aset` (abstraksi), serta `DendaFlat`, `DendaProgresif`, `Ruang`, `Laptop`, `AlatLab` (detail konkret)
* **Alasan:** 
  Modul tingkat tinggi tidak boleh bergantung pada modul tingkat rendah; keduanya harus bergantung pada abstraksi. Pada proyek ini, mekanisme kalkulasi denda maupun pengelolaan katalog tidak bergantung langsung pada kelas konkret (`DendaFlat` atau `Laptop`), melainkan bergantung pada kontrak abstrak `AturanDenda` dan kelas abstrak `Aset`. Pendekatan ini membuat strategi perhitungan denda dapat ditukar secara fleksibel saat runtime dan mempermudah pengujian unit (*testability*) menggunakan objek tiruan atau subkelas uji seperti `TestSupport.aset(...)`.