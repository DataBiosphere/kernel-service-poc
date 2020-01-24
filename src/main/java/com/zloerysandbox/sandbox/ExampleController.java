package com.zloerysandbox.sandbox;

import com.zloerysandbox.sandbox.domain.SpendProfile;
import com.zloerysandbox.sandbox.domain.Workspace;
import com.zloerysandbox.sandbox.domain.WorkspaceDataReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(path = "/")
public class ExampleController {

  private final JdbcTemplate template;

  public ExampleController(JdbcTemplate template) {
    this.template = template;
  }

  @GetMapping("/")
  public @ResponseBody String healthCheck() {
    return "Alive";
  }

  @GetMapping("/getWorkspaces")
  public @ResponseBody List<String> getWorkspaces() {
    List<Map<String, Object>> resultSet =  this.template.queryForList("SELECT ws.ID, ws.SPEND_PROFILE_ID, ref.NAME, ref.REFERENCE FROM workspaces ws JOIN workspacesXrefs x on (ws.id = x.workspace_id) JOIN refs ref on (x.ref_id = ref.id) ORDER BY ws.ID");
    List<String> workspaceList = new ArrayList<String>();
    int prevWorkspaceID = -1;
    Workspace currentWorkspace = new Workspace();
    System.out.println(resultSet);
    for (Map<String, Object> result : resultSet) {
      int currentWorkspaceID = Math.toIntExact((long)result.get("id"));
      if (prevWorkspaceID == -1) {
        currentWorkspace.setId(currentWorkspaceID);
        currentWorkspace.setSpendProfile(new SpendProfile((String)result.get("spend_profile_id")));
      } else if (prevWorkspaceID != currentWorkspaceID) {
        workspaceList.add(currentWorkspace.toString());
        currentWorkspace = new Workspace();
        currentWorkspace.setId(currentWorkspaceID);
        currentWorkspace.setSpendProfile(new SpendProfile((String)result.get("spend_profile_id")));
      }
      WorkspaceDataReference dataReference = new WorkspaceDataReference();
      dataReference.setName((String) result.get("name"));
      dataReference.setReference((String) result.get("reference"));
      currentWorkspace.insertDataReference(dataReference);
      prevWorkspaceID = currentWorkspaceID;
    }
    workspaceList.add(currentWorkspace.toString());
    return workspaceList;
    //.stream()
    //     .map((m) -> m.values().toString())
    //     .collect(Collectors.toList());
  }
  @GetMapping("/demo")
  public @ResponseBody List<Map<String, Object>> getDemo() {
    List<Map<String, Object>> resultSet =  this.template.queryForList("SELECT * FROM workspaces");
    return resultSet;
  }
}
