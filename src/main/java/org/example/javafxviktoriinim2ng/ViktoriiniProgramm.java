package org.example.javafxviktoriinim2ng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class ViktoriiniProgramm extends Application {

    private List<Kysimus> kysimused;
    private int kysimusteIx = 0;
    private Kysimus praeguneKysimus;
    private int punktid = 0;
    private int kysimuseLoendur = 0;
    private final int vooruMaks = 5;
    private final int maksKysimust = 190;

    //INFO LOGI JAOKS
    private List<String> vooruLogi = new ArrayList<>();
    private int kokkuPunktid = 0;
    private int kokkuKysitud = 0;


    //kysimuseSilt SISALDAB KÜSIMUSE TEKSTI
    //tekstiKast ON KASUTAJA TEKSTI SISENDI KAST
    //vastus ON PROGRAMMI VASTUS
    private Label kysimuseSilt;
    private TextField tekstiKast;
    private Label vastus;

    //KUTSUME, KUI VOOR OTSAS
    private Button jatkaNupp;
    private Button lopetaNupp;
    private HBox nupuriba;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage peaStage) {
        // LOEN KYSIMUSE FAILIST
        kysimused = loeKysimusedFailist("src/main/kysimused.txt");

        if (kysimused.isEmpty()) {
            // EI LEITUD KYSIMUSI, PROGRAMM LOPETAB TOO
            return;
        }

        // SEGAB KYSIMUSED ARA, ET OLEKS ROHKEM RANDOMNESSI
        Collections.shuffle(kysimused);

        //SEADISTAME STSEENI, PAIGUTUSE JA SELLE SEES OLEVAD ELEMENTID
        kysimuseSilt = new Label(" ");
        tekstiKast = new TextField();
        tekstiKast.setPromptText("Sisesta vastus siia");

        Button vastuseNupp = new Button("Sisesta");
        vastuseNupp.setOnAction(e -> kontrolliVastus());

        vastus = new Label();

        jatkaNupp = new Button("Jätka");
        lopetaNupp = new Button("Lõpeta");

        nupuriba = new HBox(10, jatkaNupp, lopetaNupp);
        nupuriba.setPadding(new Insets(10));
        nupuriba.setVisible(false);

        VBox paigutus = new VBox(10, kysimuseSilt, tekstiKast, vastuseNupp, vastus, nupuriba);
        paigutus.setPadding(new Insets(20));

        Scene stseen = new Scene(paigutus, 400, 200);
        peaStage.setScene(stseen);
        peaStage.setResizable(true);
        peaStage.setTitle("Pealinnade Viktoriin");
        peaStage.show();

        jatkaNupp.setOnAction(e -> {
            nupuriba.setVisible(false);
            punktid = 0;
            kysimuseLoendur = 0;
            vooruLogi.clear();
            tekstiKast.setDisable(false);
            jargmineKysimus();
        });

        lopetaNupp.setOnAction(e -> {
            salvestaLogiFaili(2);
            Platform.exit();
        });

        jargmineKysimus();
        //KÜSIME KÜSIMUSE
    }

    private void jargmineKysimus() {
        //KÜSIMUSED ON OTSAS
        if (kysimusteIx >= maksKysimust) {
            tekstiKast.setText("Küsimused on otsas!");
            vastus.setText("Kokku küsitud: " + kysimusteIx + " / " + maksKysimust);
            tekstiKast.setDisable(true);

            //TEEME NUPURIBA TÜHJAKS, JÄÄB AINULT LÕPETA NUPP
            nupuriba.getChildren().clear();
            nupuriba.getChildren().add(lopetaNupp);
            nupuriba.setVisible(true);


            salvestaLogiFaili(2);
            return;
        }

        //KUI VOOR POLE LÄBI JA KÜSIMUSI, JÄTKUB, KÜSIME
        if (kysimuseLoendur < vooruMaks) {
            praeguneKysimus = kysimused.get(kysimusteIx++);
            kysimuseSilt.setText("Mis on riigi " + praeguneKysimus.getRiik() + " pealinn?");
            tekstiKast.clear();
            vastus.setText("");
            kysimuseLoendur++;
        } else {
            // VOORU LÕPP
            tekstiKast.setText("Voor lõppenud!");
            tekstiKast.setDisable(true);
            vastus.setText("Skoor selles voorus: " + punktid + " / " + kysimuseLoendur);

            kokkuPunktid += punktid;
            vooruLogi.add("Skoor selles voorus: " + punktid + " / " + kysimuseLoendur);
            vooruLogi.add("------------------------------------");

            nupuriba.setVisible(true);
            salvestaLogiFaili(1);

        }
    }

    private void kontrolliVastus() {
        String vastus = tekstiKast.getText().trim();
        String logiRida;

        //VAATAME KAS KASUTAJA VASTUS VASTAB KYSIMUSES OLEVALE PEALINNALE
        //IGNOREERIME VÄIKSEID/SUURI TÄHTI
        if (vastus.equalsIgnoreCase(praeguneKysimus.getPealinn())) {
            this.vastus.setText("Õige!");
            punktid++;
            logiRida = "Küsimus: " + praeguneKysimus.getRiik() + ", " + praeguneKysimus.getPealinn() + ". Kasutaja vastus: " + vastus + ", õige!";
        } else {
            this.vastus.setText("Vale! Õige vastus: " + praeguneKysimus.getPealinn());
            logiRida = "Küsimus: " + praeguneKysimus.getRiik() + ", " + praeguneKysimus.getPealinn() + ". Kasutaja vastus: " + vastus + ", vale!";
        }

        vooruLogi.add(logiRida);
        kokkuKysitud++;
        jargmineKysimus();
    }

    private List<Kysimus> loeKysimusedFailist(String failinimi) {
        List<Kysimus> kysimused = new ArrayList<>();

        try (Scanner skannija = new Scanner(new File(failinimi))) {

            // IGAL REAL ON RIIGINIMI, PEALINN, SEE KOOD LOEB IGALT FAILILT RIIGI JA PEALINNA PAARI
            // NING LOOB SELLE ABIL KYSIMUSE OBJEKTI, MIS LAHEB KYSIMUSTE LISTI

            while (skannija.hasNextLine()) {

                String rida = skannija.nextLine();
                String[] osad = rida.split(",");

                Kysimus uusRiik = new Kysimus(osad[0].strip(), osad[1].strip());
                kysimused.add(uusRiik);

            }

        } catch (Exception e) {
            System.out.println("Faili ei leitud!");
        }
        return kysimused;
    }

    private void salvestaLogiFaili(int variant) {
        if (variant == 1) {
            try (FileWriter kirjutaja = new FileWriter("logi.txt", true)) {
                kirjutaja.write("---UUS VOOR---\n");
                for (String rida : vooruLogi) {
                    kirjutaja.write(rida + "\n");
                }
                kirjutaja.write("\n");
            } catch (Exception e) {
                System.out.println("Logifaili kirjutamisel tekkis viga!");
            }
        } else {
            try (FileWriter writer = new FileWriter("logi.txt", true)) {
                writer.write("----SEANSS LÄBI----\n");
                writer.write("Kokku: " + kokkuPunktid + " / " + kokkuKysitud + " punkti\n\n");
            } catch (Exception e) {
                System.out.println("Logifaili kirjutamisel tekkis viga.");
            }
        }
    }
}
