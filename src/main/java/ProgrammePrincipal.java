import java.time.LocalDateTime;

public enum ProgrammePrincipal {
    ENVIRONNEMENT;

    public void run() {
        Personnel p1 = new Personnel
                .Builder("Nom", "Prenom", "fonction")
                .telephone("+3333333333")
                .naissance(LocalDateTime.of(1997, 12, 12, 12, 12))
                .build();
    }

    public static void main(String[] args) {
        ENVIRONNEMENT.run();
    }

}
