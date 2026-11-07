# Catatan Minggu 03: Inheritance

## Yang saya kerjakan
Pada minggu 3 saya melengkapi field dan konstruktor di bagian `Ruang.java`, `AlatLab.java`, dan `Laptop.java`. Saya membuat class dengan memakai ulang kode induk (Aset). Selaindata umum seperti nama, kode, status dan kondisi, turunan dari Aset perlu ditambahkan data sesuai dengan jenisnya. getJenis() juga ditambahkan di setiap class.

## Keputusan desain
- Data umum (kode, nama, status, kondisi) tidak ditulis ulang, tetap berada di Aset.
- kapasitas ditambahkan pada bagian Ruang, 
- spesifikasi dan nomor inventaris untuk Laptop,
- laboratorium dan tingkatRisiko ditambahkan di bagian AlatLab

## Kendala
Memahami materi Inheritance, fungsi dari konstruktor `super`, dan `@Override`

## Penggunaan AI
- Alat yang dipakai: Gemini
- Bagian yang dibantu AI: Penjelasan materi Inheritance
- Prompt utama: `"Jelaskan materi Inheritance mengenai hierarki class, dan konstruktor super`
- Yang saya ubah atau tolak dari saran AI, dan alasannya: -
- Satu hal yang saya pahami lebih baik sekarang: Fungsi dari konstruktor `super` untuk memanggil kode induk agar tidak perlu menulis ulang kode di subclass.
