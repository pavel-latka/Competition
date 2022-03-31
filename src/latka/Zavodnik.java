package latka;

public class Zavodnik {
    private String jmeno;
    private String prijmeni;
    private String zavod;
    private int rocnikNarozeni;
    private char pohlavi;
    private String klub;
    private int registracniCislo;
    private int startovaciVlna;
    private boolean zaplatilRegistracniPoplatek;
    private long casStartu;
    private long casCile;
    private long celkovyDosazenyCas;

    private static int registracniCisloCounter = 1;

    // #region Constructors
    public Zavodnik(String jmeno, String prijmeni) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        priraditRegistracniCislo();
    }
    // #endregion

    // #region Other
    private void priraditRegistracniCislo() {
        this.registracniCislo = Zavodnik.registracniCisloCounter;
        Zavodnik.registracniCisloCounter++;
    }
    // #endregion

    // #region Setters
    public void setCasStartu(long casStartu) {
        if (casStartu < 0) {
            throw new IllegalArgumentException(String.format("Neplatný čas startu: %d", casStartu));
        }

        this.casStartu = casStartu;
    }

    public void setCasStartu() {
        this.setCasStartu(System.currentTimeMillis());
    }

    public void setCasCile(long casCile) {
        if (casCile < 0 || casCile < this.casStartu) {
            throw new IllegalArgumentException(String.format("Neplatný čas cíle: %d", casCile));
        }

        this.casCile = casCile;
        setCelkovyDosazenyCas();
    }

    public void setCasCile() {
        this.setCasCile(System.currentTimeMillis());
    }

    public void setCelkovyDosazenyCas() {
        this.celkovyDosazenyCas = this.casCile - this.casStartu;
    }

    public void setKlub(String klub) {
        verifyValidString(klub);
        this.klub = klub;
    }

    public void setPohlavi(char pohlavi) {
        char inUpperCase = Character.toUpperCase(pohlavi);

        if (inUpperCase != 'M' && inUpperCase != 'Z') {
            throw new IllegalArgumentException(
                    String.format("Expected eiter 'M' or 'Z'. Received: '%c'", pohlavi));
        }

        this.pohlavi = pohlavi;
    }

    public void setRocnikNarozeni(int rocnikNarozeni) {
        verifyGreaterThanZero(rocnikNarozeni);
        this.rocnikNarozeni = rocnikNarozeni;
    }

    public void setStartovaciVlna(int startovaciVlna) {
        verifyGreaterThanZero(startovaciVlna);
        this.startovaciVlna = startovaciVlna;
    }

    public void setZaplatilRegistracniPoplatek(boolean zaplatilRegistracniPoplatek) {
        this.zaplatilRegistracniPoplatek = zaplatilRegistracniPoplatek;
    }

    public void setZavod(String zavod) {
        verifyValidString(zavod);
        this.zavod = zavod;
    }
    // #endregion

    // #region Verifiers
    private void verifyValidString(String val) {
        if (val.length() == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyGreaterThanZero(int val) {
        if (val <= 0) {
            throw new IllegalArgumentException();
        }
    }
    // #endregion

    // #region Getters
    public long getCasCile() {
        return casCile;
    }

    public long getCasStartu() {
        return casStartu;
    }

    public long getCelkovyDosazenyCas() {
        return celkovyDosazenyCas;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getKlub() {
        return klub;
    }

    public char getPohlavi() {
        return pohlavi;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getRegistracniCislo() {
        return registracniCislo;
    }

    public int getRocnikNarozeni() {
        return rocnikNarozeni;
    }

    public int getStartovaciVlna() {
        return startovaciVlna;
    }

    public String getZavod() {
        return zavod;
    }

    public boolean getZaplatilRegistracniPoplatek() {
        return zaplatilRegistracniPoplatek;
    }
    // #endregion

    // #region Other
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Závodník č. %d: %s %s\n", registracniCislo, jmeno, prijmeni));
        stringBuilder.append(String.format("Pohlavi: %s\n", Character.toUpperCase(pohlavi) == 'M' ? "Muž" : "Žena"));
        stringBuilder.append(String.format("Ročník narozeni: %d\n", rocnikNarozeni));
        stringBuilder.append(String.format("Klub: %s\n", klub));
        stringBuilder.append(String.format("Startovací vlna: %d\n", startovaciVlna));
        stringBuilder.append(String.format(
                "Zaplatil registrační poplatek: %s\n", zaplatilRegistracniPoplatek ? "Ano" : "Ne"));
        stringBuilder.append(String.format("Celkový dosažený čas: %.3fs", ((double) celkovyDosazenyCas / 1000)));

        return stringBuilder.toString();
    }
    // #endregion
}