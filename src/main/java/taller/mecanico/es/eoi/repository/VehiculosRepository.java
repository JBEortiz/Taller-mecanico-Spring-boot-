package taller.mecanico.es.eoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import taller.mecanico.es.eoi.entity.Reparacion;
import taller.mecanico.es.eoi.entity.Vehiculos;

public interface VehiculosRepository extends JpaRepository<Vehiculos,String> {
	@Query("SELECT u FROM Vehiculos u WHERE u.matricula =: matricula")
	List<Reparacion> findByMatricula_Dni(String matricula);
}
