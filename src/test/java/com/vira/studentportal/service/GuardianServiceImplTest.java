package com.vira.studentportal.service;

import com.studentportal.exception.StudentPortalException;
import com.studentportal.guardian.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class GuardianServiceImplTest {

    GuardianServiceImpl guardianService;

    @Mock
    GuardianRepo guardianRepo;
    Guardian guardian = new Guardian();
    List<Guardian> guardianList;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        guardianService = new GuardianServiceImpl(guardianRepo, GuardianMapper.INSTANCE);
        guardian = new Guardian();
        guardianList = new ArrayList<>();
        guardian.setName("TEST");
        guardian.setId(4353L);
        guardianList.add(guardian);
    }
    @Test
    public void When_Save_Guardian_it_Should_Return_Guardian() throws StudentPortalException {
        when(guardianRepo.save(guardian)).thenReturn(guardian);
        GuardianDto result = guardianService.add(GuardianMapper.INSTANCE.guardianToGuardianDto(guardian));
        assertThat(result.getName()).isSameAs(guardian.getName());
    }

    @Test
    public void When_Get_Guardian_Id_Should_Return_Guardian() throws StudentPortalException {

        Mockito.when(guardianRepo.getOne(anyLong())).thenReturn(guardian);
        GuardianDto result = guardianService.getById(324L);
        assertThat(result.getId()).isSameAs(guardian.getId());
    }
    @Test
    public void When_getAll_Guardian_Should_Return_GuardianList() throws StudentPortalException {
        Mockito.when(guardianRepo.findAll()).thenReturn(guardianList);
        List<GuardianDto> result = guardianService.getAll();
        assertThat(result.get(0).getId()).isSameAs(guardian.getId());
    }

}
