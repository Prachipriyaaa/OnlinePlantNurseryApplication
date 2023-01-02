package com.cg.opna.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.opna.entity.Planter;

@Repository
public interface IPlanterRepository extends JpaRepository<Planter, Integer> {

}
