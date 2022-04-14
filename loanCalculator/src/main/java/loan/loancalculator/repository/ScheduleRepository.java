package loan.loancalculator.repository;

import loan.loancalculator.entity.Loan;
import loan.loancalculator.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findById(Long id);
}
