package com.study.boot.act;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.study.boot.common.util.SpringContextHolder;
import org.flowable.editor.constants.ModelDataJsonConstants;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Carlos
 * @version 1.0
 * @date 2019/5/28 22:20
 */

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private SimpUserRegistry simpUserRegistry;

    public void createModel()throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode editorNode = objectMapper.createObjectNode();
        editorNode.put("id", "canvas");
        editorNode.put("resourceId", "canvas");
        ObjectNode properties = objectMapper.createObjectNode();
        properties.put("process_author", "authoreeeee");
        editorNode.set("properties", properties);
        ObjectNode stencilset = objectMapper.createObjectNode();
        stencilset.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
        editorNode.set("stencilset", stencilset);

        Model model = repositoryService.newModel();
        model.setKey("levelBill");
        model.setName("请假流程");
        model.setCategory("分类");
        model.setVersion(Integer.parseInt(
                String.valueOf(repositoryService.createModelQuery()
                        .modelKey(model.getKey()).count() + 1)));

        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, "请假流程");
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, model.getVersion());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, "流程描述");
        model.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(model);
        repositoryService.addModelEditorSource(model.getId(), editorNode.toString().getBytes("utf-8"));

    }


    @GetMapping
    public void greeting() {
        SimpMessagingTemplate messagingTemplate = SpringContextHolder.getBean(SimpMessagingTemplate.class);
        Set<SimpUser> users = simpUserRegistry.getUsers();
        users.forEach(simpUser -> {
            System.out.println(simpUser.getName());
        });
        messagingTemplate.convertAndSendToUser("admin","/remind","收到了没有啊");
    }
}
