package com.client.outh.dto;

import java.io.Serializable;

public class MensajeDto implements Serializable {

  private String text;

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public MensajeDto() {
    super();
  }

  public MensajeDto(String text) {
    super();
    this.text = text;
  }

  private static final long serialVersionUID = 3172065912797929118L;

}
