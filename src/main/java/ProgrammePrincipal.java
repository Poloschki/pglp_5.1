import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public enum ProgrammePrincipal {
    ENVIRONNEMENT;

    public void serialize(String filename, Object obj) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(obj);

            out.close();
            file.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void run() {
        Personnel p1 = new Personnel
            .Builder("Nom", "Prenom", "fonction")
            .telephone("+3333333333")
            .naissance(LocalDateTime.of(1997, 12, 12, 12, 12))
            .build();
        //serialize("sere.txt",p1);
    }

    public static void main(String[] args) {
        ENVIRONNEMENT.run();
    }

}
