package service;

import DAO.ArtifactDAO;

import exception.ReadException;
import model.Artifact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArtifactServiceTest {

    private final int example_id = 999;
    private Artifact artifactInitiallyNotUsed;
    private Artifact artifactInitiallyUsed;
    private List<Artifact> artifactsList;

    @InjectMocks
    ArtifactService artifactService;

    @Mock
    ArtifactDAO artifactDAO;

    @BeforeEach
    public void init() throws ReadException {
        MockitoAnnotations.initMocks(this);

        artifactInitiallyNotUsed = new Artifact.Builder()
                .id(example_id)
                .isUsed(false)
                .build();
        artifactInitiallyUsed = new Artifact.Builder()
                .id(example_id)
                .isUsed(true)
                .build();
        artifactsList = new ArrayList<>(Arrays.asList(artifactInitiallyNotUsed, artifactInitiallyUsed));
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenEmptyList() {
        // given
        String[] emptyArray = new String[0];
        List<Artifact> emptyArtifactsList = new ArrayList<>();

        // then
        Assertions.assertThrows(NullPointerException.class, () -> {
            artifactService.callArtifactUsageChange(emptyArray, emptyArtifactsList);
        });
    }

    @Test
    public void shouldChangeArtifactsIsUsedPropertyWhenProvidedBooleanHasDifferentValue() throws ReadException {
        // given
        String[] booleansArray = {"USED", "NOT USED"};

        // when
        artifactService.callArtifactUsageChange(booleansArray, artifactsList);

        // then
        Assertions.assertTrue(artifactInitiallyNotUsed.isUsed());
        Assertions.assertFalse(artifactInitiallyUsed.isUsed());
    }

    @Test
    public void shouldNotChangeArtifactsIsUsedPropertyWhenProvidedBooleanHasSameValue() throws ReadException {
        // given
        String[] booleansArray = {"NOT USED", "USED"};

        // when
        artifactService.callArtifactUsageChange(booleansArray, artifactsList);

        // then
        Assertions.assertFalse(artifactInitiallyNotUsed.isUsed());
        Assertions.assertTrue(artifactInitiallyUsed.isUsed());
    }
}