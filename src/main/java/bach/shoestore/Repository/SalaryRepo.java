package bach.shoestore.Repository;

import bach.shoestore.Entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepo extends JpaRepository<Salary, Integer> {
    List<Salary> getBySalary (double salary);
    List<Salary> getByWorkDay (int salary);
}
