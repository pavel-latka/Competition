package latka;

/** @author pavel-latka */
public class Competition {

    public static void main(String[] args) {
        Zavodnik z = new Zavodnik("John", "Doe");
        z.setCasStartu(System.currentTimeMillis() - 8174);
        z.setCasCile();
        z.setKlub("Test club");
        z.setPohlavi('m');
        z.setRocnikNarozeni(1970);
        z.setStartovaciVlna(1);
        z.setZaplatilRegistracniPoplatek(true);
        z.setZavod("Test zavod");

        System.out.println(z);
    }

}
