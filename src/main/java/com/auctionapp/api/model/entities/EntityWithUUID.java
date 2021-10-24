package com.auctionapp.api.model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class EntityWithUUID implements Serializable {
  @Id @Type(type = "pg-uuid")
  private UUID uuid;

  public EntityWithUUID() {
      this.uuid = UUID.randomUUID();
  }
}
