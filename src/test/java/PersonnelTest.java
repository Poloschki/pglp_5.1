import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PersonnelTest {

  Personnel p;

  @Before
  public void init() {
    p = new Personnel.Builder("Alpha","Beta","Gama")
            .naissance(LocalDateTime.of(1970,1,1,0,0))
            .telephone("0123456789")
            .build();
  }

  @Test
  public void getNom() {
    assertEquals("Alpha",p.getNom());
  }

  @Test
  public void getPrenom() {
    assertEquals("Beta",p.getPrenom());
  }

  @Test
  public void getFonction() {
    assertEquals("Gama",p.getFonction());
  }

  @Test
  public void getNaissance() {
    assertEquals(LocalDateTime.of(1970,1,1,0,0),p.getNaissance());
  }

  @Test
  public void getTelephone() {

    assertEquals("0123456789",p.getTelephone().get(0));
  }
}