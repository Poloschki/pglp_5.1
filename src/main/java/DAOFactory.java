public class DAOFactory {
  public static DAO<Personnel> getPersonnelDAO() {
    return new PersonnelDAO();
  }

  public static DAO<CompositeDAO> getCompositeDAO() {
    return new CompositeDAO();
  }
}
