package uy.com.sofka.retofinalserverside.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
public class Usuario {
  @Id
  private String uid;
  private String email;
  private String username;


  public String getUid() {
    return this.uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String toString() {
    return "{" +
      " uid='" + getUid() + "'" +
      ", email='" + getEmail() + "'" +
      ", username='" + getUsername() + "'" +
      "}";
  }
  
}
