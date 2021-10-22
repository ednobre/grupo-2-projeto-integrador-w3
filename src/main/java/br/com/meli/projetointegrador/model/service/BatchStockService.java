package br.com.meli.projetointegrador.model.service;

import br.com.meli.projetointegrador.model.dto.AgentDTO;
import br.com.meli.projetointegrador.model.dto.SectionDTO;
import br.com.meli.projetointegrador.model.entity.Agent;
import br.com.meli.projetointegrador.model.entity.BatchStock;
import br.com.meli.projetointegrador.model.entity.Section;
import br.com.meli.projetointegrador.model.repository.BatchStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchStockService {

    private final BatchStockRepository batchStockRepository;
    private final SectionService sectionService;
    private final AgentService agentService;

    public BatchStockService(BatchStockRepository batchStockRepository,
                             SectionService sectionService,
                             AgentService agentService) {
        this.batchStockRepository = batchStockRepository;
        this.sectionService = sectionService;
        this.agentService = agentService;
    }

    public void put(BatchStock batchStock, Section section, Agent agent) {
        Section s = sectionService.find(section.getSectionCode());
        Agent a = agentService.find(agent.getCpf());
        batchStock.agent(a);
        batchStock.section(s);
        batchStockRepository.save(batchStock);
    }

    public void postAll(List<BatchStock> listBatchStock, AgentDTO agentDTO, SectionDTO sectionDTO) {
        listBatchStock.forEach(b -> {
            b.agent(agentService.find(agentDTO.getCpf()));
            b.section(sectionService.find(sectionDTO.getSectionCode()));
        });
        batchStockRepository.saveAll(listBatchStock);
    }

    public void putAll(List<BatchStock> listBatchStock) {
        batchStockRepository.saveAll(listBatchStock);
    }
}
