# Catatan Minggu 05: Abstraction

## Yang saya kerjakan
Pada minggu ini saya diminta mengimplementasikan konsep abstraksi pada aplikasi Aset-Pinjam. Saya mengubah kelas `Aset` menjadi kelas abstrak serta menambahkan metode abstrak `hitungDenda` dan metode `bisaDipinjam`. Selain itu, saya juga mengimplementasikan interface `AturanDenda` pada kelas `DendaFlat` dan `DendaProgresif`.

## Keputusan desain
Saya memutuskan untuk memakai tipe data `long` pada perhitungan denda, bukan `int`. Untuk `DendaProgresif`, saya buat makin mahal secara bertahap (bervariasi) seiring bertambahnya hari keterlambatan. Untuk rumus lengkapnya ada di bagian A-02 pada `docs/asumsi.md`.

## Kendala
Penyesuaian aturan denda progresif agar memenuhi semua kondisi tes. Masalah ini diatasi dengan me-return tipe `long` secara konsisten di seluruh subclass dan membuat struktur pengali berjenjang yang monotonik naik.

## Penggunaan AI
- Alat yang dipakai: Gemini
- Bagian yang dibantu AI: Penjelasan tentang abstraction dan penerapan kode pada `DendaFlat` dan `DendaProgresif`.
- Prompt utama: `"Bagaimana jika denda progresif dibuat bertahap tapi masih memenuhi syarat test minimum yang ditentukan"`
- Yang saya ubah atau tolak dari saran AI, dan alasannya: Saya menyesuaikan nilai pengali (multiplier) pada rumus progresif agar lebih sederhana dan dipastikan lolos semua kasus uji pada `Minggu05AbstraksiTest`.
- Satu hal yang saya pahami lebih baik sekarang: Kelas abstrak digunakan sebagai fondasi umum yang tidak bisa di-instansiasi langsung, sedangkan interface `AturanDenda` memberikan fleksibilitas untuk menerapkan berbagai strategi perhitungan denda tanpa mengubah struktur kelas aset utama.