import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class PersonnelDAOTest {
  Personnel personnel;
  DAO<Personnel> persDAO;

  @Before
  public void init() {
    personnel = new Personnel.Builder("Bob", "Bib", "Dev").build();
    persDAO = new PersonnelDAO();
  }

  @Test
  public void create() throws IOException, ClassNotFoundException {
    persDAO.create(personnel);
    FileInputStream fileInputStream
        = new FileInputStream("personnelDAO");
    ObjectInputStream objectInputStream
        = new ObjectInputStream(fileInputStream);
    Personnel p2 = (Personnel) objectInputStream.readObject();
    objectInputStream.close();
    assertEquals(personnel.nom, p2.nom);
  }

  @Test
  public void find() {
    persDAO.create(personnel);
    Personnel newPerso = persDAO.find("personnelDAO");
    assertEquals("Bob", newPerso.nom);
  }

  @Test
  public void delete() {
    persDAO.delete("personnelDAO");
    File f = new File("personnelDAO");
    assertFalse(f.exists());
  }
}