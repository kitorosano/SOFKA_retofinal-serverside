package uy.com.sofka.retofinalserverside.models.Factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import uy.com.sofka.retofinalserverside.services.IFacturaService;

@Component
public class FacturaListener extends AbstractMongoEventListener<Factura> {
  
  @Autowired
  private IFacturaService service;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<Factura> event) {
    System.out.println(event.getSource());
    if (event.getSource().getConsecutivo() < 1) {
        event.getSource().setConsecutivo(service.generateSequence(Factura.SEQUENCE_NAME));
    }
  }
}
