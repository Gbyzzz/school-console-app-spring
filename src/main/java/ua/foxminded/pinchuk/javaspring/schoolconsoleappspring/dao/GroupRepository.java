package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.bean.Group;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    @Query("select new map(g, size(g.students)) from Group g where size(g.students) <= :num")
    List<Map<Integer, Object>> findGroupsByStudentsIsGreaterThanAndStudentsIn(int num);
}
