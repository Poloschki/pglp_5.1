import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class Personnel implements Composite, Serializable {
  protected final String nom;
  protected final String prenom;
  protected final String fonction;
  protected final LocalDateTime naissance;
  protected final List<String> telephone;

  private Personnel(Builder builder) {
    //Required
    nom = builder.nom;
    prenom = builder.prenom;
    fonction = builder.fonction;

    //Optional
    naissance = builder.naissance;
    telephone = builder.telephone;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public String getFonction() {
    return fonction;
  }

  public LocalDateTime getNaissance() {
    return naissance;
  }

  public List<String> getTelephone() {
    return telephone;
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
    private final LocalDateTime currentTime = LocalDateTime.now();
    private final List<String> telephone = new ArrayList<>();
    private LocalDateTime naissance = currentTime.withDayOfMonth(1).withYear(1990).withMonth(1);

    /**
     * Builder d'un personnel.
     *
     * @param nom      nom un paramètre obligatoire.
     * @param prenom   prénom un paramètre obligatoire.
     * @param fonction fonction un paramètre obligatoire.
     */
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

}
