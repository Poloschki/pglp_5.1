import org.junit.Test;

import java.time.LocalDateTime;

public class ProgrammePrincipalTest {

  @Test
  public void serialize() {
    Personnel p1 = new Personnel
        .Builder("Nom", "Prenom", "fonction")
        .telephone("+3333333333")
        .naissance(LocalDateTime.of(1997, 12, 12, 12, 12))
        .build();

    p1.serialize("test");
  }
}