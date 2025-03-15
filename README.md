ELEVE test : 

Login : rat

Mot de passe : rat

---------------

MONITEUR test : 

Login : polo95

Mot de passe : rat

---------------

RESPONSABLE test :

Login : rok

Mdp : rat

---------------


Réalisation : 
- Inscription d'un nouvel élève
- Connexion Eleve/Moniteur

Partie Eleve:
- Affichage profil
- Modification profil
- Affichage Planning
- Début de l'inscription a la lecon (affichage des moniteur disponible et véhicules suivant la date, l'heure et le type de permis)

---------------


Partie Moniteur:
- Affichage profil
- Modification profil
- Affichage Planning
- Ajout de licences non acquise
- Ajout de la date d'optention de la licence

---------------


Partie Responsable:
- Se connecter ok
- Ajouter un véhicule : ok
- Modifier un véhicule : ok
- Ajouter une nouvelle catégorie : ok
- Modifier une catégorie : ok
- Ajouter un nouveau moniteur : ok
- Visualiser le planning des leçons : ok
- Visualiser le planning d’un moniteur : ok
- Visualiser le planning d’un élève : ok

---------------

- Mot de passe haché

BDD modifié (src\main\resources\BDD\autoecole.sql)
-ajout d'une table compte 
-ajout d'une colonne codeCategorie dans lecon
