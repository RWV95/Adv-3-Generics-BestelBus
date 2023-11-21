import model.Bestelbus;
import model.Pakket;
import model.Tuinmeubel;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author Rowin Vleeshouwer <r.w.vleeshouwer@st.hanze.nl>
 * Testen die kijken of de generieke bestelbus meerdere soorten voorwerpen kan inladen
 */

public class GenericsTest {
    private Bestelbus<Pakket> pakkettenBestelbus;
    private Bestelbus<Tuinmeubel> tuinmeubelBestelbus;

    @Test
    public void laadEnWeigerPakketNegatiefGewicht() {
        // Arrange
        maakPakkettenBestelbus();
        Pakket teZwaarPakket = new Pakket("Henk", "Monopoly", -5);

        // Act
        pakkettenBestelbus.laadVoorwerp(teZwaarPakket);

        // Assert
        assertEquals(0, pakkettenBestelbus.getLading().size());
    }

    @Test
    public void laadEnWeigerTuinmeubelNegatiefGewicht() {
        // Arrange
        maakTuinmeubelBestelbus();
        Tuinmeubel teZwaarTuinmeubel = new Tuinmeubel("Stoel", "3b", -200);

        // Act
        tuinmeubelBestelbus.laadVoorwerp(teZwaarTuinmeubel);

        // Assert
        assertEquals(0, tuinmeubelBestelbus.getLading().size());

    }

    @Test
    public void laadTuinmeubelInBestelbus() {
        // Arrange
        maakTuinmeubelBestelbus();
        Tuinmeubel bankje = new Tuinmeubel("Bankje", "4A", 100);

        // Act
        tuinmeubelBestelbus.laadVoorwerp(bankje);

        // Assert
        assertEquals(1, tuinmeubelBestelbus.getLading().size());

    }

    @Test
    public void laadPakketInBestelbus() {
        // Arrange
        maakPakkettenBestelbus();
        Pakket pakket = new Pakket("Henk", "Muis", 5);

        // Act
        pakkettenBestelbus.laadVoorwerp(pakket);

        // Assert
        assertEquals(1, pakkettenBestelbus.getLading().size());

    }


    private void maakPakkettenBestelbus() {
        pakkettenBestelbus = new Bestelbus<>("PostNL bus", 100);
    }

    private void maakTuinmeubelBestelbus() {
        tuinmeubelBestelbus = new Bestelbus<>("Tuinland bus", 200);
    }
}
