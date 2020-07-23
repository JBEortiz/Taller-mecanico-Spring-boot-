package taller.mecanico.es.eoi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import taller.mecanico.es.eoi.entity.Reparacion;

public interface RepacionRepository   extends JpaRepository<Reparacion,Long>{
}
