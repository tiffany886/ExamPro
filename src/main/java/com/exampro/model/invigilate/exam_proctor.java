package com.exampro.model.invigilate;

/**
 * @Auther pluto
 * @Date 2023/10/27
 */
public class exam_proctor {
    int recordId;
    int proctorId;
    int examId;

    public exam_proctor(int proctorId, int examId) {
        this.proctorId = proctorId;
        this.examId = examId;
    }

    public exam_proctor(int recordId, int proctorId, int examId) {
        this.recordId = recordId;
        this.proctorId = proctorId;
        this.examId = examId;
    }

    @Override
    public String toString() {
        return "exam_proctor{" +
                "recordId=" + recordId +
                ", proctorId=" + proctorId +
                ", examId=" + examId +
                '}';
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getProctorId() {
        return proctorId;
    }

    public void setProctorId(int proctorId) {
        this.proctorId = proctorId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
