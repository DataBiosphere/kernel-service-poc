package com.zloerysandbox.sandbox.domain;

import java.util.Objects;

public class WorkspaceDataReference {

  private int id;
  private String name;
  private String cloningInstructions;
  private boolean isControlled;
  private String referenceType;
  private String reference;

  public WorkspaceDataReference() {
  }

  public WorkspaceDataReference(int id, String name, String cloningInstructions,
      boolean isControlled,
      String referenceType, String reference) {
    this.id = id;
    this.name = name;
    this.cloningInstructions = cloningInstructions;
    this.isControlled = isControlled;
    this.referenceType = referenceType;
    this.reference = reference;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCloningInstructions() {
    return cloningInstructions;
  }

  public void setCloningInstructions(String cloningInstructions) {
    this.cloningInstructions = cloningInstructions;
  }

  public boolean isControlled() {
    return isControlled;
  }

  public void setControlled(boolean controlled) {
    isControlled = controlled;
  }

  public String getReferenceType() {
    return referenceType;
  }

  public void setReferenceType(String referenceType) {
    this.referenceType = referenceType;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkspaceDataReference that = (WorkspaceDataReference) o;
    return id == that.id &&
        isControlled == that.isControlled &&
        Objects.equals(name, that.name) &&
        Objects.equals(cloningInstructions, that.cloningInstructions) &&
        Objects.equals(referenceType, that.referenceType) &&
        Objects.equals(reference, that.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, cloningInstructions, isControlled, referenceType, reference);
  }

  @Override
  public String toString() {
    return "WorkspaceDataReference{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", cloningInstructions='" + cloningInstructions + '\'' +
        ", isControlled=" + isControlled +
        ", referenceType='" + referenceType + '\'' +
        ", reference='" + reference + '\'' +
        '}';
  }
}
