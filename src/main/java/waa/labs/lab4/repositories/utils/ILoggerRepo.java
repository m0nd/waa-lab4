package waa.labs.lab4.repositories.utils;

import org.springframework.data.repository.CrudRepository;
import waa.labs.lab4.domain.utils.Logger;

public interface ILoggerRepo extends CrudRepository<Logger, Long> {
}
