import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class CompositeDAO extends DAO<CompositePersonnel> {


  @Override
  public void create(CompositePersonnel obj) {
    AffichageNode affichage = new AffichageNode(obj, true);
    try (ObjectOutputStream out = new ObjectOutputStream(
            new BufferedOutputStream(
                    new FileOutputStream("compositeDAO")))) {
      while (affichage.hasNext()) {
        out.writeObject(affichage.next());
      }
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public CompositePersonnel find(String id) {
    CompositePersonnel cp = null;
    try (ObjectInputStream input = new ObjectInputStream(
            new BufferedInputStream(
                    new FileInputStream("compositeDAO")))) {
      cp = (CompositePersonnel) input.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return cp;
  }

  @Override
  public void delete(String fileName) {
    try {
      File file = new File(fileName);
      if (!file.delete()) {
        System.err.println("cannot Delete");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

