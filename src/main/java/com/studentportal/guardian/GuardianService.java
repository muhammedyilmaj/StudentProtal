package com.studentportal.guardian;


import com.studentportal.exception.StudentPortalException;

import java.util.List;

public interface GuardianService {
    GuardianDto getById(Long id) throws StudentPortalException;
    List<GuardianDto> getAll() throws StudentPortalException;
    GuardianDto add(Guardian guardian) throws StudentPortalException;
    boolean delete(Long id) throws StudentPortalException;
}
