package taller.mecanico.es.eoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import taller.mecanico.es.eoi.entity.Mecanicos;
import taller.mecanico.es.eoi.entity.Reparacion;

public interface MecanicoRepository extends JpaRepository<Mecanicos,String>{
	@Query("SELECT u FROM Mecanicos u WHERE u.dni=:dni")
	List<Reparacion> findByMecanico_Dni(String dni);
	
}
