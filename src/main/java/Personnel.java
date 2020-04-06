import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Personnel implements Composite {
    private final String nom;
    private final String prenom;
    private final String fonction;
    private final LocalDateTime naissance;
    private final List<String> telephone;

    private Personnel(Builder builder) {
        //Required
        nom = builder.nom;
        prenom = builder.prenom;
        fonction = builder.fonction;

        //Optional
        naissance = builder.naissance;
        telephone = builder.telephone;
    }

    @Override
    public void print() {
        System.out.println("Nom " + this.nom);
    }

    public static class Builder {
        //Required
        private final String nom;
        private final String prenom;
        private final String fonction;

        //Optional
        private LocalDateTime currentTime = LocalDateTime.now();
        private LocalDateTime naissance = currentTime.withDayOfMonth(1).withYear(1990).withMonth(1);
        private List<String> telephone = new ArrayList<>();

        public Builder(String nom, String prenom, String fonction) {
            this.nom = nom;
            this.prenom = prenom;
            this.fonction = fonction;
        }

        public Builder naissance(LocalDateTime naissance) {
            this.naissance = naissance;
            return this;
        }

        public Builder telephone(String phone) {
            this.telephone.add(phone);
            return this;
        }

        public Personnel build() {
            return new Personnel(this);
        }

    }

 /*   public static void main(String[] args) {
        Personnel p1 = new Personnel
                .Builder("P1", "P1")
                .build();

    }
 */
}
