package com.tiger.designPatterns200.service.shoppingCart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.designPatterns200.entity.shoppingCart.CartItemEntity;
import com.tiger.designPatterns200.model.component.Computer;
import com.tiger.designPatterns200.model.shoppingCart.CartItemDTO;
import com.tiger.designPatterns200.model.shoppingCart.ShoppingCart;
import com.tiger.designPatterns200.repository.shoppingCart.CartItemRepository;
import com.tiger.designPatterns200.service.component.ComponentService;
import com.tiger.designPatterns200.util.ComponentMapper;



/**
 * 
 * @author OMISTAJA
 * Shopping cart implementation had to be done comparing individual components because the actual items are 
 * random generated
 */
@Service
@Transactional
public class CartLoggedOffService implements ShoppingCart{ 
	private ComponentService componentService;
	private CartItemRepository cartItemRepository;


	
	


	public CartLoggedOffService(ComponentService componentService, CartItemRepository cartItemRepository) {
		this.componentService = componentService;
		this.cartItemRepository = cartItemRepository;
	}


	@Override
	public void addItem(CartItemDTO cartItemDTO, String token) {
		if(token==null) {
			return;
		}
		
		Computer computer = componentService.createComputerFromDTO(cartItemDTO);
		CartItemEntity cartItemEntity = ComponentMapper.computerToCartItemEntity(computer);
		cartItemEntity.setToken(token);
		cartItemRepository.save(cartItemEntity);
	}


	@Override
	public void removeItem(CartItemDTO cartItem, String token) {
		if(token==null) {
			return;
		}
		List<CartItemEntity>items = cartItemRepository.findAll();
		for(CartItemEntity item : items) {
			if(matches(cartItem,item)) {
				cartItemRepository.deleteById(item.getId());
				return;
			}
		}
		throw new IllegalStateException("item not found?");
	}

	public boolean matches(CartItemDTO dto, CartItemEntity entity) {
		return dto.getMotherboardId() == entity.getMotherboard().getId()
			&& dto.getCaseId() == entity.getCaseEntity().getId()
			&& dto.getCpuId() == entity.getCpu().getId()
			&& dto.getCpuCoolerId() == entity.getCooler().getId()
			&& dto.getGpuId() == entity.getGpu().getId()
			&& dto.getRamId() == entity.getRam().getId()
			&& dto.getStorageId() == entity.getStorage().getId()
			&& dto.getPowerUnitId() == entity.getPowerUnit().getId();
	}

	@Override
	public void clear(String token) {
		if(token==null) {
			return;
		}
		cartItemRepository.deleteAllByToken(token);
	}


	@Override
	public List<Computer> view(String token) {
		if(token==null) {
			return null;
		}
		List<CartItemEntity>items = cartItemRepository.findAllByToken(token);
		List<Computer>computers = new ArrayList<>();
		for(CartItemEntity e : items) {
			computers.add(componentService.createComputerFromCartItem(e));
		}
		return computers;
	}
	
	

	@Override
	public int getSize(String token) {
		if(token==null) {
			return 0;
		}
		List<CartItemEntity>items = cartItemRepository.findAllByToken(token);
		return items.size();
		
	} 







	
}
