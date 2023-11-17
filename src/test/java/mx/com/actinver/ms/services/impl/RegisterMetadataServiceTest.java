package mx.com.actinver.ms.services.impl;

import lombok.extern.slf4j.Slf4j;
import mx.com.actinver.ms.beans.client.metadata.registerMetadata.RegisterMetadataRequestClientBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataRequestBean;
import mx.com.actinver.ms.beans.metadata.registerMetadata.RegisterMetadataResponseBean;
import mx.com.actinver.ms.clients.IRegisterMetadataClient;
import mx.com.actinver.ms.helpers.IRegisterMetadataRequestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class RegisterMetadataServiceTest {


    @Mock
    private IRegisterMetadataRequestHelper registerMetadataRequestHelper;
    @Mock
    private IRegisterMetadataClient registerMetadataClient;

    @InjectMocks
    private RegisterMetadataService registerMetadataService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterMetadata() {
        // Arrange
        RegisterMetadataRequestBean requestBean = new RegisterMetadataRequestBean();
        RegisterMetadataRequestClientBean requestClientBean = new RegisterMetadataRequestClientBean();
        when(registerMetadataRequestHelper.toRequest(requestBean)).thenReturn(requestClientBean);
        RegisterMetadataResponseBean responseClientBean = new RegisterMetadataResponseBean();
        when(registerMetadataClient.registrationMetadata(requestClientBean)).thenReturn(responseClientBean);

        // Act
        RegisterMetadataResponseBean result = registerMetadataService.registerMetadata(requestBean);

        // Assert
        Assertions.assertEquals(responseClientBean, result);
        verify(registerMetadataRequestHelper, times(1)).toRequest(requestBean);
        verify(registerMetadataClient, times(1)).registrationMetadata(requestClientBean);

    }

}