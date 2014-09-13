#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


CREATE TABLE materielRoulant(
        id                   Varchar (30) NOT NULL ,
        marque               Varchar (30) NOT NULL ,
        anneedeconstruction  Date ,
        carburant            Varchar (30) NOT NULL ,
        numimmatr            Varchar (7) ,
        nbdeplaces           Int NOT NULL ,
        kmactuel             Int NOT NULL ,
        validiterexctincteur Date ,
        idtypemateriel       Int ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


CREATE TABLE chauffeur(
        idchauffeur   Varchar (15) NOT NULL ,
        nom           Varchar (30) ,
        prenom        Varchar (30) NOT NULL ,
        datenaissance Date NOT NULL ,
        sexe          Varchar (8) ,
        adresse       Varchar (40) NOT NULL ,
        codepostal    Int ,
        ville         Varchar (30) NOT NULL ,
        numtelephone  Varchar (11) NOT NULL ,
        email         Varchar (30) ,
        numcartesis   Varchar (11) NOT NULL ,
        numpermis     Varchar (11) ,
        PRIMARY KEY (idchauffeur )
)ENGINE=InnoDB;


CREATE TABLE eleve(
        ideleve          Varchar (30) NOT NULL ,
        nomeleve         Varchar (30) ,
        prenomeleve      Varchar (30) ,
        datedenaissance  Date ,
        sexe             Varchar (8) NOT NULL ,
        adresseeleve     Varchar (40) NOT NULL ,
        codepostal       Int ,
        ville            Varchar (30) ,
        nomresponsable   Varchar (30) NOT NULL ,
        telresponsable   Varchar (11) NOT NULL ,
        emailresponsable Varchar (30) ,
        idcircuit        Int NOT NULL ,
        idecole          Int NOT NULL ,
        PRIMARY KEY (ideleve )
)ENGINE=InnoDB;


CREATE TABLE utilisationCarte(
        idutilisation   int (11) Auto_increment  NOT NULL ,
        dateutilisation Date ,
        litrecarburant  Int NOT NULL ,
        kmutilisation   Int NOT NULL ,
        id              Varchar (30) NOT NULL ,
        idcarte         Int ,
        idchauffeur     Varchar (15) NOT NULL ,
        PRIMARY KEY (idutilisation ) ,
        INDEX (dateutilisation )
)ENGINE=InnoDB;


CREATE TABLE documentsAdministratifs(
        iddocument    int (11) Auto_increment  NOT NULL ,
        datevaliditer Date NOT NULL ,
        id            Varchar (30) NOT NULL ,
        idchauffeur   Varchar (15) NOT NULL ,
        idtype        Int ,
        PRIMARY KEY (iddocument )
)ENGINE=InnoDB;


CREATE TABLE circuit(
        idcircuit  int (11) Auto_increment  NOT NULL ,
        nomcircuit Varchar (30) NOT NULL ,
        tempsprevu TimeStamp NOT NULL ,
        idecole    Int NOT NULL ,
        PRIMARY KEY (idcircuit )
)ENGINE=InnoDB;


CREATE TABLE entretien(
        identretien     int (11) Auto_increment  NOT NULL ,
        description     Varchar (30) ,
        kmentretienfait Int NOT NULL ,
        dateentretien   Date NOT NULL ,
        id              Varchar (30) NOT NULL ,
        PRIMARY KEY (identretien ) ,
        INDEX (dateentretien )
)ENGINE=InnoDB;


CREATE TABLE carteCarburant(
        idcarte  int (11) Auto_increment  NOT NULL ,
        numcarte Varchar (25) ,
        PRIMARY KEY (idcarte ) ,
        INDEX (numcarte )
)ENGINE=InnoDB;


CREATE TABLE ecole(
        idecole      int (11) Auto_increment  NOT NULL ,
        nomecole     Varchar (30) NOT NULL ,
        adresseecole Varchar (30) NOT NULL ,
        cdpostal     Int NOT NULL ,
        vil          Varchar (30) NOT NULL ,
        telecole     Varchar (11) NOT NULL ,
        emailecole   Varchar (30) ,
        nomdirecteur Varchar (30) ,
        PRIMARY KEY (idecole )
)ENGINE=InnoDB;


CREATE TABLE arrets(
        idarrets      int (11) Auto_increment  NOT NULL ,
        adressearrets Varchar (40) NOT NULL ,
        codepostale   Int ,
        ville         Varchar (30) ,
        PRIMARY KEY (idarrets )
)ENGINE=InnoDB;


CREATE TABLE trajets(
        idtrajets    int (11) Auto_increment  NOT NULL ,
        heurededebut TimeStamp ,
        heuredefin   TimeStamp ,
        datetravail  Date ,
        kmdepart     Int ,
        kmfin        Int ,
        idchauffeur  Varchar (15) NOT NULL ,
        idcircuit    Int NOT NULL ,
        id           Varchar (30) NOT NULL ,
        PRIMARY KEY (idtrajets ) ,
        INDEX (datetravail )
)ENGINE=InnoDB;


CREATE TABLE type(
        idtype          int (11) Auto_increment  NOT NULL ,
        libelledocument Varchar (30) ,
        PRIMARY KEY (idtype )
)ENGINE=InnoDB;


CREATE TABLE typeMaterielRoulant(
        idtypemateriel int (11) Auto_increment  NOT NULL ,
        typeMateriel   Varchar (25) ,
        PRIMARY KEY (idtypemateriel )
)ENGINE=InnoDB;


CREATE TABLE amendes(
        idamendes   int (11) Auto_increment  NOT NULL ,
        numeroPv    Varchar (11) ,
        datePv      Date ,
        montantPv   Integer ,
        id          Varchar (30) NOT NULL ,
        idchauffeur Varchar (15) NOT NULL ,
        PRIMARY KEY (idamendes )
)ENGINE=InnoDB;


CREATE TABLE contient(
        idcircuit Int NOT NULL ,
        idarrets  Int NOT NULL ,
        PRIMARY KEY (idcircuit ,idarrets )
)ENGINE=InnoDB;

ALTER TABLE materielRoulant ADD CONSTRAINT FK_materielRoulant_idtypemateriel FOREIGN KEY (idtypemateriel) REFERENCES typeMaterielRoulant(idtypemateriel);
ALTER TABLE eleve ADD CONSTRAINT FK_eleve_idcircuit FOREIGN KEY (idcircuit) REFERENCES circuit(idcircuit);
ALTER TABLE eleve ADD CONSTRAINT FK_eleve_idecole FOREIGN KEY (idecole) REFERENCES ecole(idecole);
ALTER TABLE utilisationCarte ADD CONSTRAINT FK_utilisationCarte_id FOREIGN KEY (id) REFERENCES materielRoulant(id);
ALTER TABLE utilisationCarte ADD CONSTRAINT FK_utilisationCarte_idcarte FOREIGN KEY (idcarte) REFERENCES carteCarburant(idcarte);
ALTER TABLE utilisationCarte ADD CONSTRAINT FK_utilisationCarte_idchauffeur FOREIGN KEY (idchauffeur) REFERENCES chauffeur(idchauffeur);
ALTER TABLE documentsAdministratifs ADD CONSTRAINT FK_documentsAdministratifs_id FOREIGN KEY (id) REFERENCES materielRoulant(id);
ALTER TABLE documentsAdministratifs ADD CONSTRAINT FK_documentsAdministratifs_idchauffeur FOREIGN KEY (idchauffeur) REFERENCES chauffeur(idchauffeur);
ALTER TABLE documentsAdministratifs ADD CONSTRAINT FK_documentsAdministratifs_idtype FOREIGN KEY (idtype) REFERENCES type(idtype);
ALTER TABLE circuit ADD CONSTRAINT FK_circuit_idecole FOREIGN KEY (idecole) REFERENCES ecole(idecole);
ALTER TABLE entretien ADD CONSTRAINT FK_entretien_id FOREIGN KEY (id) REFERENCES materielRoulant(id);
ALTER TABLE trajets ADD CONSTRAINT FK_trajets_idchauffeur FOREIGN KEY (idchauffeur) REFERENCES chauffeur(idchauffeur);
ALTER TABLE trajets ADD CONSTRAINT FK_trajets_idcircuit FOREIGN KEY (idcircuit) REFERENCES circuit(idcircuit);
ALTER TABLE trajets ADD CONSTRAINT FK_trajets_id FOREIGN KEY (id) REFERENCES materielRoulant(id);
ALTER TABLE amendes ADD CONSTRAINT FK_amendes_id FOREIGN KEY (id) REFERENCES materielRoulant(id);
ALTER TABLE amendes ADD CONSTRAINT FK_amendes_idchauffeur FOREIGN KEY (idchauffeur) REFERENCES chauffeur(idchauffeur);
ALTER TABLE contient ADD CONSTRAINT FK_contient_idcircuit FOREIGN KEY (idcircuit) REFERENCES circuit(idcircuit);
ALTER TABLE contient ADD CONSTRAINT FK_contient_idarrets FOREIGN KEY (idarrets) REFERENCES arrets(idarrets);
