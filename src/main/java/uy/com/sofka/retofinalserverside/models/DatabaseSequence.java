package uy.com.sofka.retofinalserverside.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection = "database_sequences")
@Component
public class DatabaseSequence {

  @Id
  private String id;
  private long seq;

  // private long facturaSeq;
  // private long volanteSeq;

  public DatabaseSequence() {}

  public String getId() {
      return id;
  }

  public void setId(String id) {
      this.id = id;
  }

  public long getSeq() {
      return seq;
  }

  public void setSeq(long seq) {
      this.seq = seq;
  }
  
  // public long getFacturaSeq() {
  //   return this.facturaSeq;
  // }

  // public void setFacturaSeq(long facturaSeq) {
  //   this.facturaSeq = facturaSeq;
  // }

  // public long getVolanteSeq() {
  //   return this.volanteSeq;
  // }

  // public void setVolanteSeq(long volanteSeq) {
  //   this.volanteSeq = volanteSeq;
  // }

}
   