package org.geeksexception.liquidityratio.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.geeksexception.liquidityratio.dao.LiquidityCoverageRatioRepository;
import org.geeksexception.liquidityratio.model.LiquidityCoverageRatio;
import org.geeksexception.liquidityratio.service.LiquidityCoverageRatioService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class LiquidityCoverageRatioServiceImpl implements
		LiquidityCoverageRatioService {
	
	private @Inject LiquidityCoverageRatioRepository liquidityCoverageRatioRepository;
	
	public LiquidityCoverageRatioServiceImpl() { }
	
	@Transactional(readOnly = false)
	public LiquidityCoverageRatio save(
			LiquidityCoverageRatio liquidityCoverageRatio) {
		return liquidityCoverageRatioRepository.save(liquidityCoverageRatio);
	}
	
	public LiquidityCoverageRatio findLiquidityCoverageRatio(Long id) {
		return liquidityCoverageRatioRepository.findOne(id);
	}

	public List<LiquidityCoverageRatio> findLiquidityCoverageRatios(
			Integer page, Integer size) {
		return liquidityCoverageRatioRepository.findAll(new PageRequest(page, size, new Sort(Sort.Direction.DESC, "id"))).getContent();
	}

}