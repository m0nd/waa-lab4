package waa.labs.lab4.repositories.utils;

import org.springframework.data.repository.CrudRepository;
import waa.labs.lab4.domain.utils.ExceptionTracker;

public interface IExceptionTrackerRepo extends CrudRepository<ExceptionTracker, Long> {
}
