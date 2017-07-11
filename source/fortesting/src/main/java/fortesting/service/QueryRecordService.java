package fortesting.service;

import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import fortesting.dao.EmployeeDAO;
import fortesting.dao.IncomeDAO;
import fortesting.dao.model.Employee;
import fortesting.dao.model.Income;
import fortesting.util.HashUtil;

@Service
public class QueryRecordService {
    @Resource
    private EmployeeDAO employeeDao;
    @Resource
    private IncomeDAO incomeDao;
    
    public Set<Income> getRecordById(String id,String pwd) throws NoSuchAlgorithmException {
        return incomeDao.getIncomes(id);
    }
    
    public boolean auth(String id, String pwd) throws NoSuchAlgorithmException {
        Employee employee = employeeDao.getEmployee(id);
        char[] hashedPassword = Hex.encodeHex(HashUtil.hash("SHA-256", pwd.getBytes()));
        return employee != null && id.equals(employee.getEmployee_id()) && checkPassword(hashedPassword, employee.getHash_password().toCharArray());
    }
    
    private boolean checkPassword(char[] userEnter, char[] fromDB) {
        for(int i=0;i<userEnter.length;i++) {
            if(userEnter[i] != (fromDB[i])) {
                return false;
            }
        }
        return true;
    }
}
