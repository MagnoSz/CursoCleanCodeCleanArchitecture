package com.example.loja.infraestrutura.spring.cupom;

import com.example.loja.infraestrutura.spring.RepositoryGenerico;
import org.springframework.stereotype.Service;

@Service
public class CupomRepository extends RepositoryGenerico<CupomModel, Long> {
   public CupomRepository(CupomDAO cupomDAO){
       super(cupomDAO);
   }
}
