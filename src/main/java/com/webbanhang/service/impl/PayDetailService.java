package com.webbanhang.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webbanhang.converter.PayDetailConverter;
import com.webbanhang.dto.PayDTO;
import com.webbanhang.dto.PayDetailDTO;
import com.webbanhang.entity.PayDetailEntity;
import com.webbanhang.entity.PayEntity;
import com.webbanhang.entity.ProductAddEntity;
import com.webbanhang.repository.PayDetailRepository;
import com.webbanhang.repository.PayRepository;
import com.webbanhang.repository.ProductAddRepository;
import com.webbanhang.service.IPayDetailService;

@Service
public class PayDetailService implements IPayDetailService{

	@Autowired
	private PayDetailRepository payDetailRepository;
	
	@Autowired
	private PayRepository payRepository;
	
	@Autowired
	private PayDetailConverter payDetailConverter;
	
	@Autowired
	private ProductAddRepository productAddRepository;

	@Override
	public List<PayDetailDTO> findAll(Pageable pageable) {
		List<PayDetailDTO> payDetailDTOs = new ArrayList<>();
		List<PayDetailEntity> payDetailentities = payDetailRepository.findAll(pageable).getContent();
		for (PayDetailEntity item: payDetailentities) {
			PayDetailDTO payDetailDTO = payDetailConverter.toDto(item);
			payDetailDTOs.add(payDetailDTO);
		}
		return payDetailDTOs;
	}

	@Override
	public int getTotalItem() {
		return (int) payDetailRepository.count();
	}

	@Override
	public PayDetailDTO findById(long id) {
		PayDetailEntity payDetailEntity = payDetailRepository.findOne(id);
		return payDetailConverter.toDto(payDetailEntity);
	}

	@Override
	@Transactional
	public PayDetailDTO save(PayDetailDTO payDetailDTO) {
		PayEntity payEntity = payRepository.findOne(payDetailDTO.getPaycode());
		PayDetailEntity payDetailEntity = new PayDetailEntity();
		if (payDetailDTO.getId() != null) {
			PayDetailEntity oldPayDetail = payDetailRepository.findOne(payDetailDTO.getId());
			payDetailEntity = payDetailConverter.toEntityAdmin(payDetailDTO, oldPayDetail ,payEntity);
		} else {			
			payDetailEntity = payDetailConverter.toEntityAdmin(payDetailDTO, payDetailEntity ,payEntity);
		}
		return payDetailConverter.toDto(payDetailRepository.save(payDetailEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			payDetailRepository.delete(id);
		}
	}

	
//	web
	@Override
	@Transactional
	public PayDTO save (PayDTO payDTO) {				
		PayEntity  payEntity = payRepository.findOne(payDTO.getId());		
		PayDetailEntity payDetailEntity = new PayDetailEntity();		
		List<ProductAddEntity> productAddEntities = productAddRepository.findAll();
			
		for (ProductAddEntity productAddEntity : productAddEntities) {					
			payDetailEntity = payDetailConverter.toEntity(productAddEntity, payEntity);	
			payDetailRepository.save(payDetailEntity);
		}
		
			
//			cái này return tạm
		    return payDTO;
	}
		
	@Override
	public List<PayDetailDTO> findAllByPay(Long id) {
		List<PayDetailDTO> payDetailDTOs = new ArrayList<>();
		List<PayDetailEntity> payDetailentities = payDetailRepository.findAll();
		for (PayDetailEntity item: payDetailentities) {
			if (item.getPay().getId() == id) {
				PayDetailDTO payDetailDTO = payDetailConverter.toDto(item);
				payDetailDTOs.add(payDetailDTO);
			}
		}
		return payDetailDTOs;
		
	}	

}
