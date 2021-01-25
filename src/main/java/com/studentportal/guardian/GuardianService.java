package com.studentportal.guardian;


import com.studentportal.exception.StudentPortalException;

import java.util.List;

public interface GuardianService {
    Guardian getById(Long id) throws StudentPortalException;
    List<Guardian> getAll() throws StudentPortalException;
    Guardian add(Guardian guardian) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
