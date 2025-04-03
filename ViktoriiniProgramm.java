import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ViktoriiniProgramm {
    public static void main(String[] args) {
        Scanner vastuseKuulaja = new Scanner(System.in);

        // LOEN KYSIMUSE FAILIST
        List<Kysimus> kysimusteList = loeKysimusedFailist("kysimused.txt");

        if (kysimusteList.isEmpty()) {
            System.out.println("Küsimusi ei leitud, kontrollige fail üle.");
            // EI LEITUD KYSIMUSI, PROGRAMM LOPETAB TOO
            return;
        }

        System.out.println("Palun sisesta mängumood: (TAVALINE/RASKE)");

        Mängumood mMood = null;

        // SUNNIB KASUTAJAT MANGUMOODI VALIMA

        while (mMood == null) {

            String sisend = vastuseKuulaja.nextLine().trim();

            try {

                mMood = Mängumood.valueOf(sisend.toUpperCase());

            } catch (IllegalArgumentException e) {
                System.out.println(String.format("Mängumoodi %s ei eksisteeri, palun sisesta korrektne mängumood:", sisend));
            }

        }

        // SEGAB KYSIMUSED ARA, ET OLEKS ROHKEM RANDOMNESSI

        Collections.shuffle(kysimusteList);

        Viktoriin viktoriin = new Viktoriin(kysimusteList, mMood);

        viktoriin.alustaViktoriin(5, vastuseKuulaja); // ALUSTAB VIKTORIINIGA
    }

    private static List<Kysimus> loeKysimusedFailist(String failinimi) {
        List<Kysimus> kysimused = new ArrayList<>();

        try {
            Scanner skannija = new Scanner(new File(failinimi));

            // IGAL REAL ON RIIGINIMI, PEALINN, SEE KOOD LOEB IGALT FAILILT RIIGI JA PEALINNA PAARI
            // NING LOOB SELLE ABIL KYSIMUSE OBJEKTI, MIS LAHEB KYSIMUSTE LISTI

            while (skannija.hasNextLine()) {
                String rida = skannija.nextLine();
                String[] osad = rida.split(",");

                String riikNimi = osad[0].strip();
                String riikPealinn = osad[1].strip();

                Kysimus uusRiik = new Kysimus(riikNimi, riikPealinn);
                kysimused.add(uusRiik);
            }
            skannija.close();
            return kysimused;
        } catch (FileNotFoundException e) {
            System.out.println("Faili ei leitud!");
            return kysimused;
        }
    }
}
