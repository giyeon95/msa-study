package msa.study.springbootmicroservices.repository;

import msa.study.springbootmicroservices.domain.Multiplication;
import org.springframework.data.repository.CrudRepository;

public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {
}
