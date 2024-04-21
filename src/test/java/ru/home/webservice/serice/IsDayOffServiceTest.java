package ru.home.webservice.serice;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class IsDayOffServiceTest {
    ExternalService externalService = mock(ExternalService.class);

    @Test
    public void whenGetContent() throws IOException {
        String expected = "00011100111";
        when(externalService.getContent(anyString(), anyString())).thenReturn(expected);

        String actual = externalService.getContent("2022", "11");
        assertThat(actual).isEqualTo(expected);
    }
}