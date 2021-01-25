package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.guardian.Guardian;
import com.studentportal.guardian.GuardianRepo;
import com.studentportal.guardian.GuardianServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class GuardianServiceImplTest {
    @InjectMocks
    GuardianServiceImpl guardianService;
    @Mock
    GuardianRepo guardianRepo;
    Guardian guardian =new Guardian();
    List<Guardian> guardianList;
    @Before
    public void setup(){
        guardian =new Guardian();
        guardianList=new ArrayList<>();
        guardian.setName("TEST");
        guardian.setId(4353L);
        guardianList.add(guardian);
    }
    @Test
    public void When_Save_Guardian_it_Should_Return_Guardian() throws StudentPortalException {
        Mockito.when(guardianRepo.getOne(guardian.getId())).thenReturn(guardian);
        Guardian result= guardianService.getById(guardian.getId());
        assertThat(result.getName()).isSameAs(guardian.getName());
    }

    @Test
    public void When_Get_Guardian_Id_Should_Return_Guardian() throws StudentPortalException {

        Mockito.when(guardianRepo.getOne(324L)).thenReturn(guardian);
        Guardian result= guardianService.getById(324L);
        assertThat(result.getId()).isSameAs(guardian.getId());
    }
    @Test
    public void When_getAll_Guardian_Should_Return_GuardianList() throws StudentPortalException {
        Mockito.when(guardianRepo.findAll()).thenReturn(guardianList);
        List<Guardian> result= guardianService.getAll();
        assertThat(result.get(0).getId()).isSameAs(guardian.getId());
    }

}
