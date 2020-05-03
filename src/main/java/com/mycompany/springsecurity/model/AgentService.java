/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springsecurity.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adam
 */
@Service
@SuppressWarnings("StaticNonFinalIntiialization")
public class AgentService {
    public List<Agents> getAllAgents(){
        EntityManager em = DBUtil.getEMF().createEntityManager();
        TypedQuery<Agents> tq = em.createNamedQuery("Agents.findAll", Agents.class);
        
        List<Agents> agentsList = new ArrayList<>();
        
        try{
            agentsList = tq.getResultList();
        }catch(Exception e){
            System.out.println(e);
        }
        
        return agentsList;
        
    }
}
