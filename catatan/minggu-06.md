# Catatan Minggu 06: UML & Prinsip SOLID

## Yang saya kerjakan
Pada minggu ini saya menyusun dokumentasi arsitektur sistem aplikasi Aset-Pinjam berdasarkan kode yang sudah dibuat hingga minggu ke-5. Saya membuat Class Diagram pada `docs/uml/class.mmd` untuk memetakan atribut, metode, visibility, paket, dan relasi antar kelas, serta Sequence Diagram pada `docs/uml/sequence.mmd` untuk memodelkan alur pengajuan peminjaman sukses dan bentrok menggunakan fragmen `alt`. Selain itu, saya juga mendokumentasikan penerapan tiga prinsip SOLID (OCP, LSP, dan DIP) beserta kelas terkaitnya di `docs/uml/solid.md`.

## Keputusan desain
Saya memilih menggunakan format Mermaid (`.mmd`) untuk diagram UML agar mudah dikelola langsung di dalam repositori dan di-render dengan tema kontras yang jelas. Pada dokumentasi `docs/uml/solid.md`, saya memutuskan untuk menonjolkan prinsip **Open/Closed Principle (OCP)** pada `AturanDenda`, **Liskov Substitution Principle (LSP)** pada hierarki `Aset`, serta **Dependency Inversion Principle (DIP)** sebagai pengganti ISP karena lebih mencerminkan ketergantungan nyata modul denda dan katalog terhadap kontrak abstrak di proyek ini.

## Kendala
Sempat mengalami kendala sintaks Mermaid saat merender blok `namespace` di ekstensi preview VS Code versi 10.3.0 serta tampilan garis dan teks diagram yang kurang kontras pada latar preview putih. Masalah ini diatasi dengan mengganti pengelompokan `namespace` menjadi komentar paket eksplisit dan menyesuaikan konfigurasi `%%{init}%%` memakai tema `default` dengan garis hitam pekat serta sorotan blok hijau-merah pada fragmen `alt`.

## Penggunaan AI
- Alat yang dipakai: Gemini, Claude
- Bagian yang dibantu AI: Penyusunan sintaks Mermaid untuk `class.mmd` dan `sequence.mmd`dan penyesuaian tema tampilan diagram.
- Prompt utama: 
  1. `"Jelaskan urutan pengerjaan Minggu 6"`
  2. `"Buatkan kerangka diagram dengan format mmd(mermaid) berdasarkan alur aplikasi Aset-Pinjam"`
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya menolak penggunaan Interface Segregation Principle (ISP) pada `solid.md` dan menggantinya dengan Dependency Inversion Principle (DIP) agar lebih sesuai dengan kondisi nyata kode `Aset-Pinjam` saat ini.
- Satu hal yang saya pahami lebih baik sekarang: Diagram UML harus selalu konsisten dengan struktur kode yang benar-benar ada (bukan sekadar rancangan ideal), dan penggunaan abstraksi seperti interface `AturanDenda` mempermudah pengujian serta perluasan fitur tanpa merombak kelas inti.

## Kuis
1. Perbedaan Aggregation dan Composition:
   - Aggregation adalah hubungan "memiliki" yang bersifat lemah, di mana objek bagian tetap bisa berdiri sendiri secara independen meskipun objek induknya dihapus (contoh: `KatalogAset` menyimpan daftar `Aset`, jika katalog dihapus, objek `Aset` tetap ada).
   - Composition adalah hubungan "bagian dari" yang bersifat kuat, di mana objek bagian bergantung penuh pada objek induknya (jika induk dihapus, bagian di dalamnya ikut hilang).
2. Mengapa OCP (Open/Closed Principle) memudahkan pengembangan:
   - Karena fitur atau variasi perilaku baru dapat ditambahkan dengan membuat kelas/ekstensi baru tanpa perlu mengutak-atik atau mengubah kode lama yang sudah stabil dan teruji, sehingga meminimalkan risiko munculnya bug baru pada fitur yang sudah berjalan.
3. Mengapa DIP (Dependency Inversion Principle) meningkatkan testability:
   - Karena kelas tingkat tinggi bergantung pada abstraksi (interface/abstract class) dan bukan pada implementasi konkret, sehingga saat melakukan pengujian unit kita dapat dengan mudah menyuntikkan objek tiruan atau subkelas uji tanpa harus bergantung pada database, jaringan, atau komponen nyata yang kompleks.