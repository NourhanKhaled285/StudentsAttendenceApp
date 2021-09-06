package com.example.attendance;

import java.util.Date;

public class attendance {

    private int attendance_id;
    private int student_id;
    private String attendance_status;
    private Date date;
    private String year;
    public static student studentobj;
    public static course courseobj;

    public course getCourseobj() {
        return courseobj;
    }

    public void setCourseobj(course courseobj) {
        this.courseobj = courseobj;
    }

    public void setAttendance_id(int attendance_id) {
        this.attendance_id = attendance_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setAttendance_status(String attendance_status) {
        this.attendance_status = attendance_status;
    }

    public Date getDate() { return date;}

    public void setDate(Date date) { this.date = date;}

    public String getYear() { return year; }

    public void setYear(String year) { this.year = year; }

    public int getAttendance_id() {
        return attendance_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public String getAttendance_status() {
        return attendance_status;
    }

    public student getstudentObj() {
        return studentobj;
    }

    public void setstudentObj(student obj) {
        this.studentobj = studentobj;
    }
}
