package org.apache.commons.beanutils.annotations;

import junit.framework.Assert;
import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by buffernihility@gmail.com on 12/28/2015.
 */
public class AnnotationProviderTestCase extends TestCase {
    public void testGetAnnotation() throws Exception {
        Bean bean = new Bean();
        bean.setGrade("GRADE_Bean");
        bean.setName("Foo_Bean");
        Assert.assertTrue("NAME".equals(AnnotationProvider.getInstance().getAnnotation(bean.getClass().getDeclaredField("name"), Alias.class).value()));
        Assert.assertTrue("Grade".equals(AnnotationProvider.getInstance().getAnnotation(bean.getClass().getDeclaredField("grade"), Alias.class).value()));
    }
}

class Bean {
    @Alias("NAME")
    private String name;
    @Alias("ID_Bean")
    private int id;
    @Alias("Grade")
    private String grade;
    @Alias("startdate")
    private Date startDate;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

class BeanVo {
    private String NAME;
    private int ID_Bean;
    private Date startdate;

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String nAME) {
        NAME = nAME;
    }

    public int getID_Bean() {
        return ID_Bean;
    }

    public void setID_Bean(int iD_Bean) {
        ID_Bean = iD_Bean;
    }

}

