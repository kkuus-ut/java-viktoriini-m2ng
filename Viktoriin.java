import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Viktoriin {

    private List<Kysimus> kysimused;
    private int punktid;
    private Random random;

    public Viktoriin(List<Kysimus> kysimused) {
        this.kysimused = kysimused;
        this.punktid = 0;
        this.random = new Random();
    }

    public void alustaViktoriin(int arvKysimusi, Scanner skanner) {
        System.out.println("Viktoriin algab!");

        for (int i = 0; i < arvKysimusi; i++) {
            Kysimus k = getSuvaKysimus();
            System.out.println("Mis on riigi " + k.getRiik() + " pealinn?");
            String vastus = skanner.nextLine().trim();

            if (vastus.equalsIgnoreCase(k.getPealinn())) {
                System.out.println("Õige!");
                punktid++;
            } else {
                System.out.println("Vale, õige vastus on: " + k.getPealinn());
            }
        }

        System.out.println("Said " + punktid + "/" + arvKysimusi + " küsimustest õieti.");
    }

    private Kysimus getSuvaKysimus() {
        return kysimused.get(random.nextInt(kysimused.size()));
    }

}
