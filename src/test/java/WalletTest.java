import org.example.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WalletTest {
    Wallet wallet;

    @BeforeEach
    public void setUp() {
        wallet = new Wallet("Yodhimas Geffananda");
    }

    @Test
    public void testTambahKartu() {
        wallet.tambahKartu("Mastercard");
        assertTrue(wallet.getListKartu().contains("Mastercard"));
    }

    @Test
    public void testAmbilKartu() {
        wallet.tambahKartu("Mastercard");
        String kartu = wallet.ambilKartu("Mastercard");
        assertEquals("Mastercard", kartu);
        assertFalse(wallet.getListKartu().contains("Mastercard"));
    }

    @Test
    public void testTambahUangRupiah() {
        wallet.tambahUangRupiah(5000);
        assertTrue(wallet.getListUangLembaran().contains(5000));
        wallet.tambahUangRupiah(500);
        assertTrue(wallet.getListUangKoin().contains(500));
    }

    @Test
    public void testAmbilUang() {
        wallet.tambahUangRupiah(1000);
        int uang = wallet.ambilUang(1000);
        assertEquals(1000, uang);
        assertFalse(wallet.getListUangLembaran().contains(1000));
    }

    @Test
    public void testTampilkanUang() {
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(500);
        int totalUang = wallet.tampilkanUang();
        assertEquals(5500, totalUang);
    }
    @Test
    public void testAmbilKartu_NotExist() {
        String kartu = wallet.ambilKartu("Credit Card");
        assertNull(kartu);
    }


    @Test
    public void testHitungJumlahUang() {
        wallet.tambahUangRupiah(5000);
        wallet.tambahUangRupiah(500);
        wallet.tambahUangRupiah(1000);
        int totalUang = wallet.tampilkanUang();
        assertEquals(6500, totalUang);
    }

    @Test
    public void testHitungJumlahUang_EmptyWallet() {
        int totalUang = wallet.tampilkanUang();
        assertEquals(0, totalUang);
    }
    @Test
    public void testAmbilUang_MoreThanExists() {
        wallet.tambahUangRupiah(1000);
        assertThrows(Error.class, () -> wallet.ambilUang(2000),
                "Error karena anda mengambil uang lebih dari yang ada");
    }
}