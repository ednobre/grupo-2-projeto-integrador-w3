package br.com.meli.projetointegrador.model.service;

import br.com.meli.projetointegrador.exception.AgentException;
import br.com.meli.projetointegrador.model.entity.Agent;
import br.com.meli.projetointegrador.model.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgentService {

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent find(String cpf) {
        Optional<Agent> agent = agentRepository.findByCpf(cpf);
        if (agent.isEmpty()) {
            throw new AgentException("Agent nao cadastrado na base!!! Por gentileza realizar o cadastro");
        }
        return agent.get();
    }
}