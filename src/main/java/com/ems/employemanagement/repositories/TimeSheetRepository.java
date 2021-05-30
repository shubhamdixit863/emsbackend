package com.ems.employemanagement.repositories;


import com.ems.employemanagement.entity.Timesheet;
import com.ems.employemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeSheetRepository extends PagingAndSortingRepository<Timesheet,Long> {

    public Page<Timesheet> findByUser(User user, Pageable pageable);

}
