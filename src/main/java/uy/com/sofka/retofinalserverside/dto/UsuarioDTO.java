package uy.com.sofka.retofinalserverside.dto;

import java.util.regex.Pattern;


public class UsuarioDTO {
  private String uid;
  private String email;
  private String username;

  public UsuarioDTO() {}


  public String getUid() {
    return this.uid;
  }

  public String getEmail() {
    return this.email;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUid(String uid) {
    // verificar que no sea null o vacio
    if (uid == null || uid.isEmpty()) {
      throw new IllegalArgumentException("El uid no puede ser null o vacio");
    }
    this.uid = uid;
  }

  public void setEmail(String email) {
    // verificar que no sea null o vacio
    if (email == null || email.isEmpty())
      throw new IllegalArgumentException("El email no puede ser vacio");
    // verificar que sea valido
    if(!checkValidEmail(email))
      throw new IllegalArgumentException("El email no es valido");
    this.email = email;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  private boolean checkValidEmail(String email){
    var validPattern = Pattern.compile("^(?=.{1,64}@)[\\p{L}0-9\\+_-]+(\\.[\\p{L}0-9\\+_-]+)*@"
    + "[^-][\\p{L}0-9\\+-]+(\\.[\\p{L}0-9\\+-]+)*(\\.[\\p{L}]{2,})$");
    return validPattern.matcher(email).find();
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
