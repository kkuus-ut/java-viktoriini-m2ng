import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ViktoriiniProgramm {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner vastuseKuulaja = new Scanner(System.in);
        List<Kysimus> kysimusteList = loeKysimusedFailist("kysimused.txt");

        if (kysimusteList.isEmpty()) {
            System.out.println("Küsimusi ei leitud, kontrollige fail üle.");
        }

        Collections.shuffle(kysimusteList);
        Viktoriin viktoriin = new Viktoriin(kysimusteList);
        viktoriin.alustaViktoriin(5, vastuseKuulaja);
    }

    private static List<Kysimus> loeKysimusedFailist(String failinimi) throws FileNotFoundException {
        List<Kysimus> kysimused = new ArrayList<>();

        try {
            Scanner skannija = new Scanner(new File(failinimi));
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
