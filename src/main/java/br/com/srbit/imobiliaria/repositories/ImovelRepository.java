package br.com.srbit.imobiliaria.repositories;

import br.com.srbit.imobiliaria.entities.Imovel;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImovelRepository extends CassandraRepository<Imovel, UUID> {
}
