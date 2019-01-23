package shark.mybatis.pojo;

import java.util.List;

/**
 * @author zhuhh 2019/1/23
 */
public class Company {

    private Long id;
    private String companyName;
    private List<Department> departments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + companyName + '\'' +
                ", departments=" + departments +
                '}';
    }
}
