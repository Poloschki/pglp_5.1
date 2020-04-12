import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneDAO extends DAO<Personnel> {

  @Override
  public Personnel create(Personnel obj) {
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "INSERT INTO personnel (nom,prenom) VALUES(?,?)");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setString(2, obj.prenom);
      int result = preparedStatement.executeUpdate();
      assert result == 1;
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return obj;
  }

  @Override
  public Personnel find(String id) {
    Personnel personnel = new Personnel.Builder("Test", "Tester", "fonction").build();
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "SELECT * FROM personnel WHERE nom = ?");
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        personnel = new Personnel
            .Builder(
            resultSet.getString("nom"),
            resultSet.getString("prenom"),
            resultSet.getString("fonction"))
            .build();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return personnel;
  }

  @Override
  public Personnel update(Personnel obj) {
    Personnel personnel = new Personnel.Builder("Test", "Tester", "fonction").build();
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "UPDATE personnel set nom = ? and set prenom = ? and set fonction = ?  WHERE nom = ?");
      preparedStatement.setString(1, obj.nom);
      preparedStatement.setString(1, obj.prenom);
      preparedStatement.setString(1, obj.fonction);
      preparedStatement.setString(1, obj.nom);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.first()) {
        personnel = new Personnel
            .Builder(
            resultSet.getString("nom"),
            resultSet.getString("prenom"),
            resultSet.getString("fonction"))
            .build();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return personnel;
  }

  @Override
  public void delete(Personnel obj) {
    try {
      PreparedStatement preparedStatement = connect.prepareStatement(
          "DELETE FROM personnel where nom = ? ");
      preparedStatement.setString(1, obj.nom);
      int resultSet = preparedStatement.executeUpdate();
      assert resultSet == 1;
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }
}
