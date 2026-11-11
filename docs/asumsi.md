# Asumsi dan Keputusan Desain

Isi bagian ini sendiri. Satu entri per keputusan. Dinilai dari kejelasan alasan dan konsistensi dengan kode dan tes Anda,
bukan dari jawaban "benar".

Format tiap entri:

```
## A-NN: judul singkat
- Pertanyaan: ...
- Keputusan: ...
- Alasan: ...
- Dampak ke kode: ... (kelas/metode)
- Tes yang membuktikan: ... (nama tes di folder mahasiswa/)
```

## Aturan ambigu dari docs/aturan-bisnis.md

Salin setiap pertanyaan ambigu (nomor 1 sampai 7) ke sini dan jawab. Contoh:

## A-01: batas waktu bentrok
- Pertanyaan: 09:00-11:00 dan 11:00-13:00 pada aset yang sama bentrok atau tidak?
- Keputusan: (isi)
- Alasan: (isi)
- Dampak ke kode: (isi)
- Tes yang membuktikan: (isi)

## A-02: denda progresif
- Pertanyaan: Bagaimana rumus progresif jika sudah sampai minggu ke-5 atau lebih?
- Keputusan: Hari 1–6 memakai tarif harian biasa (1.0x). Hari 7–13 memakai 1.2x tarif flat, hari 14–29 memakai 1.5x tarif flat, dan hari ke-30 ke atas memakai 2.0x tarif flat.
- Alasan: Skema pengali bertahap ini saya coba untuk memastikan denda semakin berat seiring lamanya keterlambatan, tidak pernah lebih murah dari tarif flat, tidak pernah turun seiring bertambahnya hari, dan pada hari ke-30 dipastikan 2x lipat lebih mahal dari denda flat.
- Dampak ke kode: `DendaProgresif.hitungDenda`, hari negatif ditolak oleh perhitungan aset. Denda tidak lebih murah dari flat dan terus bertambah ketika hari bertambah. Pada hari ke-30, pengguna dikenakan denda tepat sebesar 200% (2.0x) dari total denda flat harian.