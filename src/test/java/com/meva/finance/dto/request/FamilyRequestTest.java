package com.meva.finance.dto.request;

import com.meva.finance.entity.Family;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FamilyRequestTest {

    @Mock
    private FamilyRequest familyRequest;

    @Mock
    private Family family;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);

        familyRequest = new FamilyRequest(1, "Vieira");
    }

    @Test
    @DisplayName("test verify id in family and familyResquet convert")
    void convert() {

        family = familyRequest.convert(new Family());

        Assertions.assertEquals(family.getId(), familyRequest.getId());

    }
}