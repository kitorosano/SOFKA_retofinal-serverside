package uy.com.sofka.retofinalserverside.models.Volante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import uy.com.sofka.retofinalserverside.services.IVolanteService;

@Component
public class VolanteListener extends AbstractMongoEventListener<Volante> {
  
  @Autowired
  private IVolanteService service;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Volante> event) {
    if (event.getSource().getNroVolante() < 1) {
        event.getSource().setNroVolante(service.generateSequence(Volante.SEQUENCE_NAME));
    }
  }
}
