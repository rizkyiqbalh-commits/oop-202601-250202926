package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresifnya KEPUTUSAN ANDA (catat di docs/asumsi.md). Syarat minimal yang diuji:
 * 0 hari = 0; tidak pernah lebih murah dari DendaFlat; tidak pernah turun saat hari bertambah.
 */
public class DendaProgresif implements AturanDenda {

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        if (aset == null) {
            throw new IllegalArgumentException("Aset tidak boleh null"); 
        }
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("Hari terlambat tidak boleh negatif");
        }

        long dendaFlat = aset.hitungDenda(hariTerlambat);

        double multiplier;
        if (hariTerlambat >= 30) {
            multiplier = 2.0; 
        } else if (hariTerlambat >= 14) {
            multiplier = 1.5; 
        } else if (hariTerlambat >= 7) {
            multiplier = 1.2; 
        } else {
            multiplier = 1.0;
        }

        return (long) (dendaFlat * multiplier);    
    }
}