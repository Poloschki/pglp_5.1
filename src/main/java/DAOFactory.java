public class DAOFactory {
  public static DAO<Personnel> getPersonnelDAO() {
    return new PersonnelDAO();
  }
}
