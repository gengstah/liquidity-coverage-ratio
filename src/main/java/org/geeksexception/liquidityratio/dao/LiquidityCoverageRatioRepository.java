package org.geeksexception.liquidityratio.dao;

import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiquidityCoverageRatioRepository extends JpaRepository<LiquidityCoverageRatio, Long> {
	
}