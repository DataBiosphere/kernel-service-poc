package com.zloerysandbox.sandbox.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Workspace {

  private int id;
  private SpendProfile spendProfile;
  private List<WorkspaceDataReference> dataReferenceList;
  private List<WorkspaceResource> resourceList;
  private Map<String, String> metadata;

  public Workspace() {
    id = -1;
    spendProfile = null;
    dataReferenceList = new ArrayList<WorkspaceDataReference>();
    resourceList = new ArrayList<WorkspaceResource>();
    metadata = new HashMap<String,String>();
  }

  public Workspace(int id, SpendProfile spendProfile, List<WorkspaceDataReference> dataReferenceList,
      List<WorkspaceResource> resourceList, Map<String, String> metadata) {
    this.id = id;
    this.spendProfile = spendProfile;
    this.dataReferenceList = dataReferenceList;
    this.resourceList = resourceList;
    this.metadata = metadata;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Workspace workspace = (Workspace) o;
    return id == workspace.id &&
        spendProfile.equals(workspace.spendProfile) &&
        dataReferenceList.equals(workspace.dataReferenceList) &&
        resourceList.equals(workspace.resourceList) &&
        metadata.equals(workspace.metadata);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, spendProfile, dataReferenceList, resourceList, metadata);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public SpendProfile getSpendProfile() {
    return spendProfile;
  }

  public void setSpendProfile(SpendProfile spendProfile) {
    this.spendProfile = spendProfile;
  }

  public List<WorkspaceDataReference> getDataReferenceList() {
    return dataReferenceList;
  }

  public void setDataReferenceList(List<WorkspaceDataReference> dataReferenceList) {
    this.dataReferenceList = dataReferenceList;
  }

  public void insertDataReference(WorkspaceDataReference dataReference) {
    this.dataReferenceList.add(dataReference);
  }

  public List<WorkspaceResource> getResourceList() {
    return resourceList;
  }

  public void setResourceList(List<WorkspaceResource> resourceList) {
    this.resourceList = resourceList;
  }

  public Map<String, String> getMetadata() {
    return metadata;
  }

  public void setMetadata(Map<String, String> metadata) {
    this.metadata = metadata;
  }

  @Override
  public String toString() {
    return "Workspace{" +
        "id=" + id +
        ", spendProfile=" + spendProfile +
        ", dataReferenceList=" + dataReferenceList +
        ", resourceList=" + resourceList +
        ", metadata=" + metadata +
        '}';
  }
}
