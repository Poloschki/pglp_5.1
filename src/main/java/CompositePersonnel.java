import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompositePersonnel implements Composite, Serializable {
  protected List<Composite> enfantComposite;
  private String nom;

  public CompositePersonnel() {
    this.enfantComposite = new ArrayList<>();
    this.nom = "default";
  }

  public void setEnfantComposite(List<Composite> enfantComposite) {
    this.enfantComposite = enfantComposite;
  }

  @Override
  public void print() {
    for (Composite composite : enfantComposite) {
      composite.print();
    }
  }

  public void add(Composite composite) {
    enfantComposite.add(composite);
  }

  public void remove(Composite composite) {
    enfantComposite.remove(composite);
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
}
