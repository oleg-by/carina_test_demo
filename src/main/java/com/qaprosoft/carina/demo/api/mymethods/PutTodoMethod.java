package com.qaprosoft.carina.demo.api.mymethods;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/todos/1", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/todos/_put/rq.json")
@ResponseTemplatePath(path = "api/todos/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PutTodoMethod extends AbstractApiMethodV2 {
    public PutTodoMethod() {
        super("api/todos/_put/rq.json", "api/todos/_put/rs.json", "api/todos/todo.properties");
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
