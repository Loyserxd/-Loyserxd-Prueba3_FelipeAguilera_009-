CREATE TABLE pelicula(
	idpelicula INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(45) NOT NULL,
    estreno DATE NOT NULL,
    fecha DATE NOT NULL,
    disponible BIT(1) NOT NULL,
    PRIMARY KEY(idpelicula)
);
