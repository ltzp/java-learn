package com.usst.annotate;


import java.sql.Date;

@Table(name = "tb_doctor")
public class Doctor {

    @Cloumn(name = "id", type = "int", pk = true)
    private int id;

    @Cloumn(name = "name", type = "String")
    private String name;

    @Cloumn(name = "sex", type = "String")
    private String sex;

    @Cloumn(name = "operate_nums", type = "int")
    private int operateNums;

    @Cloumn(name = "success_nums", type = "int")
    private int successNums;

    @Cloumn(name = "success_rate", type = "float")
    private float successRate;

    @Cloumn(name = "start_time", type = "date")
    private Date startTime;

    @Cloumn(name = "end_time", type = "date")
    private Date endTime;

    public Doctor() {

    }

    public Doctor(int id, String name, String sex, int operateNums, int successNums, float successRate, Date startTime, Date endTime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.operateNums = operateNums;
        this.successNums = successNums;
        this.successRate = successRate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getOperateNums() {
        return operateNums;
    }

    public void setOperateNums(int operateNums) {
        this.operateNums = operateNums;
    }

    public int getSuccessNums() {
        return successNums;
    }

    public void setSuccessNums(int successNums) {
        this.successNums = successNums;
    }

    public float getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(float successRate) {
        this.successRate = successRate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
