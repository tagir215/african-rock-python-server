package com.tiger.designPatterns200.service.component;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.model.component.ComponentCollections;
import com.tiger.designPatterns200.repository.component.ComponentRepository;;

/**
 * @author OMISTAJA
 * Used for uploading the component data to mysql
 */
@Service
public class ComponentUploadService {
	
	private ComponentRepository componentRepository;
	
	/**
	 * @param componentRepository
	 */
	public ComponentUploadService(ComponentRepository componentRepository) {
		this.componentRepository = componentRepository;
	}

	/**
	 * @param collections
	 */
	@Transactional
	public void saveGenericComponents(ComponentCollections collections) {
		
		componentRepository.saveAll(collections.cases());
		componentRepository.saveAll(collections.coolers());
		componentRepository.saveAll(collections.cpus());
		componentRepository.saveAll(collections.rams());
		componentRepository.saveAll(collections.powerUnits());
		componentRepository.saveAll(collections.storages());
	}
	
	/**
	 * @param list
	 * @param startIndex
	 * @param endIndex
	 */
	public void saveCollectionInParts(List<ComponentEntity>list,int startIndex, int endIndex) {
		for(int i=startIndex; i<endIndex; i++) {
			componentRepository.save(list.get(i));
		}
	}
	
	

	/**
	 * @param list
	 */
	private void checkDuplicates(List<ComponentEntity>list) {
		HashMap<Long,Boolean>map = new HashMap<>();
		for(ComponentEntity e : list) {
			if(map.get(e.getId())!=null) {
				throw new IllegalStateException("duplicate value "+e.getId()+" {"+e.getName());
			}
			map.put(e.getId(), true);
		}
	}
	
	
}

