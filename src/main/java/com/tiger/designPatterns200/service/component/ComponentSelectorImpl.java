package com.tiger.designPatterns200.service.component;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiger.designPatterns200.entity.component.CaseEntity;
import com.tiger.designPatterns200.entity.component.ComponentEntity;
import com.tiger.designPatterns200.entity.component.CoolerEntity;
import com.tiger.designPatterns200.entity.component.CpuEntity;
import com.tiger.designPatterns200.entity.component.GpuEntity;
import com.tiger.designPatterns200.entity.component.MotherboardEntity;
import com.tiger.designPatterns200.entity.component.PowerUnitEntity;
import com.tiger.designPatterns200.entity.component.RamEntity;
import com.tiger.designPatterns200.entity.component.StorageEntity;
import com.tiger.designPatterns200.exception.factory.ComponentCollectionException;
import com.tiger.designPatterns200.exception.factory.ComponentSelectorException;
import com.tiger.designPatterns200.exception.factory.NoFittingComponentFoundException;
import com.tiger.designPatterns200.model.component.CompatibilityComponent;
import com.tiger.designPatterns200.model.component.ComponentCollections;
import com.tiger.designPatterns200.model.component.SelectedComponents;
import com.tiger.designPatterns200.service.factory.computerFactory.ComputerInfo;

/**
 * @author OMISTAJA
 * Selects components based on the budget and the weights of the multipliers found in the ComputerInfo 
 * and filters compatible components to the motherboard and the gpu
 */
@Service
public class ComponentSelectorImpl implements ComponentSelector {
    private ComponentCollections collections;
    private CompatibilityComponent motherboard;
    private CompatibilityComponent gpu;

    /**
     * @param dao
     */
    public ComponentSelectorImpl(ComponentCollectionsDAO dao) {
        this.collections = dao.getComponentCollections();
    }   

	/**
	 * @param <T>
	 * @param budget
	 * @param multiplier
	 * @param entities
	 * @param compatibilityChecks
	 * @return
	 * @throws ComponentSelectorException
	 */
	private <T extends ComponentEntity> T selectComponent(float budget, float multiplier,
    		List<T> entities, CompatibilityComponent... compatibilityChecks) throws ComponentSelectorException {
		
		if(entities==null || entities.size()==0) {
			throw new ComponentCollectionException(entities.getClass().getName());
		}
		
        float maxPrice = budget * multiplier;
        ComponentEntity entity = ComponentFilterer.findBestMatch(maxPrice, entities, compatibilityChecks);
       
        if(entity==null) {
        	throw new NoFittingComponentFoundException("couldn't find fitting component ");
        }
        return (T) entity;
    }
    
  
    /**
     * @param info
     * @return
     * @throws ComponentSelectorException
     */
    private MotherboardEntity selectMotherboard(ComputerInfo info) throws ComponentSelectorException{
    	MotherboardEntity mb = (MotherboardEntity) selectComponent(info.getBudget(),info.getX_motherboard(), collections.motherboards());
    	this.motherboard = mb;
    	return mb;
    }
  
    /**
     * @param info
     * @return
     * @throws ComponentSelectorException
     */
    private CaseEntity selectCase(ComputerInfo info) throws ComponentSelectorException{
    	CaseEntity caseEntity = (CaseEntity) selectComponent(info.getBudget(), info.getX_case(), collections.cases(),motherboard,gpu);	
    	return caseEntity; 
    }

    /**
     * @param info
     * @return
     * @throws ComponentSelectorException
     */
    private CoolerEntity selectCpuCooler(ComputerInfo info) throws ComponentSelectorException{
    	return (CoolerEntity) selectComponent(info.getBudget(), info.getX_cooler(), collections.coolers(),motherboard);
    }

    /**
     * @param info
     * @return
     * @throws ComponentSelectorException
     */
    private CpuEntity selectCpu(ComputerInfo info) throws ComponentSelectorException{
        return (CpuEntity) selectComponent(info.getBudget(), info.getX_cpu(), collections.cpus(),motherboard);
    }

	/**
	 * @param info
	 * @return
	 * @throws ComponentSelectorException
	 */
	private GpuEntity selectGpu(ComputerInfo info) throws ComponentSelectorException{
		GpuEntity gpu = (GpuEntity) selectComponent(info.getBudget(),info.getX_gpu(), collections.gpus(),motherboard);
		this.gpu = gpu;
		return gpu;
	}


	/**
	 * @param info
	 * @return
	 * @throws ComponentSelectorException
	 */
	private PowerUnitEntity selectPowerUnit(ComputerInfo info) throws ComponentSelectorException{
		return (PowerUnitEntity) selectComponent(info.getBudget(),info.getX_powerUnit(),collections.powerUnits(),gpu);
	}

	/**
	 * @param info
	 * @return
	 * @throws ComponentSelectorException
	 */
	private RamEntity selectRam(ComputerInfo info) throws ComponentSelectorException{
		return (RamEntity) selectComponent(info.getBudget(),info.getX_ram(),collections.rams(),motherboard);
	}

	/**
	 * @param info
	 * @return
	 * @throws ComponentSelectorException
	 */
	private StorageEntity selectStorage(ComputerInfo info) throws ComponentSelectorException{
		return (StorageEntity) selectComponent(info.getBudget(),info.getX_storage(),collections.storages(),motherboard);
	}

	/**
	 * selecting components in certain order is important
	 */
	@Override
	public SelectedComponents selectComponents(ComputerInfo info) {
		
		SelectedComponents components;
		try {
			components = new SelectedComponents(
					selectMotherboard(info),
					selectGpu(info),
					selectCase(info),
					selectCpuCooler(info),
					selectCpu(info),
					selectPowerUnit(info),
					selectRam(info),
					selectStorage(info)
						);
			return components;
		} catch (ComponentSelectorException e) {
			e.printStackTrace();
			return null;
		}
		
	
	}


}
