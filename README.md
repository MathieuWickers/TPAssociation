TPAssociation
=============

TP Programmation 3 avec Laurent Guérin


### Faire fonctionner le projet

1. Importer le projet dans Eclipse (import -> git). Vous aurez normalement les projets JPA, Web et l'archive de la bdd.
2. Extraire et lancer la base de données Derby avec le .bat ou le .sh
3. Sur Eclipse, aller dans la perspective "Database Development" et créer une nouvelle connexion. Choisir une db Derby puis créer un driver derby en utilisant le jar derbyclient-10.9 et en choississant Derby Client JDBC Driver 10.2  
4. Configuration de la connexion à la bdd : 
    * database : association  
    * user name : root  
    * password : admin
5. Ajouter les .jar dans le buildpath
6. Mettre le .jar du projet JPA ainsi que tout les .jar qui se trouve dans le dossier lib du projet JPA dans le dossier WEB-INF/lib du projet web (avec un copier coller)
7. Essayer de lancer les tests du projet JPA et de run le projet Web voir si tout fonctionne


### A faire
* Faire fonctionner la bdd pour que l'historique s'affiche 
* Faire la javadoc
* Terminer les tests unitaires
* (optionnel) Faire du css


