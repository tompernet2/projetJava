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
- Connexion Eleve/Moniteur/Responsable

Partie Eleve:
- Affichage profil
- Modification profil
- Affichage Planning
- Inscription à une leçon
- Affichage de statistiques

---------------


Partie Moniteur:
- Affichage profil
- Modification profil
- Affichage Planning
- Ajout de licences non acquise
- Ajout de la date d'optention de la licence
- Affichage de statistiques

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


Pour installer le projet, il faut installer intellij puis ouvrir le projet.
Ensuite il faut mettre le connecteur qui se trouve ici  : src\main\resources\lib\mysql-connector-java-8.0.30.jar
Pour le mettre il suffit de faire clic droit sur la racine du projet, open module setting, appuyer sur la + pour add JARs or directories puis selectionner le connector. Ensuite il faut cocher le connector et appuer sur apply.
Le connector est placé. 
Pour finir il faut changer le lien de connexion entre le code avec la base données. Il faut aller dans tools/ConnexionBDD et au niveau de la ligne 14 il faut changer autoecoleok par le nom de votre base de données.
Le projet est prêt à être lancé.
