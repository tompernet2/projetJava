package sio.autoecoleprojet.repositories;

import sio.autoecoleprojet.models.Responsable;
import sio.autoecoleprojet.tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResponsableRepository  implements RepositoryInterface<Responsable, String> {
    private Connection connectionBDD;

    public ResponsableRepository(){
        this.connectionBDD = ConnexionBDD.getCnx();
    }

    @Override
    public void create(Responsable responsable) throws SQLException {

    }

    @Override
    public void update(Responsable responsable) throws SQLException {

    }

    @Override
    public void delete(Responsable responsable) {

    }

    @Override
    public Responsable get(String s) {
        return null;
    }

    @Override
    public ArrayList<Responsable> getAll() throws SQLException {
        return null;
    }

    public Responsable recupResponsableCo(int numCompte) throws SQLException {
        PreparedStatement preparedStatement = connectionBDD.prepareStatement("Select CodeResponsable , nom , prenom , numCompte from Responsable where numCompte = ?");
        preparedStatement.setInt(1,numCompte);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next())
        {
            Responsable.reponsableCo = new Responsable(
                    resultSet.getInt("codeResponsable"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getInt("numCompte"));
        }
        return Responsable.reponsableCo;
    }
}
