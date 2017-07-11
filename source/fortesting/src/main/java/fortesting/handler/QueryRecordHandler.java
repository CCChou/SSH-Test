package fortesting.handler;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fortesting.dao.model.Income;
import fortesting.service.QueryRecordService;

@Controller
@RequestMapping(path={"query.handler"})
public class QueryRecordHandler {
    @Resource
    private QueryRecordService service;
    private static final String VIEW_PAGE = "result.view";
    
    @RequestMapping(method={RequestMethod.POST})
    public String getRecordById(String id, String pwd, Model model) {
        try {
            Map<String,String> errors = new LinkedHashMap<>();
            model.addAttribute("errors",errors);
            
            if (StringUtils.isEmpty(id)) {
                errors.put("id","id is required");
            }
            if (StringUtils.isEmpty(pwd)) {
                errors.put("pwd","password is required");
            } 
            if (!errors.isEmpty()) {
                return VIEW_PAGE;
            }

            if(!service.auth(id, pwd)) {
                errors.put("auth", "account doesn't exist or you enter the wrong password");
                return VIEW_PAGE;
            }
            
            Set<Income> incomes = service.getRecordById(id, pwd);
            if(incomes.isEmpty()) {
                errors.put("auth", "there's no record");
                return VIEW_PAGE;
            }
            
            model.addAttribute("results",incomes);
            // TODO setup the logger
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return VIEW_PAGE;
    }

}
