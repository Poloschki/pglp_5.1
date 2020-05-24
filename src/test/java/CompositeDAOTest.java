import org.junit.Before;
import org.junit.Test;

import java.io.File;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.*;

public class CompositeDAOTest {

  CompositePersonnel cp;
  DAO<CompositePersonnel> dao;

  @Before
  public void init() {
    cp = new CompositePersonnel();
    dao = DAOFactory.getCompositeDAO();
  }

  @Test
  public void create() {
    dao.create(cp);
    File f = new File("compositeDAO");
    assertTrue(f.exists());
  }

  @Test
  public void find() {
    dao.create(cp);
    CompositePersonnel newcp = dao.find("compositeDAO");
    assertEquals(newcp.getNom(),cp.getNom());

  }

  @Test
  public void delete() {
    dao.delete("compositeDAO");
    File f = new File("compositeDAO");
    assertFalse(f.exists());
  }
}