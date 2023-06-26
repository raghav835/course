package com.cms.proxy;

public interface AdmissionProxy {

    void apply(String studentId, String courseId);

    boolean isEnrolled(String studentId, String courseId);

}
