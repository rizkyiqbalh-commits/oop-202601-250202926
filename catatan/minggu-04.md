# Catatan Minggu 04: Polymorphism

## Yang saya kerjakan
Pada minggu ini saya diminta mengerjakan bagian Aset dan Katalog sebagai bagian dari pengimplementasian materi Polymorphism. Memakai overriding, tarif denda dibaca dari `Varian.aktif().dendaPerHari`.

## Keputusan desain
Tidak ada keputusan pada minggu ini karena sudah ditentukan aturan pasti. 

## Kendala
Terdapat masalah(problem) pada file namun saat dijalankan dengan maven hasilnya `BUILD SUCCESS`, setelah dengan bantuan AI akhirnya ditemukan masalah pada `int`(setelah `public`) yang seharusnya menggunakan `long`. Serta belum sepenuhnya paham apa penggunaan  `abstract`.

## Penggunaan AI
- Alat yang dipakai: Gemini
- Bagian yang dibantu AI: Penjelasan error pada file kode
- Prompt utama: `"Jelaskan fungsi dari abstract pada kode"`, `"Mengapa terdapat problem pada file namun saat di test menggunakan maven hasilnya success?"`
- Yang saya ubah atau tolak dari saran AI, dan alasannya: -
- Satu hal yang saya pahami lebih baik sekarang: Perbedaan `int` dan `long` yang sebenarnya memiliki fungsi yang sama hanya kapasitasnya yang berbeda (32 bit vs 64 bit), di kasus hitung denda fungsi `long` lebih cocok dipakai.