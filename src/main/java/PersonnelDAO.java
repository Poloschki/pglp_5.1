import java.io.*;

public class PersonnelDAO extends DAO<Personnel> {

  @Override
  public void create(Personnel obj) {
    try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("personnelDAO")))) {
      out.writeObject(obj);
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

  @Override
  public Personnel find(String id) throws IOException, ClassNotFoundException {
    Personnel personnel = null;
    try (ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("personnelDAO")))) {
      personnel = (Personnel) input.readObject();
    } catch (EOFException ignored) {

    }
    return personnel;
  }

  @Override
  public void delete(String filename) {
    try {
      File file = new File(filename);
      if (!file.delete()) {
        System.err.println("cannot Delete");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
