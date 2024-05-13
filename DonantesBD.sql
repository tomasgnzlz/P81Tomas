	create database p81Tomas;
	use p81Tomas;
	drop table if exists donantes;

	create table donantes(
		id_paciente int primary key,
		nombre varchar(30),
		fechaNacimiento date,
		grupoSanguineo varchar(5),
		rh varchar(1),
		numeroDonaciones int
	);
