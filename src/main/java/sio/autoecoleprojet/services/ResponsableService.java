package sio.autoecoleprojet.services;

import sio.autoecoleprojet.models.Moniteur;
import sio.autoecoleprojet.models.Responsable;
import sio.autoecoleprojet.repositories.MoniteurRepository;
import sio.autoecoleprojet.repositories.ResponsableRepository;

import java.sql.SQLException;

public class ResponsableService {
        private ResponsableRepository responsableRepository;

        public ResponsableService()
        {
            this.responsableRepository = new ResponsableRepository();
        }

        public Responsable recupResponsableCo(int numCompte) throws SQLException {
        return responsableRepository.recupResponsableCo(numCompte);
        }

    }
